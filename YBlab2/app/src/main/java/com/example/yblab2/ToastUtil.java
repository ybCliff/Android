package com.example.yblab2;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 杨邦 on 2016/10/6.
 */
public class ToastUtil {
    private static Toast mToast;
    public static void SHOW(Context context, String msg, int duration) {
        if (mToast != null)
            mToast.cancel();
        mToast = Toast.makeText(context, msg, duration);
        mToast.show();
    }
}