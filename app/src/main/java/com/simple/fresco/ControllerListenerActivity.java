package com.simple.fresco;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.QualityInfo;

/**
 * Created by zhangzeyan on 16/11/8.
 */
public class ControllerListenerActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_normal_use);

        Uri uri = Uri.parse("http://img2.cache.netease.com/auto/2016/7/28/201607282215432cd8a.jpg");
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_image_view);

        ControllerListener listener = new BaseControllerListener<ImageInfo>(){
            @Override
            public void onFinalImageSet(
                    String id,
                    @Nullable ImageInfo imageInfo,
                    @Nullable Animatable anim) {
                if (imageInfo == null) {
                    return;
                }
                QualityInfo qualityInfo = imageInfo.getQualityInfo();
                FLog.d("Final image received! " +
                                "Size %d x %d",
                        "Quality level %d, good enough: %s, full quality: %s",
                        imageInfo.getWidth(),
                        imageInfo.getHeight(),
                        qualityInfo.getQuality(),
                        qualityInfo.isOfGoodEnoughQuality(),
                        qualityInfo.isOfFullQuality());
                Toast.makeText(ControllerListenerActivity.this,"onFinalImageSet", Toast.LENGTH_LONG).show();
            }

            public void onIntermediateImageSet(String id, @Nullable ImageInfo imageInfo) {
                Toast.makeText(ControllerListenerActivity.this,"onIntermediateImageSet", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(String id, Throwable throwable) {
                Toast.makeText(ControllerListenerActivity.this,"onFailure", Toast.LENGTH_LONG).show();
            }
        };

        DraweeController controller1 = Fresco.newDraweeControllerBuilder()
                .setControllerListener(listener)
                .setUri(uri)
                .build();

        draweeView.setController(controller1);



    }
}
