package com.shieory.blog.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * @author shieory
 * @version $Id: FastJsonHttpMessageConverterEx.java, v 0.1 2019年01月24日 22:23 shieory Exp $
 */
public class FastJsonHttpMessageConverterEx extends FastJsonHttpMessageConverter {
    public FastJsonHttpMessageConverterEx() {
        // 在这里配置 fastjson 特性
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        this.setFastJsonConfig(fastJsonConfig);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return super.supports(clazz);
    }
}
