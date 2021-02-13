package task.android.com.weatherapp.common.utils;

import android.content.Context;

import android.text.format.DateUtils;
import android.view.View;
import android.widget.Toast;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class ActivityUtils {
    private ActivityUtils() {
    }



    public static void setVisibility(int v, View... views) {
        for (View view : views) {
            view.setVisibility(v);
        }
    }
    public static void showToast(Context context, int stringId) {
        showToast(context,context.getString(stringId));
    }

    public static void showToast(Context context, String string) {
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
    }

}
