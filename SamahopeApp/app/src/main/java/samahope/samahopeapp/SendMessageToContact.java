package samahope.samahopeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by samsung on 12/28/2015.
 */
public class SendMessageToContact extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_message_to_contact);
    }

    public void backToContact(View view){
        Intent intent = new Intent(this, ContactDetail.class);
        startActivity(intent);
    }
}
