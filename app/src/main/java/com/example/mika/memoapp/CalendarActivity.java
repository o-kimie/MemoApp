package com.example.mika.memoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CalendarActivity extends AppCompatActivity implements View.OnClickListener{
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_calendar);

            Button back = (Button) findViewById(R.id.main_calender_btn);

            // イベントを取得するためのリスナーを設定
            // this:このクラス自身(MainActivity
            calender.setOnClickListener(this);{


            }
}
