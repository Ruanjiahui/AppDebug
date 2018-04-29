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

    private String debugSource;

    private String debugBround;

    private String debugModel;

    private String debugTime;

    private String debugOS;

    private String debugOSVersion;

    private double debugLon;

    private double debugLat;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
