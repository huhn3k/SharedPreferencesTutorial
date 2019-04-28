package com.huhn3k.sharedpreferencestutorial;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText tfFullName, tfEmail, tfPhone;
    private TextView tvOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tfFullName = findViewById(R.id.tfFullName);
        tfEmail = findViewById(R.id.tfEmail);
        tfPhone = findViewById(R.id.tfPhoneNumber);
        tvOpen = findViewById(R.id.tvOpen);
    }

    private void save(String name, String email, String phone) {
        SharedPreferences sharedPreferences = getSharedPreferences("USER", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("NAME", name);
        editor.putString("EMAIL", email);
        editor.putString("PHONE", phone);
        editor.apply();
    }

    private String open() {
        SharedPreferences sharedPreferences = getSharedPreferences("USER", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("NAME", null);
        String email = sharedPreferences.getString("EMAIL", null);
        String phone = sharedPreferences.getString("PHONE", null);
        return name + ", " + email + ", " + phone;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSave) {
            save(tfFullName.getText().toString(), tfEmail.getText().toString(), tfPhone.getText().toString());
        } else if (v.getId() == R.id.btnOpen) {
            String list = open();
            tvOpen.setText(list);
        }
    }
}
