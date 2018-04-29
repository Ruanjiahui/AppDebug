package com.ruan.debug.Controller;

import com.ruan.debug.bean.Resp.RespBase;
import com.ruan.debug.bean.Resp.RespObjectBase;
import org.springframework.beans.factory.annotation.Autowired;

import static com.ruan.debug.Utils.RespCode.*;

/**
 * Created by 19820 on 2018/4/30.
 */
public class BasePresenter {

    @Autowired
    private RespBase respBase;

    @Autowired
    private RespObjectBase respObjectBase;

    /**
     * 服务器异常 返回码
     * @return
     */
    protected String server_error(){
        respBase.setCode(server_error);
        respBase.setMsg(server_error_msg);
        return respBase.toString();
    }

    /**
     * 响应成功 返回码
     * @return
     */
    protected String success(){
        respBase.setCode(success);
        respBase.setMsg(success_msg);
        return respBase.toString();
    }

    /**
     * 响应失败 返回码
     * @return
     */
    protected String fail(){
        respBase.setCode(fail);
        respBase.setMsg(fail_msg);
        return respBase.toString();
    }

    /**
     * 空值
     * @return
     */
    protected String empty(){
        respBase.setCode(empty);
        respBase.setMsg(empty_msg);
        return respBase.toString();
    }

    /**
     * 非法参数
     * @return
     */
    protected String illegal_parameter(){
        respBase.setCode(illegal_parameter);
        respBase.setMsg(illegal_parameter_msg);
        return respBase.toString();
    }


    /**
     * 返回对象同一方式
     * @return
     */
    protected String setBeanResp(Object object){
        respObjectBase.setData(object);
        respObjectBase.setCode(success);
        respObjectBase.setMsg(success_msg);
        return respObjectBase.toString();
    }

}
