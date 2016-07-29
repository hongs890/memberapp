package com.example.hongs.memberapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{
    EditText et_id,et_pw;
    Button bt_signin, bt_signup;
    MemberService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_id = (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);
        bt_signin = (Button) findViewById(R.id.bt_signin);
        bt_signup = (Button) findViewById(R.id.bt_signup);
        service = new MemberServiceImpl(this.getApplicationContext());
        bt_signin.setOnClickListener(this);
        bt_signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.bt_signup:
           startActivity(new Intent(this, JoinActivity.class));
            break;
        case R.id.bt_signin:
            MemberBean bean = new MemberBean();
            bean.setId(et_id.getText().toString());
            bean.setPw(et_pw.getText().toString());
            if (service.login(bean)){
                startActivity(new Intent(this,HomeActivity.class));
            }else{
                Toast.makeText(MainActivity.this,"Please check your ID, Password", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this,MainActivity.class));
            }
            break;

    }
    }
}
