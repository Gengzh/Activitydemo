package com.example.gzh.activitymvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gzh.activitymvp.R;
import com.example.gzh.activitymvp.base.BaseFragment;
import com.example.gzh.activitymvp.ui.activity.AnimActivity;
import com.example.gzh.activitymvp.ui.activity.AppUpdateActivity;
import com.example.gzh.activitymvp.ui.activity.HistoryWeatherActivity;
import com.example.gzh.activitymvp.ui.activity.NameActivity;
import com.example.gzh.activitymvp.ui.activity.NotificationActivity;
import com.example.gzh.activitymvp.ui.activity.OwnUppActivity;
import com.example.gzh.activitymvp.ui.activity.ToolbarActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 我的
 */
public class MineFragment extends BaseFragment {


    @BindView(R.id.mine_1)
    TextView mine1;
    @BindView(R.id.mine_2)
    TextView mine2;
    @BindView(R.id.mine_3)
    TextView mine3;
    @BindView(R.id.mine_4)
    TextView mine4;
    @BindView(R.id.mine_5)
    TextView mine5;
    @BindView(R.id.mine_6)
    TextView mine6;
    @BindView(R.id.mine_7)
    TextView mine7;
    @BindView(R.id.mine_8)
    TextView mine8;
    @BindView(R.id.mine_9)
    TextView mine9;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void init(Bundle state) {
        setFragmentTitle("我的");
//        Toast.makeText(getActivity(), "wo shi wo ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @OnClick({R.id.mine_1, R.id.mine_2, R.id.mine_3, R.id.mine_4, R.id.mine_5, R.id.mine_6, R.id.mine_7, R.id.mine_8, R.id.mine_9
    ,R.id.mine_10})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mine_1:
                startActivity(new Intent(getActivity(),NameActivity.class));
                break;
            case R.id.mine_2:
                break;
            case R.id.mine_3:
                break;
            case R.id.mine_4:
                startActivity(new Intent(getActivity(), ToolbarActivity.class));
                break;
            case R.id.mine_5:
                startActivity(new Intent(getActivity(), AppUpdateActivity.class));
                break;
            case R.id.mine_6:
                startActivity(new Intent(getActivity(), OwnUppActivity.class));
                break;
            case R.id.mine_7:
                startActivity(new Intent(getActivity(), OwnUppActivity.class));
                break;
            case R.id.mine_8:
                startActivity(new Intent(getActivity(), NotificationActivity.class));
                break;
            case R.id.mine_9://历史天气
                startActivity(new Intent(getActivity(), HistoryWeatherActivity.class));
                break;
            case R.id.mine_10://动画
                startActivity(new Intent(getActivity(), AnimActivity.class));
                break;
        }
    }
}
