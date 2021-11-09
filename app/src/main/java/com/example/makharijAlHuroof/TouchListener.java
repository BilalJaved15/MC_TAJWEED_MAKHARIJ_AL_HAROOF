package com.example.makharijAlHuroof;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TouchListener implements View.OnTouchListener {

    AppCompatActivity activity;

    public TouchListener(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        final int DRAWABLE_LEFT = 0;
        final int DRAWABLE_TOP = 1;
        final int DRAWABLE_RIGHT = 2;
        final int DRAWABLE_BOTTOM = 3;

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (event.getRawX() <= (v.getLeft() + ((TextView) v).getCompoundDrawables()[DRAWABLE_LEFT].getBounds().width())) {
                activity.finish();
                return true;
            }
        }
        return false;
    }
}
