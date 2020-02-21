package com.t3h.perfecthostel.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

/**
 * Created by Linh Nguyen Thuy on 9/27/2019.
 */
public abstract class Basefragment<DB extends ViewDataBinding> extends Fragment {
    protected DB binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        initViewFragment();
        return binding.getRoot();
    }

    protected abstract void initViewFragment();

    protected abstract int getLayoutId();


}
