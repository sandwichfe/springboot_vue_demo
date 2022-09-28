package com.lww.springboot_vue_demo.response;

/**
 * @author lww
 * @description 返回结果工具类
 * @date 2022/3/11 16:33
 */
public class ResultUtil {

    private final static String SUCCESS = "success";

    public static <T> ResponseResult<T> success() {
        return new ResponseResult<T>().setCode(ResponseCode.SUCCESS).setMsg(SUCCESS);
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<T>().setCode(ResponseCode.SUCCESS).setMsg(SUCCESS).setData(data);
    }

    public static <T> ResponseResult<T> error(String message) {
        return new ResponseResult<T>().setCode(ResponseCode.FAILURE).setMsg(message);
    }

    public static <T> ResponseResult<T> response(ResponseCode code, String msg) {
        return new ResponseResult<T>().setCode(code).setMsg(msg);
    }

    public static <T> ResponseResult<T> response(ResponseCode code, String msg, T data) {
        return new ResponseResult<T>().setCode(code).setMsg(msg).setData(data);
    }
}
