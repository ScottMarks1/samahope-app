package samahope.samahopeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                settings(v);

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage(view);
            }
        });
    }

/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }*/

/*    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    public void edit(View view) {
        Intent intent = new Intent(this,EditActivity.class);
        startActivity(intent);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this,SendMessage.class);
        startActivity(intent);
    }

    public void settings(View view) {
        Intent intent = new Intent(this,SettingsMain.class);
        startActivity(intent);
    }

    public void messages(View view) {

        Intent intent = new Intent(this, MessagesActivity.class);
        startActivity(intent);
    }

    public void contacts(View view) {
        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);
    }

    public void stored(View view) {
        Intent intent = new Intent(this, StoredActivity.class);
        startActivity(intent);
    }

    public void deleted(View view) {
        Intent intent = new Intent(this, DeletedActivity.class);
        startActivity(intent);
    }

}
