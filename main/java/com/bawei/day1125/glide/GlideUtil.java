package com.bawei.day1125.glide;

import android.widget.ImageView;

import com.bawei.day1125.R;
import com.bawei.day1125.app.App;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 *  * @ActivityName: GlideUtil
 *  * @Description: Activity介绍
 *  * @author: 闫圣豪
 *  * @date: 2019/11/25
 */
public class GlideUtil {
    public static void LoadImage(String url, ImageView imageView){
        Glide.with(App.context)
                .load(url)
                .error(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
    }
}
