package com.blazeey.newsstandnav.Utils;

import android.content.res.Resources;
import android.util.TypedValue;

public class ScreenUtils {
    public static float getPixels(int dp){
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
    }

    public static float getDp(int px){
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX,px,Resources.getSystem().getDisplayMetrics());
    }
}
