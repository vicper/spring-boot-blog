package com.shieory.blog.api;

import com.alibaba.fastjson.JSONObject;
import com.shieory.blog.model.User;
import com.shieory.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author shieory
 * @version $Id: UserApi.java, v 0.1 2019年01月21日 00:49 shieory Exp $
 */
@RestController
@RequestMapping("/api/user")
public class UserApi {
    private UserService userService;

    @Autowired
    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public Object add(@RequestBody User user) {
        if (userService.queryByName(user.getName()) != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("message", "用户已经被使用");
            return jsonObject;
        }
        return userService.add(user);

    }

}
