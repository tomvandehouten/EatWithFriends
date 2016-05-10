package edu.wm.eatwithfriends;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LocationsActivity extends AppCompatActivity {

    String tag = "Output for the grader";

    // Array of strings storing country names
    String[] diningHalls = new String[] {
            "Sadler Center",
            "Commons",
            "Marketplace",
            "Student Xchange",
            "Cosi",
            "BBQ 1693",
            "Wholly Habaneros",
            "Aromas",
            "Mooyah",
            "Pita Pit",
            "The Crust",
            "Dodge Room",
            "Boehly Cafe",
            "Argo Tea",
            "Domino's Pizza",
            "Chancellor's Bistro"
    };

    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] images = new int[] {
            R.drawable.sadler,
            R.drawable.commons,
            R.drawable.marketplace,
            R.drawable.xchange,
            R.drawable.cosi,
            R.drawable.bbq1693,
            R.drawable.habaneros,
            R.drawable.aromas,
            R.drawable.mooyah,
            R.drawable.pitapit,
            R.drawable.crust,
            R.drawable.dodge,
            R.drawable.boehly,
            R.drawable.argo,
            R.drawable.dominos,
            R.drawable.chancellors
    };

    // Array of strings to store currencies
    String[] diningAddresses = new String[]{
            "101 Sadler Center",
            "651 Ukrop Way",
            "104 Jamestown Rd.",
            "101 Sadler Center",
            "101 Sadler Center",
            "Sadler Terrace",
            "Sadler Terrace",
            "400 Landrum Dr.",
            "249 Richmond Rd #102",
            "Tribe Square, 249 Richmond Rd.",
            "249 Richmond Rd #103",
            "104 Jamestown Rd.",
            "101 Ukrop Way",
            "101 Ukrop Way",
            "1220 Richmond Rd.",
            "104 Jamestown Rd."
    };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Each row in the list stores country name, diningAddresses and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<16;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt", diningHalls[i]);
            hm.put("cur", diningAddresses[i]);
            hm.put("flag", Integer.toString(images[i]) );
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "txt", "cur", "flag" };

        // Ids of views in listview_layout
        int[] to = { R.id.location_name, R.id.address, R.id.flag };

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.activity_dininglocations, from, to);

        // Getting a reference to listview of main.xml layout file
        final ListView listView = ( ListView ) findViewById(R.id.listview);

        // Setting the adapter to the listView
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Intent intent = new Intent();
                Object item = listView.getItemAtPosition(i);
                HashMap tmp = (HashMap) item;
                String loc = tmp.get("txt").toString();
                Log.v(tag, "The user selected " + loc + ".");
                Intent intent = new Intent(LocationsActivity.this, LocationActivity.class);
                startActivity(intent);
            }
        }

        );

    }

    public void goToSpecificLocation(View view)
    {
        Intent intent = new Intent(LocationsActivity.this, LocationActivity.class);
        startActivity(intent);
    }
}