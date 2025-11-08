package com.example.lyngoclong_bai01;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class QLCacQuocGia extends AppCompatActivity {
    ListView lvqg;
    ArrayList<String> data = new ArrayList<>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dssp);

        lvqg = (ListView) findViewById(R.id.lvquocgia);
        data.add("Việt Nam");
        data.add("Mỹ");
        data.add("Anh");
        data.add("Lào");
        data.add("Camp");
        data.add("Thái");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);
        lvqg.setAdapter(adapter);
        lvqg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = data.get(position);
                Toast.makeText(QLCacQuocGia.this, "Bạn vừa chọn quốc gia: " + s + " với i = "+position,Toast.LENGTH_LONG ).show();

            }
        });
    }
}