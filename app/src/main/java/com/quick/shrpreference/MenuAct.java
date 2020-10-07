package com.quick.shrpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class MenuAct extends AppCompatActivity {
    Preferences session;
    TextView tv_nama;
    Button btn_logout;
    String uName, uPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        session = new Preferences(this);
        HashMap<String, String> userData = session.getUserData();
        uName = userData.get(Preferences.KEY_USERNAME);
        uPass = userData.get(Preferences.KEY_PASSWORD);

        tv_nama = findViewById(R.id.tv_nama);
        tv_nama.setText(uName);
        btn_logout = findViewById(R.id.btn_logout);
        onLogout();
    }

    private void onLogout() {
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.logoutUser();
                finish();
            }
        });
    }


}