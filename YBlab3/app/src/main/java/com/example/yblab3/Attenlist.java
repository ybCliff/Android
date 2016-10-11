package com.example.yblab3;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

public class Attenlist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attenlist);
        //final String Name[] = {"Aaron", "Elvis", "David", "Edwin", "Frank", "Joshua", "Ivan", "Mark", "Joseph", "Phoebe"};
        final List<String> list = new ArrayList<>();
        for(int i = 0; i < 10; i++)
            list.add((String) DataSet.list.get(i).get("name"));
        ListView lv = (ListView) findViewById(R.id.Attenlist);
        final MyAdapter myAdapter = new MyAdapter(this, list);
        lv.setAdapter(myAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent  intent = new Intent(Attenlist.this, Details.class);
                Bundle bundle = new Bundle();
                /*
                int colorID = getResources().getIdentifier("color"+list.get(position), "color", "com.example.yblab3");
                int phoneID = getResources().getIdentifier("phone"+list.get(position), "string", "com.example.yblab3");
                int addressID = getResources().getIdentifier("address"+list.get(position), "string", "com.example.yblab3");
                bundle.putInt("colorID", colorID);
                bundle.putInt("phoneID", phoneID);
                bundle.putInt("addressID", addressID);
                */
                bundle.putString("name", list.get(position));
                bundle.putString("color", (String) DataSet.list.get(position).get("color"));
                bundle.putString("phone", (String) DataSet.list.get(position).get("phone"));
                bundle.putString("address", (String) DataSet.list.get(position).get("address"));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        //对话框设置
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("提示").setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }
        ).create();
        //长按监听器
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                alertDialog.setMessage("你确定删除联系人"+list.get(position)+"?");
                alertDialog.setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                list.remove(position);
                                DataSet.remove(position);
                                myAdapter.refresh(list);
                            }
                        });
                alertDialog.show();
                return true;
            }
        });
    }
}
