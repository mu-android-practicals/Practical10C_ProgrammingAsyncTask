package com.example.practical10c;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                textView=(TextView) findViewById(R.id.textView);
                button=(Button)findViewById(R.id.button);
                button.setOnClickListener(view -> {

                        MyTask myTask=new MyTask(MainActivity.this, textView,button);
                        myTask.execute();
                        button.setEnabled(false);

                });


    }
}