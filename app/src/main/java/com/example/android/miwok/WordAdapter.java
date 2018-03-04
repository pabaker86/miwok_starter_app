package com.example.android.miwok;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Bakes on 2/24/2018.
 */

/*
* {@link WordAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
* based on a data source, which is a list of {@link Word} objects.
* */
public class WordAdapter extends ArrayAdapter<Word>{

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();
 private int mColorResourceId;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context  The current context. Used to inflate the layout file.
     * @param words   A List of word objects to display in a list
     * @param colorBackground  the background color id of each activity screen when selected.
     */

    public WordAdapter (Activity context, ArrayList<Word> words, int colorBackground ){
        super(context,0, words);
        mColorResourceId = colorBackground;
    }


    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        //get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view
        TextView miwalkTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version name from the current Word object and
        // set this text on the name TextView
        miwalkTextView.setText(currentWord.getMiwokTranslaction());

        // Find the TextView in the list_item.xml layout with the ID default_text_view
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the default transalation from the current word object and
        // set this text on the number TextView
        defaultTextView.setText(currentWord.getDefaultTranslaction());


       //Find the ImageView in the list_item.xml layout with the ID default_image_view
        ImageView getDefaultImageView = (ImageView) listItemView.findViewById(R.id.default_image_view);
        // Get the image resource ID from the current word object and
        // set the image to ID
        getDefaultImageView.setImageResource(currentWord.getImageResourceID());

        View textContainer = listItemView.findViewById(R.id.fullScreen);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);
        // if then logic to determine how to Return the whole list item layout
        // so that it can be shown in the Single ListView
        // set the imageview to Hide if the imageViewEnabled value is false (contains 2 texviews only)
        // or return the ItemlistView with 2 textviews and 1 image view.
        if (currentWord.isThereAnImage() == false) {
            getDefaultImageView.setVisibility(View.GONE);
        }
        return listItemView;
    }
}

