package com.quick.shrpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterAct extends AppCompatActivity {

    private EditText et_usernameReg, et_passwordReg, et_repasswordReg;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_usernameReg = findViewById(R.id.et_usernameReg);
        et_passwordReg = findViewById(R.id.et_passwordReg);
        et_repasswordReg = findViewById(R.id.et_repasswordReg);

        btn_register = findViewById(R.id.btn_register);

    }
}