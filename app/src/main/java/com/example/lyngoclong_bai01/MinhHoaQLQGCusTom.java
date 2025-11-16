package com.example.lyngoclong_bai01;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MinhHoaQLQGCusTom extends AppCompatActivity {

    ListView listView;
    ArrayList<Qgia> data;
    QgiaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.minhhoalistview);

        listView = findViewById(R.id.lvquocgia);

        // Create sample data
        data = new ArrayList<>();
        data.add(new Qgia("Việt Nam", 98000000));
        data.add(new Qgia("Hàn Quốc", 51000000));
        data.add(new Qgia("Nhật Bản", 126000000));
        data.add(new Qgia("Hoa Kỳ", 331000000));

        // Initialize adapter
        adapter = new QgiaAdapter(this, data);

        // Set adapter to ListView
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuquocgia, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.themquocgia) {
            data.add(new Qgia("Quốc gia mới", 1000000));
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Đã thêm một quốc gia mới", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.xoaquocgia) {
            if (!data.isEmpty()) {
                data.remove(data.size() - 1);
                adapter.notifyDataSetChanged();
                Toast.makeText(this, "Đã xóa một quốc gia", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Danh sách trống", Toast.LENGTH_SHORT).show();
            }
            return true;
        } else if (itemId == R.id.truyendl) {
            Toast.makeText(this, "Bạn đã chọn chức năng Truyền dữ liệu", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.thoat) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}