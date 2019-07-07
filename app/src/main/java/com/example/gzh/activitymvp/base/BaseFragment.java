package com.example.gzh.activitymvp.base;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.gzh.activitymvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 父Fragment
 */
public abstract class BaseFragment extends Fragment {

    private Unbinder unbinder;
    private FrameLayout frameLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tvtitle)
    TextView fragmetTitle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View contentView = inflater.inflate(R.layout.fragment_base, container, false);
        frameLayout = contentView.findViewById(R.id.frame);
        inflater.inflate(getLayoutId(), frameLayout);

        return contentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        init(savedInstanceState);

        ((AppCompatActivity) getActivity()).setSupportActionBar((toolbar));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    /**
     * 初始化views
     *
     * @param state
     */
    public abstract void init(Bundle state);

    /**
     * 获取layout
     */
    public abstract int getLayoutId();

    public void setFragmentTitle(String title) {
        fragmetTitle.setText(title);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
