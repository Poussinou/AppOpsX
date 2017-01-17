package com.zzzmode.appopsx.ui.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.zzzmode.appopsx.OpsxManager;

/**
 * Created by zl on 2016/11/19.
 */

public class AppOpsx {

    private static OpsxManager sManager;

    public static OpsxManager getInstance(Context context) {
        if(sManager == null){
            synchronized (AppOpsx.class){
                if(sManager == null){
                    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
                    OpsxManager.Config config=new OpsxManager.Config();
                    config.allowBgRunning=sp.getBoolean("allow_bg_remote",false);
                    sManager=new OpsxManager(context.getApplicationContext(),config);
                }
            }
        }
        return sManager;
    }
}
