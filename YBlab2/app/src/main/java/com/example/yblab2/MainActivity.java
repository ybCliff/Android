package com.example.yblab2;
import android.content.DialogInterface;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button login = (Button) findViewById(R.id.log);
        final Button register = (Button) findViewById(R.id.reg);
        final RadioGroup rg = (RadioGroup) findViewById(R.id.rg);
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        final TextInputLayout usernameWrapper = (TextInputLayout) findViewById(R.id.user_name);
        final TextInputLayout passwordWrapper = (TextInputLayout) findViewById(R.id.password);
        final EditText username = (EditText) usernameWrapper.getEditText();
        final EditText password = (EditText) passwordWrapper.getEditText();

        final SnackbarUtil mySnackbar = null;
        final View CL = findViewById(R.id.CL);

        //对话框设置
        alertDialog.setTitle("提示").setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mySnackbar.SHOW(CL, "对话框“取消”按钮被点击");
                    }
                }
        ).setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mySnackbar.SHOW(CL, "对话框“确定”按钮被点击");
                    }
                }).create();

        //监听登录按钮点击事件
        login.setOnClickListener(new View.OnClickListener() {       //登录按钮点击事件
            @Override
            public void onClick(View view) {
                int judge = 0;
                if (TextUtils.isEmpty(username.getText().toString()))
                    usernameWrapper.setError("用户名不能为空");
                else {
                    usernameWrapper.setErrorEnabled(false);
                    judge++;
                }

                if (judge == 0)
                    passwordWrapper.setErrorEnabled(false);
                else{
                    if(TextUtils.isEmpty(password.getText().toString()))
                        passwordWrapper.setError("密码不能为空");
                    else {
                        passwordWrapper.setErrorEnabled(false);
                        judge=2;
                    }
                }

                if (username.getText().toString().equals("Android") && password.getText().toString().equals("123456")) {
                    alertDialog.setMessage("登录成功");
                    alertDialog.show();
                }
                else if(judge == 2){
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
                        mySnackbar.SHOW(CL, tmp.getText() + "身份被选中");
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
                        mySnackbar.SHOW(CL, tmp.getText() + "身份注册功能尚未开启");
                        break;
                    }
                }
            }
        });
    }

}

