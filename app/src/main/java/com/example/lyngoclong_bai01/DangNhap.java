package com.example.lyngoclong_bai01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DangNhap extends AppCompatActivity {
    Button btthoat;
    Button btdangnhap;
    Button btreset;

    EditText edus,edps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mhdangnhaptaikhoan);
        btthoat =(Button) findViewById(R.id.buttonExit);
        btthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DangNhap.this, "Ban da thoat ung dung", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btdangnhap =(Button) findViewById(R.id.buttonLogin);
        btdangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String tdn = edus.getText().toString();
            String mk =edps.getText().toString();
            if (tdn.equals("Admin") && mk.equals("12345")) {
                Toast.makeText(DangNhap.this, "Dang nhap thanh cong", Toast.LENGTH_LONG).show();
                finish();
            }else {
                Toast.makeText(DangNhap.this, "Dang nhap that bai, moi ban nhap lai!", Toast.LENGTH_LONG).show();
            }
            }
        });

        btreset = (Button) findViewById(R.id.buttonReset);
        btreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edus.setText("");
                edps.setText("");
            }
        });

        edus=(EditText) findViewById(R.id.username);
        edps=(EditText) findViewById(R.id.password);
    }
}
