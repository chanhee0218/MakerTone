package com.chanhee.makertone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class SmsActivity extends AppCompatActivity {
    Button button;
    CheckBox checkBox;
    EditText editText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        button=findViewById(R.id.button);
        checkBox=findViewById(R.id.check);
        editText=findViewById(R.id.editMessage);





}
