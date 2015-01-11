package io.sawa.android.sawa;

import android.app.ListActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ShowDetails extends ListActivity {
    IntentFilter intentFilter;

    private BroadcastReceiver intentReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            TextView details = (TextView) findViewById(R.id.details);
            details.setText(intent.getExtras().getString("sms"));
        }
    }; 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        intentFilter = new IntentFilter();
        intentFilter.addAction("SMS_RECEIVED_ACTION");

    }

    protected void onResume(){

        registerReceiver(intentReceiver, intentFilter);
        super.onResume();

    }

    protected void onPause(){

        unregisterReceiver(intentReceiver);
        super.onPause();

    }
}