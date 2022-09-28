package com.lww.springboot_vue_demo.response;

/**
 * 返回结果响应码
 *
 * @author lww
 */
public enum ResponseCode {
    // 成功
    SUCCESS(200),

    // 失败
    FAILURE(400),

    // 未认证（签名错误）
    UNAUTHORIZED(401),

    // 接口不存在
    NOT_FOUND(404),

    // 服务器内部错误
    INTERNAL_SERVER_ERROR(500);

    public int code;

    ResponseCode(int code) {
        this.code = code;
    }
}
