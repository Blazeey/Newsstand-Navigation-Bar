package com.blazeey.newsstandnav;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blazeey.newsstandnav.Model.Title;

import java.util.List;

public class CustomTabs extends PagerAdapter {

    private Context context;
    private List<Title> tabNames;
    private ImageView background;

    public CustomTabs(Context context, List<Title> tabNames, ImageView background){
        this.context = context;
        this.tabNames = tabNames;
        this.background = background;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ViewGroup view = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.item_tab,null,false);

        TextView tabName = view.findViewById(R.id.text);
        Title title = tabNames.get(position);
        tabName.setText(title.getTitle());
//        background.setImageDrawable(new ColorDrawable(context.getResources().getColor( title.getResource())));

        container.addView(view);
        return view;
    }

    @Override
    public float getPageWidth(int position) {
        return super.getPageWidth(position);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabNames.get(position).getTitle();
    }

    @Override
    public int getCount() {
        return tabNames.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
