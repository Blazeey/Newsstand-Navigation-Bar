package com.blazeey.newsstandnav;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.blazeey.newsstandnav.Utils.ScreenUtils;

public class HorizontalTabs extends LinearLayout{

    private Context context;
    private View[] tabs;
    private int highlightColor = Color.WHITE;
    private int disableHighlightColor = Color.LTGRAY;
    private int leftMargin = 2,rightMargin = 2;
    private int numTabs = 4;
    private int tabWidth = 25,tabHeight = 3;
    private int currentSelected = 0;

    public HorizontalTabs(Context context) {
        super(context);
        this.context = context;
        setUpUI();
    }

    public HorizontalTabs(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setUpUI();
    }

    public HorizontalTabs(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        setUpUI();
    }

    public HorizontalTabs(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
        setUpUI();
    }

    private void setUpUI(){
        setOrientation(HORIZONTAL);
        tabs = new View[numTabs];

        for(int i=0;i<numTabs;i++){
            tabs[i] = new View(context);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int)ScreenUtils.getPixels(tabWidth),(int)ScreenUtils.getPixels(tabHeight));
            params.leftMargin = (int) ScreenUtils.getPixels(leftMargin);
            params.rightMargin = (int) ScreenUtils.getPixels(rightMargin);
            if(i==0){
                makeSelected(i);
            }
            else{
                makeUnSelected(i);
            }
            addView(tabs[i],params);
            Log.v("Count",getChildCount()+"");
        }
    }

    public void setTabCount(int tabCount){
        this.numTabs = tabCount;
    }

    private void makeSelected(int position){
        tabs[position].setBackgroundColor(highlightColor);
        currentSelected = position;
    }

    private void makeUnSelected(int position){
        tabs[position].setBackgroundColor(disableHighlightColor);
    }

    public void setSelected(int position){
        makeSelected(position);
        if(position!=0)
            makeUnSelected(position-1);
        if(position!=numTabs-1)
            makeUnSelected(position+1);
        for(int i=0;i<numTabs;i++){
            tabs[i].setVisibility(GONE);
        }
        tabs[position].setVisibility(VISIBLE);
    }

    public int getCurrentSelected(){
        return currentSelected;
    }
}
