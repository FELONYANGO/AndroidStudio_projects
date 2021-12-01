package com.example.beba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DisplaySignUP extends AppCompatActivity {
    public static final String NEWPAGE= "com.example.myFirstApp.NEW PAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_sign_up);
    }
    public  void  newpage(View view){

        Intent intent = new Intent(this, VideoPageActivity.class);
        //There is no limit for number of Extras you want to pass to
        Button beba = (Button) findViewById(R.id.register);
        String video = beba.getText().toString();

        intent.putExtra(NEWPAGE,video);
        startActivity(intent);


    }
}