package com.t3h.perfecthostel.fragment;

import androidx.viewpager.widget.ViewPager;

import com.t3h.perfecthostel.R;
import com.t3h.perfecthostel.base.Basefragment;
import com.t3h.perfecthostel.databinding.HomeFragmentBinding;
import com.t3h.perfecthostel.model.ImageBanner;

import java.util.ArrayList;

/**
 * Created by Linh Nguyen Thuy on 9/27/2019.
 */
public class HomeFragment extends Basefragment<HomeFragmentBinding> {

    private static ViewPager mPaper;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private ArrayList<ImageBanner> mList;

    private int[] imageList = new int[]{R.drawable.download,
                                        R.drawable.download1,
                                        R.drawable.thiet_ke_banner_dep_quang_cao_online_minh_duong1_9,
                                        R.drawable.thietkeweb};

    @Override
    public int getLayoutId() {
        return R.layout.home_fragment;
    }

    @Override
    protected void initViewFragment() {
        mList = new ArrayList<>();
        mList = populateList();
    }

    private ArrayList<ImageBanner> populateList() {

    }
}
