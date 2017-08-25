package com.danit.nog1gb;

import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Request User Permission To Send SMS
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);

        final Button nog1gb = (Button) findViewById(R.id.nog1gb);
        nog1gb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Send SMS
                sendSMS("1280", "NOG 1GB");
                //Notify Dev :)
                Log.d("Logger", "SMS Sent!");
                //Notify User
                Toast.makeText(MainActivity.this, "SMS is verstuurd!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Sends A SMS Message
    private void sendSMS(String phoneNumber, String message) {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    }
}
