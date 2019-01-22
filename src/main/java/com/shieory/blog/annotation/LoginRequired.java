package com.shieory.blog.annotation;

/**
 * @author shieory
 * @version $Id: LoginRequired.java, v 0.1 2019年01月22日 23:21 shieory Exp $
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在需要登录验证的controller的方法上使用此注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginRequired {
}

// ElementType.METHOD 表示该自定义注解可以用在方法上
// 表示该注解在代码运行时起作用