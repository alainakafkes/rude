package com.example.karisir.rude;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.CompoundButton;
import android.widget.Switch;


/**
 * Created by vickieli on 2/21/16.
 */
public class SocialMode extends ActionBarActivity{
    private Switch mySwitch;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);

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

}
}
