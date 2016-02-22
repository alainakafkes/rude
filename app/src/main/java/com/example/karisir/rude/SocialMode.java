package com.example.karisir.rude;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


/**
 * Created by vickieli on 2/21/16.
 */
public class SocialMode extends Activity{
    private Switch mySwitch;


    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);
        final TextView time_text = (TextView) findViewById(R.id.timer);
        mySwitch = (Switch) findViewById(R.id.mySwitch);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if (!isChecked) {

                    Intent intent = new Intent(SocialMode.this, MainActivity.class);
                    startActivity(intent);
                }
            }


        });


        final TextView score = (TextView) findViewById(R.id.score);
        RelativeLayout screen = (RelativeLayout) findViewById(R.id.social_screen);
        screen.setOnTouchListener(new View.OnTouchListener() {


            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Toast.makeText(SocialMode.this, "Stop touching me!", Toast.LENGTH_LONG).show();
                    int curr_score = Integer.parseInt(score.getText().toString());
                    int now_score = curr_score - 10;
                    score.setText(String.valueOf(now_score));
                }
                return false;
            }
        });

        Button start_button = (Button) findViewById(R.id.start_button);
        View.OnClickListener handler = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(SocialMode.this, timer.class);
//                startActivity(intent);
                new CountDownTimer(30000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        time_text.setText("seconds remaining: " + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        time_text.setText("done!");
                        int curr_score = Integer.parseInt(score.getText().toString());
                        int now_score = curr_score + 10;
                        score.setText(String.valueOf(now_score));

                    }
                }.start();
            }
        };
        start_button.setOnClickListener(handler);



}

}
