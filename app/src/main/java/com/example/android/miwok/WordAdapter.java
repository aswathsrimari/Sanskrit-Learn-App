package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    public WordAdapter(Context context, ArrayList<Word> words){
        super(context,0,words);

    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentAndroidWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView sanTextView = (TextView) listItemView.findViewById(R.id.sanView);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        sanTextView.setText(currentAndroidWord.getTranslate());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.engView);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        numberTextView.setText(currentAndroidWord.getDefaultWord());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.imgView);

        if(currentAndroidWord.hasImage()){
            imageView.setImageResource(currentAndroidWord.getmImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            imageView.setVisibility(View.GONE);
        }

        return listItemView;

    }
}
