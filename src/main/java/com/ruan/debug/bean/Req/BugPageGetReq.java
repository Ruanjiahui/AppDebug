package com.ruan.debug.bean.Req;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by 19820 on 2018/4/30.
 */
@Setter
@Getter
public class BugPageGetReq extends ReqBase {

    /**
     * 当前页数
     */
    private int page;

    /**
     * 当前页数数量
     * 默认 20
     */
    private int pagecount = 20;

    /**
     * 开始获取的标识
     */
    private int startFlag;


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
