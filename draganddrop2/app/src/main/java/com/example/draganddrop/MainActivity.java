package com.example.draganddrop;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;

public class MainActivity extends AppCompatActivity {

    private ShapeableImageView cardView1;
    private android.widget.LinearLayout.LayoutParams layoutParams;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardView1 = findViewById(R.id.imageView);

        cardView1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float xVal = event.getRawX();
                float yVal = event.getRawY();
                float changedX = 0;
                float changedY = 0;
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    changedX = xVal - v.getX();
                    changedY = yVal - v.getY();
                    return true;
                } else if(event.getAction() == MotionEvent.ACTION_MOVE){
                    float finalX = xVal - changedX;
                    float finalY = yVal - changedY;
                    v.setY(finalY);
                    v.setX(finalX);
                    return true;
                }
                return false;
            }
        });


    }
}