package com.blazeey.newsstandnav;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

public class CustomViewPager extends ViewPager{

    public CustomViewPager(@NonNull Context context) {
        super(context);
    }

    public CustomViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void scrollTo(int x, int y) {
        x -= (int) (getMeasuredWidth() * (1 - getAdapter().getPageWidth(getCurrentItem())) / 2);

        super.scrollTo(x, y);
    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        super.setPadding(left, top, right, bottom);
    }

    public void setPaddin(int left, int top, int right, int bottom,int current){
        if(getCurrentItem()==current)
            setPadding(left,top ,right , bottom);
    }
}
