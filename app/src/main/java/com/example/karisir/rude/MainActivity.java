package com.example.karisir.rude;

import java.util.Arrays;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


public class MainActivity extends FragmentActivity {


    public class FacebookLogin extends ActionBarActivity {
        private LoginButton loginButton;
        private CallbackManager callbackManager;
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            FacebookSdk.sdkInitialize(this.getApplicationContext());
            //setContentView(R.layout.activity_login);
            callbackManager = CallbackManager.Factory.create();
            loginButton = (LoginButton) findViewById(R.id.login_button);
            List<String> permissionNeeds = Arrays.asList("user_photos", "email", "user_birthday", "public_profile");
            loginButton.setReadPermissions(permissionNeeds);
            loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>()
            {
                @Override
                public void onSuccess(LoginResult loginResult)
                {
                    System.out.println("onSuccess");
                }

                @Override
                public void onCancel()
                {
                    System.out.println("onCancel");
                }

                @Override
                public void onError(FacebookException exception)
                {
                    Log.v("LoginActivity", exception.getCause().toString());
                }
            });
        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_facebook_login, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    }
}