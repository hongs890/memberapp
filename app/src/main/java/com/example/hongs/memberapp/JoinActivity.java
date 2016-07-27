package com.example.hongs.memberapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class JoinActivity extends Activity implements View.OnClickListener{
    EditText ed_id, ed_pw, et_name, et_ssn, et_email, et_phone;
    Button bt_join, bt_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        ed_id = (EditText) findViewById(R.id.et_id);
        ed_pw = (EditText) findViewById(R.id.et_pw);
        et_name = (EditText) findViewById(R.id.et_name);
        et_ssn = (EditText) findViewById(R.id.et_ssn);
        et_email = (EditText) findViewById(R.id.et_email);
        et_phone = (EditText) findViewById(R.id.et_phone);
        bt_join = (Button) findViewById(R.id.bt_join);
        bt_reset = (Button) findViewById(R.id.bt_reset);
        bt_join.setOnClickListener(this);
        bt_reset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_join:
                Toast.makeText(JoinActivity.this,"ID: "+ed_id.getText().toString()+" PW: "+ed_pw.getText().toString()+
                        " NAME: "+et_name.getText().toString()+" SSN: "+et_ssn.getText().toString()+
                        " EMAIL: "+et_email.getText().toString()+" PHONE: "+et_phone.getText().toString(),
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.bt_reset:

                break;

        }
    }
}
