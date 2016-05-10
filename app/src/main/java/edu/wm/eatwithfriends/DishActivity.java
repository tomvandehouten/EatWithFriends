package edu.wm.eatwithfriends;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DishActivity extends ListActivity {

    ListView list;

    String[] comments = {
            "Best item on the menu!",
            "Tastes like horse meat :) yum!",
            "I can't believe I paid for this crap",
            "A subtle hint of oregano and some lemon undertones, a truly remarkable dish",
            "RAAAAAWWWWRRRRRR!!!!!!!!"
    };

    Integer[] imgid = {
            R.drawable.alexprofilepic,
            R.drawable.derekprofilepic,
            R.drawable.johnprofilepic,
            R.drawable.thomasprofilepic,
            R.drawable.godzillaprofilepic
    };

    Integer[] ratings = {5,4,1,4,3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        CommentListAdapter commentAdapter = new CommentListAdapter(this, comments, imgid, ratings);
        list = (ListView)findViewById(android.R.id.list);
        list.setAdapter(commentAdapter);
    }

    public void flagClickHandler(View v) {
        Toast.makeText(this, "Content Flagged", Toast.LENGTH_LONG).show();
    }
}
