package com.blazeey.newsstandnav;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blazeey.newsstandnav.Model.Title;

import java.util.ArrayList;
import java.util.List;

import static com.blazeey.newsstandnav.Utils.AlgorithmUtils.minMax;

public class MainActivity extends AppCompatActivity {

    ImageView titleBackground;
    Context context;
    ViewPager viewPager;
    int offset = 36;
    int viewPagerPadding = 200;
    CollapsingToolbarLayout collapsingToolbarLayout;
    List<Title> tabNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        titleBackground = findViewById(R.id.back);
        viewPager = findViewById(R.id.viewpager);
        viewPager.setClipToPadding(false);
        viewPagerPadding=200;
        viewPager.setOffscreenPageLimit(10);
        viewPager.setPadding(viewPagerPadding, 0, viewPagerPadding, 0);
        tabNames.add(new Title("GAMING", R.color.red));
        tabNames.add(new Title("SCIENCE", R.color.green));
        tabNames.add(new Title("SPORTS", R.color.colorAccent));
        tabNames.add(new Title("TECHNOLOGY", R.color.colorPrimary));
        CustomTabs customTabs = new CustomTabs(this, tabNames);
        viewPager.setAdapter(customTabs);
        viewPager.addOnPageChangeListener(pageChange);

        NestedScrollView scrollView = findViewById(R.id.scrolling);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) scrollView.getLayoutParams();
        params.setBehavior(new CustomBehavior(this, viewChangedListener));

    }

    ViewPager.OnPageChangeListener pageChange = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            titleBackground.setImageDrawable(new ColorDrawable(context.getResources().getColor(tabNames.get(position).getResource())));
            HorizontalTabs horizontalTabs = viewPager.getChildAt(position).findViewById(R.id.tabs);
            horizontalTabs.setSelected(position);
        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    CustomBehavior.ViewChangedListener viewChangedListener = new CustomBehavior.ViewChangedListener() {
        @Override
        public void onHeightChanged(float height) {
            AppBarLayout appBarLayout = findViewById(R.id.app_bar);
            Toolbar toolbar = findViewById(R.id.toolbar);
            int heightAppbar = appBarLayout.getHeight();
            int heightToolbar = toolbar.getHeight();
            int old = viewPagerPadding;

            viewPagerPadding = (int) minMax(heightToolbar,heightAppbar,0,200,height);
            viewPager.setPadding(viewPagerPadding, 0, viewPagerPadding, 0);

            int curr = viewPager.getCurrentItem();
            if(curr!=0){
                disableHighlight(viewPager.getChildAt(curr-1));
            }
            if (curr != tabNames.size()-1) {
                disableHighlight(viewPager.getChildAt(curr+1));
            }
            if(viewPager.getChildAt(curr)!=null)
                highlight(viewPager.getChildAt(curr));

            if(curr!=0){
                viewPager.scrollBy((2*curr*(old-viewPagerPadding)),0);
            }
            
        }
    };

    void disableHighlight(View view){
        TextView textView = view.findViewById(R.id.text);
        textView.setTextColor(Color.LTGRAY);
    }

    void highlight(View view){
        TextView textView = view.findViewById(R.id.text);
        textView.setTextColor(Color.WHITE);
    }
}
