package com.example.gzh.activitymvp.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gzh.activitymvp.R;
import com.example.gzh.activitymvp.base.BaseFragment;

/**
 * 发现
 */
public class FindFragment extends BaseFragment {

    public static FindFragment newInstance() {
        FindFragment fragment = new FindFragment();
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
        setFragmentTitle("发现");
        System.out.println("除法"+7/10);
        System.out.println("除法"+15%10);

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_find;
    }

    private void init() {
//        ((AppCompatActivity) getActivity()).setSupportActionBar((toolbar));
//        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
//        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

}
