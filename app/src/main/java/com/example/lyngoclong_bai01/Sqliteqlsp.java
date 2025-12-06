package com.example.lyngoclong_bai01;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Sqliteqlsp extends AppCompatActivity {
    EditText name, desc;
    Button them, monhac;
    ListView lvsp;
    
    ArrayList<String> listString = new ArrayList<>();
    ArrayAdapter<String> adapter;
    DbHelper dbHelper;
    ArrayList<SanPham> listSanPham = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mhthsqlite);

        them = findViewById(R.id.btnThemSp);
        desc = findViewById(R.id.editDESC);
        name = findViewById(R.id.editName);
        monhac = findViewById(R.id.btnMonhac);
        lvsp = findViewById(R.id.lvProducts);

        dbHelper = new DbHelper(this);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listString);
        lvsp.setAdapter(adapter);

        loadData();

        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = name.getText().toString();
                String mota = desc.getText().toString();
                
                if(ten.isEmpty() || mota.isEmpty()){
                    Toast.makeText(Sqliteqlsp.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                
                SanPham sp = new SanPham(ten, mota);
                if(dbHelper.them(sp)){
                    Toast.makeText(Sqliteqlsp.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    loadData();
                    name.setText("");
                    desc.setText("");
                    name.requestFocus();
                } else {
                    Toast.makeText(Sqliteqlsp.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });



        monhac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Toast.makeText(Sqliteqlsp.this, "Chức năng đang phát triển", Toast.LENGTH_SHORT).show();
            }
        });
    }
    
    private void loadData(){
        listSanPham.clear();
        listSanPham.addAll(dbHelper.layTatCa());
        listString.clear();
        for(SanPham sp : listSanPham){
            listString.add(sp.getName() + " - " + sp.getMota());
        }
        adapter.notifyDataSetChanged();
    }
}
