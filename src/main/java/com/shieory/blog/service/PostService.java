package com.shieory.blog.service;

import com.shieory.blog.model.Post;

/**
 * @author shieory
 * @version $Id: PostService.java, v 0.1 2019年01月24日 00:29 shieory Exp $
 */
public interface PostService {
    Post add(Post post);

    Post queryById(Integer id);
}
