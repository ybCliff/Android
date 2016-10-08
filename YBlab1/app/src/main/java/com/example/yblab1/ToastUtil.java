package com.example.yblab1;

/**
 * Created by 杨邦 on 2016/10/6.
 */

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    private static Toast mToast;
    public static void SHOW(Context context, String msg, int duration) {
        if (mToast != null)
            mToast.cancel();
        mToast = Toast.makeText(context, msg, duration);
        mToast.show();
    }
}