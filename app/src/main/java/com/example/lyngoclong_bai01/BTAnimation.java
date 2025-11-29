//Tạo ani (Android Resource File) trong res type Anim(ation)
package com.example.lyngoclong_bai01;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BTAnimation extends AppCompatActivity {
    ImageView imgHienThi;
    Button btnXoay, btnAn, btnHien, btnDiChuyen, btnToHop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mhbtanimation);

        imgHienThi = findViewById(R.id.imgHienThi);
        btnXoay = findViewById(R.id.btnXoay);
        btnAn = findViewById(R.id.btnAn);
        btnHien = findViewById(R.id.btnHien);
        btnDiChuyen = findViewById(R.id.btnDiChuyen);
        btnToHop = findViewById(R.id.btnToHop);

        btnXoay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(BTAnimation.this, R.anim.rotate_anim);
                imgHienThi.startAnimation(anim);
            }
        });


        imgHienThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(BTAnimation.this, R.anim.scale_anim);
                imgHienThi.startAnimation(anim);
                Toast.makeText(BTAnimation.this, "Đang phóng to...", Toast.LENGTH_SHORT).show();
            }
        });

        btnAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(BTAnimation.this, R.anim.fade_out);
                imgHienThi.startAnimation(anim);
            }
        });

        btnHien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(BTAnimation.this, R.anim.fade_in);
                imgHienThi.startAnimation(anim);
            }
        });

        btnDiChuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(BTAnimation.this, R.anim.translate_anim);
                imgHienThi.startAnimation(anim);
            }
        });

        btnToHop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim = AnimationUtils.loadAnimation(BTAnimation.this, R.anim.combo_anim);
                imgHienThi.startAnimation(anim);
            }
        });
    }
}