package com.example.yblab2;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

/**
 * Created by 杨邦 on 2016/10/6.
 */
public class SnackbarUtil {
    private static Snackbar Sb;
    private static ToastUtil mToast;
    public static void SHOW(View v, String msg) {
        Sb = Snackbar.make(v, msg, Snackbar.LENGTH_SHORT);
        Sb.setAction("关闭", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mToast.SHOW(v.getContext(), "按钮被点击", Toast.LENGTH_LONG);
            }
        });
        Sb.show();
    }
}



