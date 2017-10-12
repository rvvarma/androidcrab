package com.apptecherzz.apcrabs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mainscreen extends AppCompatActivity {

    Button enroll_OTP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        enroll_OTP=(Button) findViewById(R.id.button2);
        enroll_OTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(mainscreen.this,OTP.class);
                startActivity(i);
            }
        });
    }
}
