package com.example.karisir.rude;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class timer extends Activity
{
    private static final String tag = "Main";
    private MalibuCountDownTimer countDownTimer;
    private long timeElapsed;
    private boolean timerHasStarted = false;
    private Button startB;
    private TextView text;
    private TextView timeElapsedView;
    private Switch mySwitch;

    private final long startTime = 50000;
    private final long interval = 1000;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);
        mySwitch = (Switch) findViewById(R.id.mySwitch);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if (!isChecked) {

                    Intent intent = new Intent(timer.this, MainActivity.class);
                    startActivity(intent);
                }
            }


        });
//        startB = (Button) this.findViewById(R.id.button);
//        startB.setOnClickListener(this);

        text = (TextView) this.findViewById(R.id.timer);
//        timeElapsedView = (TextView) this.findViewById(R.id.timeElapsed);
        countDownTimer = new MalibuCountDownTimer(startTime, interval);
//        text.setText(text.getText() + String.valueOf(startTime));
        RelativeLayout screen = (RelativeLayout) findViewById(R.id.social_screen);
        screen.setOnTouchListener(new View.OnTouchListener() {


            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Toast.makeText(timer.this, "Stop touching me! Go talk to your friends!", Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });

    }

//    @Override
//    public void onClick(View v)
//    {
//        if (!timerHasStarted)
//        {
//            countDownTimer.start();
//            timerHasStarted = true;
//            startB.setText("Start");
//        }
//        else
//        {
//
//            countDownTimer.cancel();
//            timerHasStarted = false;
//            startB.setText("RESET");
//        }
//    }

    // CountDownTimer class
    public class MalibuCountDownTimer extends CountDownTimer
    {

        public MalibuCountDownTimer(long startTime, long interval)
        {
            super(startTime, interval);
        }

        @Override
        public void onFinish()
        {
            text.setText("Time's up!");
        }

        @Override
        public void onTick(long millisUntilFinished)
        {
            text.setText("Time remain:" + millisUntilFinished);
            timeElapsed = startTime - millisUntilFinished;
        }
    }


}