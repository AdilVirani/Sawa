package io.sawa.android.sawa;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ListActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Accounts extends ListActivity {
    String[] classFunctions = {"M-Pesa", "Add New", "Test", "Close"};
    String[] classNames = {"ShowDetails", "Accounts", "SMSReceiver", ""};

    IntentFilter intentfilter;

    private BroadcastReceiver intentReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            TextView details = (TextView) findViewbyId(R.id.details);
            details.setText(intent.getExtras().getString("sms"));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArratyAdapter<String>(this, android.R.layout.simple_list_item_1, classFunctions));

        intentFilter = new IntentFilter();
        intentFilter.addAction("SMS_RECEIVED_ACTION");
    }

    protected void onLIstItemClick(ListView lv, View v, int position, long id)
    {
        super.onListItemClick(lv, v, position, id);
        String openDetails = classNames[position];
        try
        {
            Class selected = Class.forName("io.sawa.android.sawa." + openDetails);
            Intent selectedIntent = new Intent(this, selected);
            startActivity(selectedIntent);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

    }
}


