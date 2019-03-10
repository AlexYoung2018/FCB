package com.example.work;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class RandomActivity extends BaseActivity implements View.OnClickListener{

    private Button button1,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        button1 = (Button) findViewById(R.id.b1);
        button2 = (Button) findViewById(R.id.b2);
        button3 = (Button) findViewById(R.id.b3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
        public void onClick(View v) {
        switch (v.getId()){
            case R.id.b1:
                Random random1 = new Random();
                int a1 = random1.nextInt(100);
                Toast.makeText(RandomActivity.this, "随机数为："+a1, Toast.LENGTH_SHORT).show();
                break;
            case R.id.b2:
                Random random2 = new Random();
                int a2 = random2.nextInt(1000);
                Toast.makeText(RandomActivity.this, "随机数为："+a2, Toast.LENGTH_SHORT).show();
                break;
            case R.id.b3:
                Random random3 = new Random();
                int a3 = random3.nextInt(10000);
                Toast.makeText(RandomActivity.this, "随机数为："+a3, Toast.LENGTH_SHORT).show();
                break;
        }

        }
}
