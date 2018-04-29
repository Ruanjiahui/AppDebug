package com.ruan.debug.Utils;

/**
 * 响应码
 * Created by 19820 on 2018/4/30.
 */
public class RespCode {

    /**
     * 成功
     */
    public static final int success = 200000;

    public static final String success_msg = "success";

    /**
     * 失败
     */
    public static final int fail = 400000;

    public static final String fail_msg = "fail";

    /**
     * 非法参数
     */
    public static final int illegal_parameter = 401000;

    public static final String illegal_parameter_msg = "illegal parameter";

    /**
     * 空值
     */
    public static final int empty = 404000;

    public static final String empty_msg = "empty";

    /**
     * 服务器异常
     */
    public static final int server_error = 500000;

    public static final String server_error_msg = "server error";


}
