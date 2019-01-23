package com.shieory.blog.mapper;

import com.shieory.blog.model.Post;

/**
 * @author shieory
 * @version $Id: PostMapper.java, v 0.1 2019年01月24日 00:04 shieory Exp $
 */
public interface PostMapper {
    Integer add(Post post);

    Post queryOne(Post post);
}
