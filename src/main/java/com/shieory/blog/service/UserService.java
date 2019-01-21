package com.shieory.blog.service;

import com.shieory.blog.model.User;

/**
 * @author shieory
 * @version $Id: UserService.java, v 0.1 2019年01月21日 00:51 shieory Exp $
 */
public interface UserService {

    User add(User user);

    User queryById(Integer id);

    User queryByName(String name);

    Boolean comparePassword(User user, User userInDataBase);
}
