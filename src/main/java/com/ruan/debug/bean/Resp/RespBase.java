package com.ruan.debug.bean.Resp;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

/**
 * Created by 19820 on 2018/4/30.
 */
@Getter
@Setter
@Service
public class RespBase {

    private String msg;

    private int code;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
