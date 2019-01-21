package com.shieory.blog.api;

import com.alibaba.fastjson.JSONObject;
import com.shieory.blog.model.User;
import com.shieory.blog.service.AuthenticationService;
import com.shieory.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shieory
 * @version $Id: AuthenticationApi.java, v 0.1 2019年01月21日 23:39 shieory Exp $
 */
@RestController
@RequestMapping("/api/authentication")
public class AuthenticationApi {

    private AuthenticationService authenticationService;

    private UserService userService;

    @Autowired
    public AuthenticationApi(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping("")
    public Object login(@RequestBody User user) {
        User userInDataBase = userService.queryByName(user.getName());
        JSONObject jsonObject = new JSONObject();
        if (userInDataBase == null) {
            jsonObject.put("message", "用户不存在");
        } else if (!userService.comparePassword(user, userInDataBase)) {
            jsonObject.put("message", "密码不正确");
        } else {
            String token = authenticationService.getToken(userInDataBase);
            jsonObject.put("token", token);
            jsonObject.put("user", userInDataBase);
        }
        return jsonObject;
    }

}
