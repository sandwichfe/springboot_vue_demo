package com.lww.springboot_vue_demo.config;

/**
 * @description: 全局异常处理统一返回
 * @author lww
 * @since 2022/9/28 16:09
 */

import com.lww.springboot_vue_demo.response.ResponseResult;
import com.lww.springboot_vue_demo.response.ResultUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

    /**
     *
     * @author lww
     * @since 2022/9/28 16:10
     * @param e
     * @return
     */
    @ExceptionHandler({Exception.class})
    public ResponseResult ExceptionDemo(Exception e) {
        logger.error(e.getMessage(), e);
        return ResultUtil.error(e.getMessage());
    }

}


