package com.shieory.blog.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.shieory.blog.model.User;
import com.shieory.blog.service.AuthenticationService;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

/**
 * @author shieory
 * @version $Id: AuthenticationServiceImpl.java, v 0.1 2019年01月21日 23:41 shieory Exp $
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public String getToken(User user) {
        String token = "";
        try {
            token = JWT.create()
                    .withAudience(user.getId().toString())
                    .sign(Algorithm.HMAC256(user.getPassword()));
        } catch (UnsupportedEncodingException ignore) {

        }
        return token;
    }
}
