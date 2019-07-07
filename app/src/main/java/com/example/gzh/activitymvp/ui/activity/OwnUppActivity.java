package com.example.gzh.activitymvp.ui.activity;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.example.gzh.activitymvp.R;
import com.example.gzh.activitymvp.base.BaseActivity;
import com.zhy.http.okhttp.https.HttpsUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.BindView;

public class OwnUppActivity extends BaseActivity {

    @BindView(R.id.own_btn)
    Button btn;

    private NotificationCompat.Builder builder;
    private Notification nf;
    private NotificationManager nm;
    private Context context;

    @Override
    public int getContentView() {
        return R.layout.activity_own_upp;
    }

    @Override
    public void initView(Bundle bundle) {
        builder = new NotificationCompat.Builder(getBaseContext());
        nm = (NotificationManager) getSystemService(Activity.NOTIFICATION_SERVICE);
        context = this;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                downLoadAPK(OwnUppActivity.this, "http://static.lingmoney.cn/download/LingQian_L.apk");
                new MyDownloadAnsy().execute("http://static.lingmoney.cn/download/LingQian_L.apk");
            }
        });

    }

    /**
     * 下载新版本
     *
     * @param context
     * @param url
     */
    private void downLoadAPK(Context context, String url) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        try {
            final DownloadManager downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);

            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
            request.allowScanningByMediaScanner();
            request.setVisibleInDownloadsUi(true);//无关紧要 csdn不是全都写的属性
            request.setTitle("不变的");
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            request.setMimeType("application/vnd.android.package-archive");//设置下载文件的类型

            //删除文件
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/aaajuyoubang/", "juyou.apk");
            if (file.exists() && file.isFile()) {
                file.delete();
            }

            request.setDestinationInExternalPublicDir(Environment.getExternalStorageDirectory().getAbsolutePath() + "/aaajuyoubang/", "juyou.apk");
            long refernece = downloadManager.enqueue(request);
        } catch (Exception exception) {
            Toast.makeText(OwnUppActivity.this, "更新失败", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * 下载apk
     *
     * @param context
     * @param url
     */
    private void downloadApk(Context context, String url) {
        //实例化downloadmanager对象
        try {
            DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);

            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
            request.allowScanningByMediaScanner();
            request.setVisibleInDownloadsUi(true);
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            request.setMimeType("application/vnd.android.package-archive");
            request.setDestinationInExternalPublicDir(Environment.getExternalStorageDirectory().getAbsolutePath() + "/gengsong/", "gengsong.apk");
            long downloadId = downloadManager.enqueue(request);
        } catch (Exception e) {
            Toast.makeText(OwnUppActivity.this, "更新失败", Toast.LENGTH_SHORT).show();
        }


    }

    private void notifa() {

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(android.content.Context.NOTIFICATION_SERVICE);


    }

    public class MyDownloadAnsy extends AsyncTask<String, Integer, Integer> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            builder = new NotificationCompat.Builder(getBaseContext())
            builder .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentInfo("下载中...")
                    .setContentTitle("正在下载");
            nf = builder.build();
        }

        @Override
        protected Integer doInBackground(String... params) {

            //如果用这种方法，下载前要先删除路径上原有的包，不然不会重新下载 会直接安装路径上的旧包
            //所以先删除
            File file = new File("/sdcard/weixin.png");
            if(file.exists()){
                file.delete();
            }


            HttpURLConnection con = null;
            InputStream is = null;
            OutputStream os = null;

            try {
                URL url = new URL(params[0]);
                con = (HttpURLConnection) url.openConnection();
                con.setConnectTimeout(5 * 1000);  //设置超时时间
                if (con.getResponseCode() == 200) { //判断是否连接成功
                    int fileLength = con.getContentLength();
                    is = con.getInputStream();    //获取输入
                    os = new FileOutputStream("/sdcard/weixin.apk");
                    byte[] buffer = new byte[1024 * 1024 * 10];
                    long total = 0;
                    int count;
                    int pro1 = 0;
                    int pro2 = 0;
                    while ((count = is.read(buffer)) != -1) {
                        total += count;
                        if (fileLength > 0)
                            pro1 = (int) (total * 100 / fileLength);  //传递进度（注意顺序）
                        if (pro1 != pro2)
                            publishProgress(pro2 = pro1);
                        os.write(buffer, 0, count);
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (is != null) {
                        is.close();
                    }
                    if (os != null) {
                        os.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (con != null) {
                    con.disconnect();
                }
            }
            return 1;
        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);
            if (result == 1) {
                Toast.makeText(OwnUppActivity.this, "下载完成", Toast.LENGTH_SHORT).show();
//                builder = new NotificationCompat.Builder(getBaseContext())
                builder.setSmallIcon(R.mipmap.ic_launcher)
                        .setContentInfo("下载中完成...")
                        .setContentTitle("我的名字");
                nf = builder.build();
                Intent intents = new Intent();
                intents.setAction("android.intent.action.VIEW");
                intents.addCategory("android.intent.category.DEFAULT");
                intents.setType("application/vnd.android.package-archive");
                intents.setData(Uri.parse("file:///sdcard/weixin.apk"));
                intents.setDataAndType(Uri.parse("file:///sdcard/weixin.apk"), "application/vnd.android.package-archive");
                intents.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intents);
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.d("===", "" + values[0]);
            super.onProgressUpdate(values);
            builder.setProgress(100, values[0], false);
            nf = builder.build();
            nm.notify(0, nf);
            if (values[0] == 100) {    //下载完成后点击安装
                Intent it = new Intent(Intent.ACTION_VIEW);
                it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                it.setDataAndType(Uri.parse("file:///sdcard/weixin.apk"), "application/vnd.android.package-archive");
                PendingIntent pendingIntent = PendingIntent.getActivity(getBaseContext(), 0, it, PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentTitle("下载完成")
                        .setContentText("点击安装")
                        .setContentIntent(pendingIntent);
                nf = builder.build();
                nm.notify(0, nf);
            }
        }
    }


}
