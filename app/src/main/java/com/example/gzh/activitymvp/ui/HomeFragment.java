package com.example.gzh.activitymvp.ui;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.gzh.activitymvp.R;
import com.example.gzh.activitymvp.base.BaseFragment;

import butterknife.BindView;

/**
 * 首页
 */
public class HomeFragment extends BaseFragment {


    @BindView(R.id.videoView)
    VideoView videoView;


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
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
        setFragmentTitle("首页");

        videoView.setVideoPath("http://rbv01.ku6.com/omtSn0z_PTREtneb3GRtGg.mp4");
//        videoView.setVideoURI(Uri.parse("http://rbv01.ku6.com/omtSn0z_PTREtneb3GRtGg.mp4"));
        videoView.setMediaController(new MediaController(getActivity()));
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
//                videoView.start();
            }
        });


    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }



}
