package com.example.victor.myintro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class MainActivity extends AppCompatActivity {

    /**
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         **/



        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);

            //  Declare a new thread to do a preference check
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    //  Initialize SharedPreferences
                    SharedPreferences getPrefs = PreferenceManager
                            .getDefaultSharedPreferences(getBaseContext());

                    //  Create a new boolean and preference and set it to true
                    boolean isFirstStart = getPrefs.getBoolean("firstStart", true);

                    //  If the activity has never started before...
                    if (isFirstStart) {

                        //  Launch app intro
                        Intent i = new Intent(MainActivity.this, MyIntro.class);
                        startActivity(i);

                        //  Make a new preferences editor
                        SharedPreferences.Editor e = getPrefs.edit();

                        //  Edit preference to make it false because we don't want this to run again
                        e.putBoolean("firstStart", false);

                        //  Apply changes
                        e.apply();
                    }
                }
            });

            // Start the thread
            t.start();

        }




    }

