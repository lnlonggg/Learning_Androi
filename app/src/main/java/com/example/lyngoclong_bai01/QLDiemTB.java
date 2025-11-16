package com.example.lyngoclong_bai01;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class QLDiemTB extends AppCompatActivity {
    ListView dtb;
    ArrayList<Double> dta = new ArrayList<>();
    ArrayAdapter<Double> ad;
    Button btT, btS;

    TextView tvDtb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dsdtb);
        dtb = (ListView) findViewById(R.id.lvdtb);
        btT = (Button) findViewById(R.id.btTong);
        btS = (Button) findViewById(R.id.btSL);
        tvDtb = (TextView) findViewById(R.id.tvKqDtb);
        dta.add(7.9);
        dta.add(8.3);
        dta.add(6.7);
        dta.add(4.5);
        dta.add(7.2);
        dta.add(9.0);
        dta.add(10.0);
        ad = new ArrayAdapter<Double>(this, android.R.layout.simple_list_item_1,dta);
        dtb.setAdapter(ad);
        dtb.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(QLDiemTB.this, "Số điểm của bạn: " + dta.get(position), Toast.LENGTH_LONG).show();
            }
        });
        dtb.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(QLDiemTB.this, "Đã xóa: " + dta.get(position), Toast.LENGTH_SHORT).show();
                dta.remove(position);
                ad.notifyDataSetChanged();
                return true;
            }
        });
        btT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ad.getCount() == 0){
                    Toast.makeText(QLDiemTB.this, "Danh sách điểm trống", Toast.LENGTH_LONG).show();
                }else{
                    double tong = 0;
                    for (int i = 0; i < ad.getCount(); i++){
                        tong += ad.getItem(i);
                    }
                    double dtb = tong / ad.getCount();
                    tvDtb.setText("Điểm trung bình: " + dtb);
                    Toast.makeText(QLDiemTB.this, "Đã tính ĐTB", Toast.LENGTH_LONG).show();
                }
            }
        });
        
        btS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Toast.makeText(QLDiemTB.this,"Số lượng điểm: "+ ad.getCount(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuquocgia, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.truyendl) {
            Intent intent = new Intent(QLDiemTB.this, MinhHoaQLQGCusTom.class);
            Bundle bundle = new Bundle();

            // Tính toán và đặt dữ liệu vào bundle
            if (!dta.isEmpty()) {
                double tong = 0;
                for (double diem : dta) {
                    tong += diem;
                }
                double dtb = tong / dta.size();
                bundle.putDouble("DIEM_TRUNG_BINH", dtb);
                intent.putExtras(bundle);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Danh sách điểm trống, không có gì để gửi", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}