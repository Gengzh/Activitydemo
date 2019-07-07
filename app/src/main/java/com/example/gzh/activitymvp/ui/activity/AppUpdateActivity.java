package com.example.gzh.activitymvp.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gzh.activitymvp.R;
import com.example.gzh.activitymvp.base.BaseActivity;
import com.example.gzh.activitymvp.utils.updateapp.UpdateAppBean;
import com.example.gzh.activitymvp.utils.updateapp.UpdateAppHttpUtil;
import com.example.gzh.activitymvp.utils.updateapp.UpdateAppManager;
import com.example.gzh.activitymvp.utils.updateapp.UpdateCallback;
import com.example.gzh.activitymvp.utils.updateapp.listener.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

/**
 * app更新版本
 */
public class AppUpdateActivity extends BaseActivity {

    @BindView(R.id.button)
    Button button;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_app_update);
//    }

    private String mUpdateUrl = "https://raw.githubusercontent.com/WVector/AppUpdateDemo/master/json/json.txt";
    @Override
    public void initView(Bundle bundle) {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                checkApp();
                new UpdateAppManager
                        .Builder()
                        //当前Activity
                        .setActivity(AppUpdateActivity.this)
                        //更新地址
                        .setUpdateUrl(mUpdateUrl)
                        .handleException(new ExceptionHandler() {
                            @Override
                            public void onException(Exception e) {
                                e.printStackTrace();
                            }
                        })
                        //实现httpManager接口的对象
                        .setHttpManager(new UpdateAppHttpUtil())
                        .build()
                        .update();
            }});



    }

    @Override
    public int getContentView() {
        return R.layout.activity_app_update;
    }

    private void checkApp(){
        Map<String, String> params = new HashMap<String, String>();

        params.put("key1", "value1");
        params.put("key2", "value2");
        params.put("key3", "value3");
        params.put("key4", "value4");


        new UpdateAppManager
                .Builder()
                //当前Activity
                .setActivity(this)
                //实现httpManager接口的对象
                .setHttpManager(new UpdateAppHttpUtil())
                //设置请求方式 默认get,
                .setPost(false)
                //更新地址
                .setUpdateUrl("https://raw.githubusercontent.com/WVector/AppUpdateDemo/master/json/json.txt")
                //添加自定义参数
                .setParams(params)
                //设置头部
                .setTopPic(R.mipmap.top_5)
                //设置主题色
                .setThemeColor(0xff034ea0)
                .build()
                //检测是否有新版本
                .checkNewApp(new UpdateCallback() {
                    /**
                     * 解析json,自定义协议
                     *
                     * @param json 服务器返回的json
                     * @return UpdateAppBean
                     */
                    @Override
                    protected UpdateAppBean parseJson(String json) {
                        UpdateAppBean updateAppBean = new UpdateAppBean();
//                        try {
//                            JSONObject jsonObject = new JSONObject(json);
//                            updateAppBean
//                                    //是否更新Yes,No
//                                    .setUpdate(jsonObject.getString("update"))
//                                    //新版本号
//                                    .setNew_version(jsonObject.getString("new_version"))
//                                    //下载地址
//                                    .setApk_file_url(jsonObject.getString("apk_file_url"))
//                                    //大小
//                                    .setTarget_size(jsonObject.getString("target_size"))
//                                    //更新内容
//                                    .setUpdate_log(jsonObject.getString("update_log"))
//                                    //是否强制更新
//                                    .setConstraint(jsonObject.getBoolean("constraint"));
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
                        return updateAppBean;
                    }

                    /**
                     * 有新版本
                     *
                     * @param updateApp        新版本信息
                     * @param updateAppManager app更新管理器
                     */
                    @Override
                    public void hasNewApp(UpdateAppBean updateApp, UpdateAppManager updateAppManager) {
                        updateAppManager.showDialogFragment();
                    }

                    /**
                     * 网络请求之前
                     */
                    @Override
                    public void onBefore() {
//                        CProgressDialogUtils.showProgressDialog(MainActivity.this);
                    }

                    /**
                     * 网路请求之后
                     */
                    @Override
                    public void onAfter() {
//                        CProgressDialogUtils.cancelProgressDialog(MainActivity.this);
                    }

                    /**
                     * 没有新版本
                     */
//                    @Override
                    public void noNewApp() {
                        Toast.makeText(AppUpdateActivity.this, "没有新版本", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
