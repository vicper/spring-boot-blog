package com.shieory.blog.mapper;

import com.shieory.blog.model.User;

/**
 * @author shieory
 * @version $Id: UserMapper.java, v 0.1 2019年01月21日 01:11 shieory Exp $
 */
public interface UserMapper {

    Integer add(User user);

    User queryOne(User user);
}
