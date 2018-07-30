package com.blazeey.newsstandnav;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;

public class CustomBehavior extends AppBarLayout.ScrollingViewBehavior {

    private Context context;
    private ViewChangedListener listener;

    private static final String TAG = "Behavior";

    public CustomBehavior(Context context,ViewChangedListener listener) {
        this.context = context;
        this.listener = listener;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        super.onDependentViewChanged(parent, child, dependency);

        listener.onHeightChanged(child.getY());
        return true;
    }

    public interface ViewChangedListener{
        void onHeightChanged(float height);
    }

}
