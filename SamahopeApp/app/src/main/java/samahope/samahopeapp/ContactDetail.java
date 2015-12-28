package samahope.samahopeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by samsung on 12/28/2015.
 */
public class ContactDetail extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_detail);
    }

    public void backToContacts(View view){
        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);
    }

    public void sendMessageToContact(View v) {
        Intent intent = new Intent(this, SendMessageToContact.class);
        startActivity(intent);
    }
}
