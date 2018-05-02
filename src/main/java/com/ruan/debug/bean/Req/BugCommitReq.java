package com.ruan.debug.bean.Req;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BugCommitReq extends ReqBase {

    /**
     * 手机品牌
     */
    private String bround;

    /**
     * 手机型号
     */
    private String model;

    /**
     * 错误日志
     */
    private String bugData;

    /**
     * 手机系统
     */
    private String debugOS;

    /**
     * 手机系统版本
     */
    private String debugOSVersion;

    /**
     * 经度
     */
    private double debugLon;

    /**
     * 纬度
     */
    private double debugLat;

    /**
     * app包名
     */
    private String appPackage;
    /**
     * app版本名称
     */
    private String appVersionName;

    /**
     * app版本号
     */
    private int appVersionCode;
    /**
     * app安装日期
     */
    private String appInstallDate;
    /**
     * app 更新日期
     */
    private String appInstallUpdateDate;

    /**
     * 安装类型
     */
    private String phoneType;


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
