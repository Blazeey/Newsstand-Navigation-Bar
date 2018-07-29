package com.blazeey.newsstandnav;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.blazeey.newsstandnav.Model.Title;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView titleBackground;
    Context context;
    CollapsingToolbarLayout collapsingToolbarLayout;
    List<Title> tabNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        titleBackground = findViewById(R.id.back);
        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setPageMargin(50);
        viewPager.setClipToPadding(false);
        viewPager.setPadding(200, 0, 200, 0);
        tabNames.add(new Title("Gaming",R.color.red));
        tabNames.add(new Title("Science",R.color.green));
        tabNames.add(new Title("Sports",R.color.colorAccent));
        tabNames.add(new Title("Technology",R.color.colorPrimary));
        CustomTabs customTabs = new CustomTabs(this,tabNames,titleBackground);
        viewPager.setAdapter(customTabs);
        viewPager.addOnPageChangeListener(pageChange);

        NestedScrollView scrollView = findViewById(R.id.scrolling);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) scrollView.getLayoutParams();
        params.setBehavior(new CustomBehavior(this));


    }

        ViewPager.OnPageChangeListener pageChange = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            titleBackground.setImageDrawable(new ColorDrawable(context.getResources().getColor( tabNames.get(position).getResource())));
        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

}
