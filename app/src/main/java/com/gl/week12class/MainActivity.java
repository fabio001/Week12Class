package com.gl.week12class;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.textView)
    TextView myText;

    @Bind(R.id.buttonPress)
    Button myButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.buttonPress)
    public void changeTitle(View v){
        myText.setText("Yeah, ButterKnife works");
        YoYo.with(Techniques.Bounce)
                .duration(2000)
                .withListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        //super.onAnimationEnd(animation);
                        YoYo.with(Techniques.RotateIn)
                                .duration(1000)
                                .playOn(myButton);
                    }
                })
                .playOn(myText);
    }

    @OnClick(R.id.buttonPicasso)
    public void picassoClick(View v){
        Picasso.with(this)
                .load("http://fabioviper.eu5.org/paraImgs/p3.jpg")
                .placeholder(R.drawable.icon)
                .error(R.mipmap.ic_launcher)
                .into((ImageView)findViewById(R.id.imageView));

        YoYo.with(Techniques.FlipInX)
                .duration(1000)
                .playOn((ImageView)findViewById(R.id.imageView));
    }

}
