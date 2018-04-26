package com.ruan.debug.bean.Req;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BugCommitReq extends BaseReq {

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


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
