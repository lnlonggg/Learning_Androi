package com.example.lyngoclong_bai01;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class DsachHangHoa extends AppCompatActivity {
    ListView lvHangHoa;
    ArrayList<String> arrayListHienThi;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mhdshanghoa);

        lvHangHoa = findViewById(R.id.lvHangHoa);
        arrayListHienThi = new ArrayList<>();

        loadDuLieuTuXML();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayListHienThi);
        lvHangHoa.setAdapter(adapter);
    }

    private void loadDuLieuTuXML() {
        SharedPreferences prefs = getSharedPreferences("KHO_HANG", MODE_PRIVATE);

        int tongSoLuong = prefs.getInt("tong_so_luong", 0);

        for (int i = 0; i < tongSoLuong; i++) {
            String keyTen = "ten_" + i;
            String keySL = "sl_" + i;
            String keyGia = "gia_" + i;

            String ten = prefs.getString(keyTen, "No Name");
            int sl = prefs.getInt(keySL, 0);
            float gia = prefs.getFloat(keyGia, 0);
            float thanhTien = sl * gia;

            String dongHienThi = (i + 1) + ". " + ten + "\n" +
                    "   SL: " + sl + " | Giá: " + String.format("%,.0f", gia) + "\n" +
                    "   => Tổng: " + String.format("%,.0f", thanhTien) + " VND";

            arrayListHienThi.add(dongHienThi);
        }

        if (tongSoLuong == 0) {
            arrayListHienThi.add("Chưa có dữ liệu nào!");
        }
    }
}