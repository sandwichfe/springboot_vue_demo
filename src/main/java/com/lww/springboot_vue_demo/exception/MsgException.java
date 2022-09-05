package com.lww.springboot_vue_demo.exception;

import lombok.Data;

/**
 * @description: 异常提醒消息类
 * @author lww
 * @since 2022/9/5 15:20
 */
@Data
public class MsgException extends RuntimeException {

    private String errorMsg;

    public MsgException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

}
