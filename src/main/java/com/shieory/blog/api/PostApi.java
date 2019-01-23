package com.shieory.blog.api;

import com.alibaba.fastjson.JSONObject;
import com.shieory.blog.annotation.CurrentUser;
import com.shieory.blog.annotation.LoginRequired;
import com.shieory.blog.model.Post;
import com.shieory.blog.model.User;
import com.shieory.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author shieory
 * @version $Id: PostApi.java, v 0.1 2019年01月24日 00:00 shieory Exp $
 */
@RestController
@RequestMapping("/api/post")
public class PostApi {
    private PostService postService;

    @Autowired
    public PostApi(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("")
    @LoginRequired
    public Post add(@RequestBody Post post, @CurrentUser User user) {
        post.setAuthorId(user.getId());
        post = postService.add(post);
        return post;
    }

    @GetMapping("/{id}")
    public Object queryById(@PathVariable Integer id) {
        Post post = postService.queryById(id);
        if (post == null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("message", "文章不存在");
            return jsonObject;
        } else {
            return post;
        }
    }
}
