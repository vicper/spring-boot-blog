package com.shieory.blog.service.impl;

import com.shieory.blog.mapper.UserMapper;
import com.shieory.blog.model.User;
import com.shieory.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author shieory
 * @version $Id: UserServiceImpl.java, v 0.1 2019年01月21日 00:52 shieory Exp $
 */
@Service
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User add(User user) {
        String passwordHash = passwordToHash(user.getPassword());
        user.setPassword(passwordHash);
        userMapper.add(user);
        return queryById(user.getId());
    }

    @Override
    public User queryById(Integer id) {
        User user = new User();
        user.setId(id);
        return userMapper.queryOne(user);
    }

    @Override
    public User queryByName(String name) {
        User user = new User();
        user.setName(name);
        return userMapper.queryOne(user);
    }

    private String passwordToHash(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(password.getBytes());
            byte[] src = digest.digest();
            StringBuilder stringBuilder = new StringBuilder();
            // 字节数组转16进制字符串
            for (byte aSrc : src) {
                String s = Integer.toHexString(aSrc & 0xFF);
                if (s.length() < 2) {
                    stringBuilder.append('0');
                }
                stringBuilder.append(s);
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException ignore) {

        }
        return null;
    }
}
