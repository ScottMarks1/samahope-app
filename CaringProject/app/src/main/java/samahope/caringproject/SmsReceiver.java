package samahope.caringproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;
import java.util.ArrayList;

public class SmsReceiver extends BroadcastReceiver
{
    ArrayList<String[]> table;
    SmsReceiver(ArrayList<String[]> table) {
        this.table = table;
    }
    @Override
    public void onReceive(Context context, Intent intent)
    {
        //---get the SMS message passed in---
        Bundle bundle = intent.getExtras();
        if (bundle != null)
        {
            //---retrieve the SMS message received---
            Object[] pdus = (Object[]) bundle.get("pdus");
            ArrayList<String> msgs = new ArrayList<String();
            SmsMessage msg = SmsMessage.createFromPdu((byte[]) pdus[0]);
            String str = msg.getMessageBody().toString();
            long timeStamp = msg.getTimestampMillis();
            String sender = msg.getOriginatingAddress();
            if(pdus.length > 1) {
                for (int i = 1; i < pdus.length; i++) {
                    SmsMessage msgNew = SmsMessage.createFromPdu((byte[]) pdus[i]);
                    String strNew = msgNew.getMessageBody().toString();
                    String senderNew = msgNew.getOriginatingAddress();
                    long timeStampNew = msgNew.getTimestampMillis();
                    if(textCombine(timeStamp, timeStampNew, sender, senderNew)) {
                        str = str + strNew;
                    }
                    else {
                        msgs.add(str);
                        str = strNew;
                    }
                    timeStamp = timeStampNew;
                }
            }
            for(String s : msgs) {
                ParseTexts.addDataToTable(s, table);
            }
        }
    }
    public boolean textCombine(long time1, long time2, String sender1, String sender2) {
        time1 += 100;
        if (time1 <= time2 && sender1 == sender2) {
            return true;
        } else {
            return false;
        }
    }
}