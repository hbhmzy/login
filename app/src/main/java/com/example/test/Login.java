package com.example.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLogTags;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {


    Button btn;
    EditText edit1;
    EditText edit2;
    String name;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        btn=findViewById(R.id.login);
        edit1=findViewById(R.id.identity);
        edit2=findViewById(R.id.password);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=edit1.getText().toString();
                password=edit2.getText().toString();

                if ((name.equals("123")) && (password.equals("123"))) {
                    Intent intent=new Intent(Login.this,MainActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(Login.this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
