package com.example.lyngoclong_bai01;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class QLHangHoa extends AppCompatActivity {

    EditText edtTen, edtSL, edtGia;
    Button btnThem, btnXemDS;
    TextView txtHienThiTien;
    TextView txtThanhTien;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mhthemhanghoa);

        edtTen = findViewById(R.id.edtTenHang);
        edtSL = findViewById(R.id.edtSoLuong);
        edtGia = findViewById(R.id.edtDonGia);
        btnThem = findViewById(R.id.btnThem);
        txtThanhTien = findViewById(R.id.txtThanhTien);
        btnXemDS = findViewById(R.id.btnXemDS);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyLuuTru();
            }
        });

        btnXemDS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QLHangHoa.this, DsachHangHoa.class);
                startActivity(intent);
            }
        });
    }

    private void xuLyLuuTru() {
        try {
            String ten = edtTen.getText().toString();
            if (ten.isEmpty()) {
                Toast.makeText(this, "Chưa nhập tên!", Toast.LENGTH_SHORT).show();
                return;
            }
            int sl = Integer.parseInt(edtSL.getText().toString());
            float gia = Float.parseFloat(edtGia.getText().toString());
            float tongTien = sl * gia;
            txtThanhTien.setText("Thành tiền: " + String.format("%,.0f", tongTien) + " VND");

            SharedPreferences prefs = getSharedPreferences("KHO_HANG", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();

            int index = prefs.getInt("tong_so_luong", 0);

            editor.putString("ten_" + index, ten);
            editor.putInt("sl_" + index, sl);
            editor.putFloat("gia_" + index, gia);

            editor.putInt("tong_so_luong", index + 1);

            editor.apply();

            Toast.makeText(this, "Đã lưu món thứ " + index, Toast.LENGTH_SHORT).show();

            edtTen.setText("");
            edtSL.setText("");
            edtGia.setText("");

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Vui lòng nhập số hợp lệ!", Toast.LENGTH_SHORT).show();
        }
    }
}