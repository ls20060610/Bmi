package com.tom.bmi;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
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
        getResources().getString(R.string.app_name);
        //"Bmi"
        Button bhelp = (Button) findViewById(R.id.b_info);
        bhelp.setOnClickListener(listener);

    }
        public void bmi(View view){
          //  System.out.println();
            Log.d("MainActivity", "testing bmi method");
            EditText edweight = (EditText) findViewById(R.id.ed_weight);
            EditText edheight = (EditText) findViewById(R.id.ed_height);
            float weight = Float.parseFloat(edweight.getText().toString());
            float height = Float.parseFloat(edheight.getText().toString());
            float bmi = weight / (height * height);
            new AlertDialog.Builder(this)
                    .setMessage(getString(R.string.your_BMI_is) + bmi)
                    .setTitle(R.string.bmi_title)
                    .setPositiveButton(R.string.ok,null)
                    .show();


           /* Log.d("MainActivity" , "Your bmi is :" + bmi);
           Toast.makeText(this,"Your BMI is " + bmi , Toast.LENGTH_LONG).show();*/
    }
}
