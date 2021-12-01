package com.example.beba;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class DisplayMessageActivity extends AppCompatActivity {

    public static final String NEWPAGE= "com.example.myFirstApp.NEW PAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);


    }
 public  void newpage(View view){
     Intent intent = new Intent(this,VideoPageActivity.class);
     Button beba = (Button) findViewById(R.id.batn);
     String video = beba.getText().toString();
     intent.putExtra(NEWPAGE,video);
     startActivity(intent);
 }

}