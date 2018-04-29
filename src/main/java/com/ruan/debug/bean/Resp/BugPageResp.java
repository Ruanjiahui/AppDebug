package com.ruan.debug.bean.Resp;

import com.google.gson.Gson;
import com.ruan.debug.bean.BugBean;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * Created by 19820 on 2018/4/30.
 */
@Getter
@Setter
public class BugPageResp extends RespBase {

    private ArrayList<BugBean> list;

    /**
     * 当前页数
     */
    private int page;

    /**
     * 当前页数 数量
     */
    private int pagecount;

    /**
     * 总页数
     */
    private int pagetotal;

    /**
     * 总数量
     */
    private long count;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
