package com.example.gzh.activitymvp.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gzh.activitymvp.R;
import com.example.gzh.activitymvp.base.BaseFragment;

/**
 * 娱乐
 */
public class ProductFragment extends BaseFragment {


    public static ProductFragment newInstance() {
        ProductFragment fragment = new ProductFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void init(Bundle state) {

        setFragmentTitle("娱乐");
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_product;
    }


}
