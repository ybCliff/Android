package com.example.yblab3;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle bundle = this.getIntent().getExtras();
        String Name = (String) bundle.get("name");
        /*int colorID = (int) bundle.get("colorID");
        int phoneID = (int) bundle.get("phoneID");
        int addressID = (int) bundle.get("addressID");*/
        String color = (String) bundle.get("color");
        String phonenumber = (String) bundle.get("phone");
        String Address = (String) bundle.get("address");

        final TextView name = (TextView) findViewById(R.id.TV);
        final RelativeLayout bk = (RelativeLayout) findViewById(R.id.RL);
        final TextView phone = (TextView) findViewById(R.id.phone);
        final TextView address = (TextView) findViewById(R.id.address);

        name.setText(Name);
 /*       bk.setBackgroundColor(getResources().getInteger(colorID));
        phone.setText(getResources().getText(phoneID));
        address.setText(getResources().getText(addressID));*/
        bk.setBackgroundColor(Color.parseColor(color));
        phone.setText(phonenumber);
        address.setText(Address);

        final ImageView back = (ImageView) findViewById(R.id.back);
        final ImageView star = (ImageView) findViewById(R.id.star);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        star.setOnClickListener(new View.OnClickListener() {
            boolean judge = true;
            @Override
            public void onClick(View v) {
                if(judge)
                    star.setImageResource(R.mipmap.full_star);
                else
                    star.setImageResource(R.mipmap.empty_star);
                judge = !judge;
            }
        });


        final ListView oplist = (ListView) findViewById(R.id.oplist);
        String[] operations = new String[] {"编辑联系人","分享联系人","加入黑名单","删除联系人"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.operation_item, operations);
        oplist.setAdapter(arrayAdapter);
    }
}
