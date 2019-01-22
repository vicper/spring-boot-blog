package com.shieory.blog.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.shieory.blog.annotation.LoginRequired;
import com.shieory.blog.model.User;
import com.shieory.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

/**
 * @author shieory
 * @version $Id: AuthenticationInterceptor.java, v 0.1 2019年01月22日 23:25 shieory Exp $
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        // 判断接口是否需要登录
        LoginRequired methodAnnotation = method.getAnnotation(LoginRequired.class);
        // 有 @LoginRequired 注解， 需要认证
        if (methodAnnotation != null) {
            // 执行认证
            // 从 http 请求中取出token
            String token = request.getHeader("token");
            if (token == null) {
                throw new RuntimeException("无token，请重新登录");
            }
            int userId;
            try {
                userId = Integer.parseInt(JWT.decode(token).getAudience().get(0));
            } catch (JWTDecodeException e) {
                throw new RuntimeException("token无效， 请重新登录");
            }
            User user = userService.queryById(userId);
            if (user == null) {
                throw new RuntimeException("用户不存在， 请重新登录");
            }

            // 验证 token
            try {
                JWTVerifier verifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
                try {
                    verifier.verify(token);
                } catch (JWTVerificationException e) {
                    throw new RuntimeException("token无效，请重新登录");
                }
            } catch (UnsupportedEncodingException ignore) {

            }
            request.setAttribute("currentUser", user);
        }
        return true;
    }
}
