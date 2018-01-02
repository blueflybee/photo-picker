package me.iwf.PhotoPickerDemo;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import com.hss01248.frescopicker.FrescoIniter;
import com.hss01248.image.ImageLoader;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import me.iwf.photopicker.PhotoPickUtils;

/**
 * Created by Administrator on 2017/3/25.
 */

public class BaseApp extends Application {
    int count =0;
   private   RefWatcher refWatcher;

    public static RefWatcher getRefWatcher(Context context){
        BaseApp application = (BaseApp) context.getApplicationContext();
        return application.refWatcher;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        refWatcher=  LeakCanary.install(this);
        PhotoPickUtils.init(getApplicationContext(),new FrescoIniter());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
                @Override
                public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

                }

                @Override
                public void onActivityStarted(Activity activity) {
                    count++;
                }

                @Override
                public void onActivityResumed(Activity activity) {


                }

                @Override
                public void onActivityPaused(Activity activity) {


                }

                @Override
                public void onActivityStopped(Activity activity) {
                    count--;
                    if(count==0){
                        //进入后台了
                        ImageLoader.getActualLoader().clearMomoryCache();

                    }
                }

                @Override
                public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

                }

                @Override
                public void onActivityDestroyed(Activity activity) {

                }
            });
        }
    }
}
