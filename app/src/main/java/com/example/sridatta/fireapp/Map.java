package com.example.sridatta.fireapp;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.Toast;

public class Map extends AppCompatActivity {

    private Button Shelf1;
    private Button Shelf2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

         View view =getLayoutInflater().inflate(R.layout.activity_map,null); // get reference to root activity view
        setContentView(view);

        view.setOnClickListener(new View.OnClickListener() {
            float zoomFactor = 2f;
            boolean zoomedOut = false;

            @Override
            public void onClick(View v) {
                if(zoomedOut) { // zoom in
                    ScaleAnimation anim = new ScaleAnimation(1f, 1.5f, 1f, 1.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    anim.setDuration(500);
                    anim.setFillAfter(true);
                    v.startAnimation(anim);
                    zoomedOut = false;
                }
                else {
                    ScaleAnimation anim = new ScaleAnimation(1.5f, 1f, 1.5f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    anim.setDuration(500);
                    anim.setFillAfter(true);
                    v.startAnimation(anim);
                    zoomedOut = true;
                }
            }
        });


        Shelf1=(Button)findViewById(R.id.btn_shelf1);

        Shelf2=(Button)findViewById(R.id.btn_shelf2);
        //retrieved view of the book to display on the map

        String BookKey= getIntent().getExtras().getString("BookKey");
//"-KZCSK5zJZ_MgKP0OpPO"
        if(BookKey.equalsIgnoreCase("-KZCSK5zJZ_MgKP0OpPO")){
            Shelf1.setText("yea");
            Shelf1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.colorAccent), PorterDuff.Mode.MULTIPLY);

            Toast.makeText(Map.this,BookKey,Toast.LENGTH_LONG).show();

        }

    }
}
