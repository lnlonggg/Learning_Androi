package com.example.lyngoclong_bai01;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ManHinhShare extends AppCompatActivity {
SharedPreferences s;
EditText ten;
Button btS, btL, btCl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mnsharescrenn);
        ten = findViewById(R.id.editTenNguoiDung);
        btS = findViewById(R.id.btnLuuTen);
        btL = findViewById(R.id.btnLoadTen);
        btCl = findViewById(R.id.btnClearTen);

        s = getSharedPreferences("data", MODE_PRIVATE);

        btS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenn = ten.getText().toString();
                SharedPreferences.Editor editor = s.edit();
                editor.putString("ten", tenn);
                editor.commit();
            }
        });

        btL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = s.getString("ten", "");
                ten.setText(name);
            }
        });

        btCl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = s.edit();
                editor.remove("ten");
                editor.apply();
                ten.setText("Đã xóa dữ liệu thành công");
            }
        });
    }
}