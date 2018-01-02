package com.hss01248.picassopicker;

import android.content.Context;

import com.hss01248.image.ImageLoader;
import com.hss01248.picasso.PicassoLoader;

import me.iwf.photopicker.PhotoPickUtils;
import me.iwf.photopicker.interfacess.BaseHolderGenerator;
import me.iwf.photopicker.utils.Initer;

/**
 * Created by Administrator on 2017/5/4 0004.
 */

public class PicassoIniter extends Initer {
    @Override
    public void init(Context context) {
        super.init(context);
        ImageLoader.init(context,150,new PicassoLoader());
        PhotoPickUtils.holderGenerator = new BaseHolderGenerator();
    }
}
