package com.example.lyngoclong_bai01;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class CacChucNang extends AppCompatActivity {

    //2. Khai báo
    RadioGroup rdgr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.manhinhcacchucnang);
        rdgr =(RadioGroup) findViewById(R.id.radiogroup);
        rdgr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                if(checkedId == R.id.goidien){
                    String sdt = "tel:19001508";
                    Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse(sdt));
                    startActivity(i);
                }else if(checkedId == R.id.luoiweb){
                    String web = "https://www.cafef.vn/";
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(web));
                    startActivity(i);
                }
                else if(checkedId == R.id.nhantin){
                    String sdt = "088888888";
                    Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + sdt));
                    i.putExtra("sms_body","Chao ban");
                    startActivity(i);
                } else if (checkedId == R.id.monhac) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setType("audio/*");
                    startActivity(i);
                } else if (checkedId == R.id.moanh) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setType("image/*");
                    startActivity(i);
                } else if (checkedId == R.id.dinhvi) {
                    String viTri = "geo:10.7769,106.6954";
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(viTri));
                    startActivity(mapIntent);
                }
            }
        });
    }
}
