package com.garrettshorr.sunlightapitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TextView mResult;
    private EditText mSearch;
    private Button mSearchButton;

    public static final String CAP_WORDS_URL = "http://capitolwords.org/api/1";
    public static final String CLINTON_ID = "C001041";
    public static final String SANDERS_ID = "S000033";

    private static final String CAP_WORDS_APIKEY = "&apikey=<26b803c45ba14dfb94a63bad60bdb21a>";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResult = (TextView) findViewById(R.id.search_result);
        mSearch = (EditText) findViewById(R.id.search_term);
        mSearchButton = (Button) findViewById(R.id.search_button);

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_sunlight_api(mSearch.getText().toString());
            }
        });

    }

    //dates.json?phrase=united+states&entity_type=state&entity_value=VA&apikey=<YOUR_KEY>


    private void search_sunlight_api(String text) {

        String urlStr = CAP_WORDS_URL + "/dates.json?phrase=" + mResult.getText().toString() +
                        "&bioguide_id=" + CLINTON_ID + CAP_WORDS_APIKEY;
        URL url = null;
        try {
            url = new URL(urlStr);
            Reader reader = new InputStreamReader(url.openStream());
            Gson gson = new GsonBuilder().create();
            Word word = gson.fromJson(reader, Word.class);
            mResult.setText(word.toString());
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            mResult.setText("Malformed URL Exception");
            }
        catch (IOException e) {
            e.printStackTrace();
            mResult.setText("IO Exception");
        }







    }
}
