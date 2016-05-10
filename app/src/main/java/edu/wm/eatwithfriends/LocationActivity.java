package edu.wm.eatwithfriends;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class LocationActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView list;

    String[] dishNames = {
            "Baby Carrots",
            "Strawberry Cupcakes",
            "Cheese Burger",
            "Mystery Meat",
            "Garden Salad"
    };

    Integer[] dishCalories = {20,130,5000,225,200};

    String[] dishModifiers = {
            "vegan",
            "vegetarian",
            "",
            "glutenfree",
            "vegan"
    };

    Integer[] dishRatings = {4,3,3,1,5};

    Integer[] dishImages = {
            R.drawable.babycarrots,
            R.drawable.strawberrycupcake,
            R.drawable.hamburger,
            R.drawable.mysterymeat,
            R.drawable.gardensalad
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        DishListAdapter commentAdapter = new DishListAdapter(
                this, dishNames, dishCalories, dishImages, dishRatings, dishModifiers);
        list = (ListView)findViewById(android.R.id.list);
        list.setAdapter(commentAdapter);
        list.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> l, View v, int position, long id) {
        Intent intent = new Intent();
        intent.setClass(this, DishActivity.class);
        startActivity(intent);
    }
}
