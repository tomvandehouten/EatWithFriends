package edu.wm.eatwithfriends;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.RatingBar;

/**
 * Created by Derek on 4/27/2016.
 */
public class CommentListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;
    private final Integer[] ratings;

    public CommentListAdapter(
            Activity context, String[] itemname, Integer[] imgid, Integer[] ratings) {

        super(context, R.layout.comments, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
        this.ratings=ratings;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        final View rowView=inflater.inflate(R.layout.comments, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.commentTextView);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.dishImageView);
        RatingBar rtgBar = (RatingBar) rowView.findViewById(R.id.commentRatingBar);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);
        rtgBar.setRating(ratings[position]);
        return rowView;

    };



}
