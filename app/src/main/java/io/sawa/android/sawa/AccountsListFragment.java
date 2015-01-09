package io.sawa.android.sawa;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class AccountsListFragment extends Fragment {

    public AccountsListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Create some dummy data for the ListView.  Here's a sample weekly forecast
        String[] data = {
                "M-Pesa: Ksh 500",
                "Safaricom Airtime: Ksh 200",
                "Safaricom Data: 20 MB",
        };
        List<String> weekForecast = new ArrayList<String>(Arrays.asList(data));

        ArrayAdapter<String> forecastAdapter =
                new ArrayAdapter<String>(
                        getActivity(), // The current context (this activity)
                        R.layout.list_item_account, // The name of the layout ID.
                        R.id.list_item_account_textview, // The ID of the textview to populate.
                        weekForecast);

        View rootView = inflater.inflate(R.layout.fragment_accounts, container, false);

        // Get a reference to the ListView, and attach this adapter to it.
        ListView listView = (ListView) rootView.findViewById(R.id.listview_accounts);
        listView.setAdapter(forecastAdapter);

        return rootView;
    }
}