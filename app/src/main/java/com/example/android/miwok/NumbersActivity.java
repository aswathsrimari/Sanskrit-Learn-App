package com.example.android.miwok;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TwoLineListItem;
import android.widget.WrapperListAdapter;

import java.util.ArrayList;


public class NumbersActivity extends AppCompatActivity {


    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        this.setTitle("Sanskrit Numbers");
        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("one","ekam",R.drawable.number_one,R.raw.ekam));
        words.add(new Word("two","dve",R.drawable.number_two,R.raw.dve));
        words.add(new Word("three","treeni",R.drawable.number_three,R.raw.triini));
        words.add(new Word("four","chatvari",R.drawable.number_four,R.raw.chatvari));
        words.add(new Word("five","pancha",R.drawable.number_five,R.raw.pancha));
        words.add(new Word("six","shat",R.drawable.number_six,R.raw.shat));

        words.add(new Word("seven","sapta",R.drawable.number_seven,R.raw.sapta));
        words.add(new Word("eight","ashta",R.drawable.number_eight,R.raw.ashta));
        words.add(new Word("nine","nava",R.drawable.number_nine,R.raw.nava));
        words.add(new Word("ten","dasha",R.drawable.number_ten,R.raw.dasha));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdapter itemsAdapter =
                new WordAdapter(this, words);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word word = words.get(i);

                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this,word.getmMediaId());
                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer(){
        if(mMediaPlayer!=null){
            mMediaPlayer.release();

            mMediaPlayer =null;

        }
    }
}
