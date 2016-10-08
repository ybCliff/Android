package com.example.yblab1;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button login = (Button) findViewById(R.id.log);
        final Button register = (Button) findViewById(R.id.reg);
        final EditText username = (EditText) findViewById(R.id.user_name);
        final EditText password = (EditText) findViewById(R.id.password);
        final RadioGroup rg = (RadioGroup) findViewById(R.id.rg);
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        final ToastUtil myToast = null;
        //对话框设置
        alertDialog.setTitle("提示").setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        myToast.SHOW(getApplicationContext(), "对话框“取消”按钮被点击", Toast.LENGTH_SHORT);
                    }
                }
        ).setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        myToast.SHOW(getApplicationContext(), "对话框“确定”按钮被点击", Toast.LENGTH_SHORT);
                    }
                }).create();

        //监听登录按钮点击事件
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(username.getText().toString())) {
                    myToast.SHOW(getApplicationContext(), "用户名不能为空", Toast.LENGTH_SHORT);
                }
                else if (TextUtils.isEmpty(password.getText().toString())) {
                    myToast.SHOW(getApplicationContext(), "密码不能为空", Toast.LENGTH_SHORT);
                }
                else if (username.getText().toString().equals("Android") && password.getText().toString().equals("123456")) {
                    alertDialog.setMessage("登录成功");
                    alertDialog.show();
                }
                else{
                    alertDialog.setMessage("登录失败");
                    alertDialog.show();
                }
            }
        });
        //监听单选按钮组选择切换事件
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for(int i=0; i<rg.getChildCount(); i++) {
                    RadioButton tmp = (RadioButton) rg.getChildAt(i);
                    if (tmp.getId() == checkedId) {
                        myToast.SHOW(getApplicationContext(), tmp.getText() + "身份被选中", Toast.LENGTH_SHORT);
                        break;
                    }
                }
            }
        });
        //监听注册按钮点击事件
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                for(int i=0; i<rg.getChildCount(); i++){
                    RadioButton tmp = (RadioButton) rg.getChildAt(i);
                    if(tmp.isChecked()) {
                        myToast.SHOW(getApplicationContext(), tmp.getText() + "身份注册功能尚未开启", Toast.LENGTH_SHORT);
                        break;
                    }
                }
            }
        });

    }

}
