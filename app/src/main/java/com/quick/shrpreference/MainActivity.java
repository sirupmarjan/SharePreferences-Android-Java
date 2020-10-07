package com.quick.shrpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText et_username, et_password;
    private Button btn_login;
    Preferences session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        new ModuleTool().allowNetworkOnMainThread();
        session = new Preferences(this);
        if(session.isUserLogin()){
            Intent i = new Intent(this, MenuAct.class);
            startActivity(i);
            finish();
        }


        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);

        onLogin();
    }

    private void onLogin() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uName, uPass;
                uName = et_username.getText().toString().toUpperCase();
                uPass = et_password.getText().toString();

                if(uName.length() >  0 ){
                    if (uPass.length() > 0){
                        loginUser(uName, uPass);
                    }else {
                        et_password.setError("password harus diisi");
                    }
                }else{
                    et_username.setError("username harus diisi");
                }

            }
        });
    }

    private void loginUser(String uName, String uPass) {
        session.createUserSession(uName, uPass);
        recreate();
    }
}