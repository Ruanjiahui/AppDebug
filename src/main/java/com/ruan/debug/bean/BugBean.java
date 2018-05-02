package com.ruan.debug.bean;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

/**
 * Created by 19820 on 2018/4/30.
 */
@Setter
@Getter
@Service
public class BugBean {

    private int debugID;

    private String debugSource = "";

    private String debugBround = "";

    private String debugModel = "";

    private String debugTime = "";

    private String debugOS = "";

    private String debugOSVersion = "";

    private double debugLon;

    private double debugLat;

    /**
     * app包名
     */
    private String appPackage = "";
    /**
     * app版本名称
     */
    private String appVersionName = "";

    /**
     * app版本号
     */
    private int appVersionCode;
    /**
     * app安装日期
     */
    private String appInstallDate = "";
    /**
     * app 更新日期
     */
    private String appInstallUpdateDate = "";

    /**
     * 安装类型
     */
    private String phoneType = "";

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
