//Chú ý của bài:
//Tạo file đuôi .json sau đó tạo code [{},{}] rồi copy vào trong ""

package com.example.lyngoclong_bai01;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ActivityChinh extends AppCompatActivity {
ListView lvKhachHang;
ArrayList<String> dataListKH;
ArrayAdapter<String> adapterKH;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.khachhangdocjson);
        lvKhachHang = findViewById(R.id.listViewKH);
        dataListKH = new ArrayList<>();
        String xaujson = "[\n" +
                "  {\n" +
                "    \"Ten\" : \"Tran Van Long\",\n" +
                "    \"So dien thoai\" : \"01234\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"Ten\" : \"Ly Ngoc Long\",\n" +
                "    \"So dien thoai\" : \"10234\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"Ten\" : \"Nguyen Van Long\",\n" +
                "    \"So dien thoai\" : \"20134\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"Ten\" : \"Le Van Long\",\n" +
                "    \"So dien thoai\" : \"30124\"\n" +
                "  }\n" +
                "]";
//        readKHjson(xaujson);
        loadfile();
        adapterKH = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataListKH);
        lvKhachHang.setAdapter(adapterKH);
    }

    private void readKHjson(String n){
        try {
            JSONArray array = new JSONArray(n);
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                String name = object.getString("Ten");
                String phone = object.getString("So dien thoai");
                dataListKH.add(name + " - " + phone);
            }

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
    private void loadfile(){
        try {
            InputStream is = getResources().openRawResource(R.raw.customer);
            BufferedReader bf = new BufferedReader(new InputStreamReader(is));
            StringBuilder bd = new StringBuilder();
            String dong;
            while ((dong = bf.readLine()) != null){
                bd.append(dong);
            }
            //Giong bai chuoi
            String json = bd.toString();
            JSONArray array = new JSONArray(json);
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                String name = object.getString("Ten");
                String phone = object.getString("So dien thoai");
                dataListKH.add(name + " - " + phone);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}