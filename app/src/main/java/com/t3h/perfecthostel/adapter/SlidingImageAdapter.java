package com.t3h.perfecthostel.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.t3h.perfecthostel.R;
import com.t3h.perfecthostel.model.ImageBanner;

import java.util.ArrayList;

/**
 * Created by Linh Nguyen Thuy on 2/21/2020.
 */
public class SlidingImageAdapter extends PagerAdapter {
    private ArrayList<ImageBanner> list;
    private LayoutInflater inflater;
    private Context context;


    public SlidingImageAdapter(ArrayList<ImageBanner> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View imageLayout = inflater.inflate(R.layout.slidingimages_layout, container, false);

        assert  imageLayout != null;
        ImageView imageView = imageLayout.findViewById(R.id.image_banner);
        imageView.setImageResource(list.get(position).getImage_banner());
        container.addView(imageLayout, 0);
        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Nullable
    @Override
    public Parcelable saveState() {
        return null;
    }
}
