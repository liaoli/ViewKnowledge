package com.example.liaoli.viewknowledge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }


    public void positionalParameter(View view){
        Intent intent = new Intent(this,PositionalParameterActivity.class);
        startActivity(intent);
    }

    public void velocityActivity(View view){
        Intent intent = new Intent(this,VelocityActivity.class);
        startActivity(intent);
    }

}
