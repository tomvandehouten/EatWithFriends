package edu.wm.eatwithfriends;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MealsActivity extends Activity{

    ListView list;
    String[] itemname ={
            "John Sawin",
            "Thomas Van de Houten",
            "Alex Powell",
            "Derek O'Connell",
            "Professor Kemper",
            "A Robot",
            "Johnny Manziel",
            "Thomas Jefferson"


    };

    Integer[] imgid={
            R.mipmap.john,
            R.mipmap.thomas,
            R.mipmap.alex,
            R.mipmap.derek,
            R.mipmap.kemper,
            R.mipmap.robot,
            R.mipmap.manziel,
            R.mipmap.tj,


    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);

        CustomListAdapterMeals adapter=new CustomListAdapterMeals(this, itemname, imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem= itemname[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

            }
        });
    }
}