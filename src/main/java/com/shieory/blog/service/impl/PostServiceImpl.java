package com.shieory.blog.service.impl;

import com.shieory.blog.mapper.PostMapper;
import com.shieory.blog.model.Post;
import com.shieory.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author shieory
 * @version $Id: PostServiceImpl.java, v 0.1 2019年01月24日 00:30 shieory Exp $
 */
@Service
public class PostServiceImpl implements PostService {

    private PostMapper postMapper;

    @Autowired
    public PostServiceImpl(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Transactional
    @Override
    public Post add(Post post) {
        postMapper.add(post);
        return queryById(post.getId());
    }

    @Override
    public Post queryById(Integer id) {
        Post param = new Post();
        param.setId(id);
        return postMapper.queryOne(param);
    }
}
