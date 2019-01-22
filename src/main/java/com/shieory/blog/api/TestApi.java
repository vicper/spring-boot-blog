package com.shieory.blog.api;

import com.shieory.blog.annotation.LoginRequired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shieory
 * @version $Id: TestApi.java, v 0.1 2019年01月23日 00:07 shieory Exp $
 */

@RestController
@RequestMapping("/api/test")
public class TestApi {
    @GetMapping("/zero")
    public int testError(){
        return 9 / 0;
    }

    @LoginRequired
    @GetMapping("/login")
    public Object testLogin() {
        return "success";
    }
}
