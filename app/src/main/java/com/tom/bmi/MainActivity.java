package com.tom.bmi;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edweight;
    private EditText edheight;
    String s = new String("abc");
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           new AlertDialog.Builder(MainActivity.this)
                   .setTitle("xxx")
                   .setMessage("BMI = 體重除以身高平方")
                   .setPositiveButton("Ok" , null)
                   .show(); 
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Mainactivity" , "onCreate");
        findviews();
        getResources().getString(R.string.app_name);
        //"Bmi"



    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Mainactivity" , "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Mainactivity" , "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Mainactivity" , "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Mainactivity" , "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Mainactivity" , "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Mainactivity" , "onRestart");
    }

    private Button findviews() {
        edweight = (EditText) findViewById(R.id.ed_weight);
        edheight = (EditText) findViewById(R.id.ed_height);
        return (Button) findViewById(R.id.b_info);
    }


    public void bmi(View view){
          //  System.out.println();
            Log.d("MainActivity", "testing bmi method");

            float weight = Float.parseFloat(edweight.getText().toString());
            float height = Float.parseFloat(edheight.getText().toString());
            float bmi = weight / (height * height);

            Intent intent =  new Intent(this, ResultActivity.class);
            intent.putExtra("EXTRA_BMI" , bmi);
            startActivity(intent);



            if (bmi < 20){
                new AlertDialog.Builder(this)
                        .setMessage("請多吃點")
                        .setPositiveButton(R.string.ok,null)
                        .show();
            }
            new AlertDialog.Builder(this)
                    .setMessage(getString(R.string.your_BMI_is) + bmi)
                    .setTitle(R.string.bmi_title)
                    .setPositiveButton(R.string.ok,null)
                    .show();
            if (height > 3){
                new AlertDialog.Builder(this)
                        .setMessage("身高單位應為公尺")
                        .setPositiveButton(R.string.ok,null)
                        .show();
            }

           /* Log.d("MainActivity" , "Your bmi is :" + bmi);
           Toast.makeText(this,"Your BMI is " + bmi , Toast.LENGTH_LONG).show();*/
    }
}
