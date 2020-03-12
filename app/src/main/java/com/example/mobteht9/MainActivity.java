package com.example.mobteht9;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public class Kuuntelija extends GestureDetector.SimpleOnGestureListener {

        private static final long VELOCITY_THRESHOLD = 1;


        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            if (Math.abs(velocityX) < VELOCITY_THRESHOLD
                    && Math.abs(velocityY) < VELOCITY_THRESHOLD) {
                return false;

            } else if (Math.abs(velocityX) > Math.abs(velocityY)) {

                double punane = Math.abs((double) velocityX);

                LinearLayout ll = findViewById(R.id.layoutti);

                ll.setBackgroundColor(Color.rgb((int) (punane / 16000 * 255 + 50), 0, 0));
                Log.d("x", String.valueOf(punane / 16000 * 255 + 50));
                return true;
            } else {

                LinearLayout ll = findViewById(R.id.layoutti);
                double sinine = Math.abs((double) velocityY);
                ll.setBackgroundColor(Color.rgb(0, 0, (int) (sinine / 16000 * 255 + 50)));
                Log.d("y", String.valueOf(sinine / 16000 * 255 + 50));
                return true;

            }


        }




        @Override
        public void onLongPress(MotionEvent e) {

        }

        @Override
        public void onShowPress(MotionEvent e) {
            super.onShowPress(e);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            LinearLayout la = findViewById(R.id.layoutti);

            ColorDrawable vc = (ColorDrawable) la.getBackground();
            int color = vc.getColor();

            if (color == Color.WHITE)
                la.setBackgroundColor(Color.BLACK);
            else
                la.setBackgroundColor(Color.WHITE);




            return false;


        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return false;
        }

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

    }



    GestureDetector gestureDetector;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestureDetector = new GestureDetector(this, new Kuuntelija());
        LinearLayout v = findViewById(R.id.layoutti);

        v.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        });





    }




}
