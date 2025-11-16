package com.example.lyngoclong_bai01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BaiToan extends AppCompatActivity {
    Button btCong, btTru, btNhan, btChia, btReset;
    EditText etSo1, etSo2;
    TextView tvKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.manhinhbaitoan);

        btCong =(Button) findViewById(R.id.btnCong);
        btTru =(Button) findViewById(R.id.btnTru);
        btNhan =(Button) findViewById(R.id.btnNhan);
        btChia =(Button) findViewById(R.id.btnChia);
        btReset =(Button) findViewById(R.id.btnReset);

        etSo1 =(EditText) findViewById(R.id.editSo1);
        etSo2 =(EditText) findViewById(R.id.editSo2);
        tvKetQua =(TextView) findViewById(R.id.textKetQua);



        btCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String s1 = etSo1.getText().toString();
                    String s2 = etSo2.getText().toString();

                    if (s1.isEmpty() || s2.isEmpty()) {
                        Toast.makeText(BaiToan.this, "Lỗi: Vui lòng nhập đủ 2 số", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    double so1 = Double.parseDouble(s1);
                    double so2 = Double.parseDouble(s2);
                    double ketQua = so1 + so2;

                    if (ketQua == (long) ketQua) {
                        tvKetQua.setText(String.format(java.util.Locale.US, "%d", (long) ketQua));
                    } else {
                        tvKetQua.setText(String.format("%s", ketQua));
                    }

                } catch (NumberFormatException e) {
                    Toast.makeText(BaiToan.this, "Lỗi", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String s1 = etSo1.getText().toString();
                    String s2 = etSo2.getText().toString();

                    if (s1.isEmpty() || s2.isEmpty()) {
                        Toast.makeText(BaiToan.this, "Lỗi: Vui lòng nhập đủ 2 số", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    double so1 = Double.parseDouble(s1);
                    double so2 = Double.parseDouble(s2);
                    double ketQua = so1 - so2;

                    if (ketQua == (long) ketQua) {
                        tvKetQua.setText(String.format(java.util.Locale.US, "%d", (long) ketQua));
                    } else {
                        tvKetQua.setText(String.format("%s", ketQua));
                    }

                } catch (NumberFormatException e) {
                    Toast.makeText(BaiToan.this, "Lỗi", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String s1 = etSo1.getText().toString();
                    String s2 = etSo2.getText().toString();

                    if (s1.isEmpty() || s2.isEmpty()) {
                        Toast.makeText(BaiToan.this, "Lỗi: Vui lòng nhập đủ 2 số", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    double so1 = Double.parseDouble(s1);
                    double so2 = Double.parseDouble(s2);
                    double ketQua = so1 * so2;

                    if (ketQua == (long) ketQua) {
                        tvKetQua.setText(String.format(java.util.Locale.US, "%d", (long) ketQua));
                    } else {
                        tvKetQua.setText(String.format("%s", ketQua));
                    }

                } catch (NumberFormatException e) {
                    Toast.makeText(BaiToan.this, "Lỗi", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String s1 = etSo1.getText().toString();
                    String s2 = etSo2.getText().toString();

                    if (s1.isEmpty() || s2.isEmpty()) {
                        Toast.makeText(BaiToan.this, "Lỗi: Vui lòng nhập đủ 2 số", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    double so1 = Double.parseDouble(s1);
                    double so2 = Double.parseDouble(s2);

                    if (so2 == 0) {
                        Toast.makeText(BaiToan.this, "Không thể chia cho 0", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    double ketQua = so1 / so2;

                    if (ketQua == (long) ketQua) {
                        tvKetQua.setText(String.format(java.util.Locale.US, "%d", (long) ketQua));
                    } else {
                        tvKetQua.setText(String.format("%s", ketQua));
                    }

                } catch (NumberFormatException e) {
                    Toast.makeText(BaiToan.this, "Lỗi", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etSo1.setText("");
                etSo2.setText("");
                tvKetQua.setText("0");
                Toast.makeText(BaiToan.this, "Bạn đã reset", Toast.LENGTH_SHORT).show();
            }
        });
    }
}