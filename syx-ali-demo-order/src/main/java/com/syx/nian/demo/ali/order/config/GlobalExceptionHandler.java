package com.syx.nian.demo.ali.order.config;

import com.syx.nian.demo.ali.core.util.BusinessException;
import com.syx.nian.demo.ali.core.util.R;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice(basePackages = {"com.syx.nian.demo.ali"})
public class GlobalExceptionHandler {
    private static Logger log = LogManager.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R exceptionHandler(Exception e){
        log.error("【系统抛出Exception异常】 —— 异常内容如下：{}" , e);

        return R.ERROR();
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public R defaultException(BusinessException e){
        log.error("【系统抛出SinochemException异常】 —— 异常内容如下：{}" , e);
        return R.ERROR();
    }
}
