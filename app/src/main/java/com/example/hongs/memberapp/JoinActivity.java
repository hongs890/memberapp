package com.example.hongs.memberapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class JoinActivity extends Activity implements View.OnClickListener{
    EditText ed_id, ed_pw, et_name, et_ssn, et_email, et_phone;
    Button bt_join, bt_reset;
    MemberService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        service = new MemberServiceImpl(this.getApplicationContext());
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
                Log.d("조인조인조인","조인조인조인");
                MemberBean member = new MemberBean();
                member.setId(ed_id.getText().toString());
                member.setPw(ed_pw.getText().toString());
                member.setName(et_name.getText().toString());
                member.setSsn(et_ssn.getText().toString());
                member.setEmail(et_email.getText().toString());
                member.setProfile("default.jpg");
                member.setPhone(et_phone.getText().toString());
                service.regist(member);
                Toast.makeText(JoinActivity.this,"가입을 축하드립니다", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.bt_reset:
                startActivity(new Intent(this, MainActivity.class));
                break;

        }
    }
}
