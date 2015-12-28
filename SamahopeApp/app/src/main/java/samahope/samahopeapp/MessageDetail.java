package samahope.samahopeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by samsung on 12/28/2015.
 */
public class MessageDetail extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_detail);
    }

    public void backToMessages(View view){
        Intent intent = new Intent(this, MessagesActivity.class);
        startActivity(intent);
    }
}
