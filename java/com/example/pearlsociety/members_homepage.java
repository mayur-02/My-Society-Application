package com.example.pearlsociety;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import pearlsociety.R;

public class members_homepage extends AppCompatActivity {

    SliderView sliderView;
    int[] images = {R.drawable.img1,
    R.drawable.img2,
    R.drawable.img3,
    R.drawable.img4,
    R.drawable.img5};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.members_home);

        sliderView = findViewById(R.id.image_slider);

        SliderAdapter sliderAdapter = new SliderAdapter(images);

        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

    }

    public void guest(View view) {
        Intent i=new Intent(members_homepage.this,guestvisitform.class);
        startActivity(i);
    }

    public void societycomplaint(View view) {
        Intent i=new Intent(members_homepage.this,complaint.class);
        startActivity(i);
    }



    public void notice(View view) {
        Intent i=new Intent(members_homepage.this,viewNotice.class);
        startActivity(i);
    }

    public void sos(View view) {
        Intent i=new Intent(members_homepage.this,sos.class);
        startActivity(i);
    }

    public void feedback(View view) {
        Intent i=new Intent(members_homepage.this,giveFeedback.class);
        startActivity(i);
    }

    public void amenitiesdetail(View view) {


        Intent i=new Intent(members_homepage.this,amenitiesinfo.class);
        startActivity(i);



    }

    public void maintainance(View view) {

        Intent i=new Intent(members_homepage.this,payment.class);
        startActivity(i);

    }

    public void viewformstatus(View view) {
        Intent i=new Intent(members_homepage.this,approvedform.class);
        startActivity(i);
    }
}