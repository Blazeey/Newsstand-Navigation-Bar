package com.blazeey.newsstandnav;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

public class CustomBehavior extends AppBarLayout.ScrollingViewBehavior {

    private Context context;

    private static final String TAG = "Behavior";

    public CustomBehavior(Context context) {
        this.context = context;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        super.onDependentViewChanged(parent, child, dependency);

        Log.d(TAG, "onDependentViewChanged: Dependency : "+dependency.getX());
        Log.d(TAG, "onDependentViewChanged: Dependency : "+dependency.getY());

        Log.d(TAG, "onDependentViewChanged: Child: "+child.getX());
        Log.d(TAG, "onDependentViewChanged: Child: "+child.getY());

        ViewPager viewPager = child.findViewById(R.id.viewpager);

        return true;
    }

}
