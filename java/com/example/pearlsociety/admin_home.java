package com.example.pearlsociety;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import pearlsociety.R;

public class admin_home extends AppCompatActivity {

    SliderView sliderView;
    int[] images = {R.drawable.img1,
    R.drawable.img2,
    R.drawable.img3,
    R.drawable.img4,
    R.drawable.img5};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        sliderView = findViewById(R.id.image_slider);

        SliderAdapter sliderAdapter = new SliderAdapter(images);

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

    }


    public void Seecomplaint(View view) {
        Intent i=new Intent(admin_home.this,viewcomplaints.class);
        startActivity(i);
    }

    public void seefeedback(View view) {
        Intent i=new Intent(admin_home.this,viewFeedback.class);
        startActivity(i);
    }



    public void approveguest(View view) {
        Intent i=new Intent(admin_home.this,viewvisitingForm.class);
        startActivity(i);
    }

    public void addnotice(View view) {

        Intent i=new Intent(admin_home.this,addNotice.class);
        startActivity(i);

    }
}