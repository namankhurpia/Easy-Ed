package com.namankhurpia.easyed.easyed;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import java.util.Locale;

public class homescreen extends AppCompatActivity {

    private ImageButton search;
    private ImageView physics, biology, picturedic;
    private final int REQ_CODE_SPEECH_INPUT = 100;
    private ImageButton speak;
    private TextView texttoshow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_homescreen);

        search = (ImageButton) findViewById(R.id.search);
        physics = (ImageView) findViewById(R.id.physics);
        biology = (ImageView) findViewById(R.id.biology);
        picturedic = (ImageView) findViewById(R.id.picturedic);
        speak=(ImageButton)findViewById(R.id.btnSpeak);
        texttoshow=(TextView)findViewById(R.id.texttoshow);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(homescreen.this, search.class);
                startActivity(i);
            }
        });

        physics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(homescreen.this, physics.class);
                startActivity(i);
            }
        });

        biology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(homescreen.this, plants.class);
                startActivity(i);
            }
        });

        picturedic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(homescreen.this, picturedictionary.class);
                startActivity(i);
            }
        });

        speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promptSpeechInput();
            }
        });


}

    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String s1 = "bar magnet";
                    String s2 = result.get(0);
                    if (s2.equals(s1)) {

                        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.namankhurpia.magneticflief");
                        if (launchIntent != null) {
                            startActivity(launchIntent);//null pointer check in case package name was not found
                        }

                    }
                    if (s2.equals("magnetic field")) {
                        Intent i = new Intent(homescreen.this, physics.class);
                        startActivity(i);
                        texttoshow.setText(result.get(0));

                    }
                    if (s2.equals("horse")) {
                        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.namankhurpia.horse");
                        if (launchIntent != null) {
                            startActivity(launchIntent);//null pointer check in case package name was not found
                        }
                    }
                    if (s2.equals("photosynthesis")) {

                        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.namankhurpia.plants");
                        if (launchIntent != null) {
                            startActivity(launchIntent);//null pointer check in case package name was not found
                        }
                    }

                    else {
                        texttoshow.setText("I m sorry i don't understand");

                    }
                }

                //
            }
            break;
        }


        }
    }
