package com.shieory.blog.service;

import com.shieory.blog.model.User;

/**
 * @author shieory
 * @version $Id: AuthenticationService.java, v 0.1 2019年01月21日 23:41 shieory Exp $
 */
public interface AuthenticationService {
    String getToken(User user);
}
