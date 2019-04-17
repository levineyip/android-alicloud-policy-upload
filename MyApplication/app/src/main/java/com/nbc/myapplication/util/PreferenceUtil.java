package com.nbc.myapplication.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.nbc.myapplication.MyApplication;

public class PreferenceUtil {

    public static final String KEY_ALI_CLOUD_OSS_POLICY = "ali_cloud_oss_policy";

    private static SharedPreferences getDefaultSharedPreferences() {
        Context context = MyApplication.getInstance().getApplicationContext();
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    /**
     * 保存阿里云OSS Policy信息
     *
     * @param aliCloudOSSPolicy
     */
    public static void setAliCloudOSSPolicy(String aliCloudOSSPolicy) {
        SharedPreferences sp = getDefaultSharedPreferences();
        sp.edit().putString(KEY_ALI_CLOUD_OSS_POLICY, aliCloudOSSPolicy).apply();
    }

    /**
     * 获取阿里云OSS Policy信息
     *
     * @return
     */
    public static com.nbc.smartcar.phonecenter.bean.AliCloudOSS.OSSPolicy getAliCloudOSSPolicy() {
        SharedPreferences sp = getDefaultSharedPreferences();
        String policy = sp.getString(KEY_ALI_CLOUD_OSS_POLICY, "");
        if (TextUtils.isEmpty(policy)) {
            return null;
        } else {
            return JsonUtil.parseObject(policy, com.nbc.smartcar.phonecenter.bean.AliCloudOSS.OSSPolicy.class);
        }
    }


}
