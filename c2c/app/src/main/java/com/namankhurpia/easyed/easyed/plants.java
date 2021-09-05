package com.namankhurpia.easyed.easyed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class plants extends AppCompatActivity {

    private ImageButton back,arbtn;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_plants);
        txt=(TextView)findViewById(R.id.txt);

        back=(ImageButton)findViewById(R.id.backbtn);
        arbtn=(ImageButton)findViewById(R.id.arbtn);
        txt.setMovementMethod(new ScrollingMovementMethod());


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(plants.this,homescreen.class);
                startActivity(i);
            }
        });



        arbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.namankhurpia.plants");
                if (launchIntent != null) {
                    startActivity(launchIntent);//null pointer check in case package name was not found
                }
            }
        });


    }

}
