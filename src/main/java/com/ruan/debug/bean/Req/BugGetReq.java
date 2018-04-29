package com.ruan.debug.bean.Req;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by 19820 on 2018/4/30.
 */

@Getter
@Setter
public class BugGetReq extends ReqBase {

    /**
     * debug id
     */
    private int debugID;


    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
