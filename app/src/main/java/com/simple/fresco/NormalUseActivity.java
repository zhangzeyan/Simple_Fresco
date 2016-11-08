package com.simple.fresco;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by zhangzeyan on 16/11/8.
 */
public class NormalUseActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_use);

        Uri uri = Uri.parse("http://img2.cache.netease.com/auto/2016/7/28/201607282215432cd8a.jpg");
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);
        draweeView.setImageURI(uri);

    }
}
