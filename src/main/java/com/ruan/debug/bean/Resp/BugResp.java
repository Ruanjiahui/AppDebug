package com.ruan.debug.bean.Resp;

import com.google.gson.Gson;
import com.ruan.debug.bean.BugBean;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by 19820 on 2018/4/30.
 */
@Setter
@Getter
public class BugResp extends RespBase {

    private BugBean data;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
