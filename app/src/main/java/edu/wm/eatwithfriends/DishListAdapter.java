package edu.wm.eatwithfriends;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by Derek on 4/28/2016.
 */
public class DishListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] itemname;
    private final Integer[] calories;
    private final Integer[] imgid;
    private final Integer[] ratings;
    private final String[] modifier;

    public DishListAdapter(
            Activity context, String[] itemname, Integer[] calories, Integer[] imgid,
            Integer[] ratings, String[] modifier) {

        super(context, R.layout.comments, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
        this.ratings=ratings;
        this.calories = calories;
        this.modifier=modifier;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        final View rowView=inflater.inflate(R.layout.dish, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.dishNameTextView);
        TextView caloriesTextView = (TextView) rowView.findViewById(R.id.caloriesTextView );
        ImageView dishImageView = (ImageView) rowView.findViewById(R.id.dishImageView);
        ImageView dishModifiewImageView = (ImageView) rowView.findViewById(R.id.dishModifierImageView);
        RatingBar rtgBar = (RatingBar) rowView.findViewById(R.id.dishRatingBar);

        txtTitle.setText(itemname[position]);
        dishImageView.setImageResource(imgid[position]);
        rtgBar.setRating(ratings[position]);
        caloriesTextView.setText(calories[position].toString() + " calories");

        switch (modifier[position]){
            case "vegan": dishModifiewImageView.setImageResource(R.drawable.vegan);
                break;
            case "vegetarian": dishModifiewImageView.setImageResource(R.drawable.vegetarian);
                break;
            case "glutenfree": dishModifiewImageView.setImageResource(R.drawable.glutenfree);
        }

        return rowView;

    };
}
