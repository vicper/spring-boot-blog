package com.shieory.blog.config;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shieory
 * @version $Id: GlobalExceptionHandler.java, v 0.1 2019年01月22日 22:59 shieory Exp $
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        // 记录错误信息
        logger.error(ExceptionUtils.getFullStackTrace(e));
        String msg = e.getMessage();
        if (StringUtils.isEmpty(msg)) {
            msg = "server error";
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", msg);
        return jsonObject;
    }

}
