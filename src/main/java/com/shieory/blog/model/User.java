package com.shieory.blog.model;

import java.io.Serializable;

/**
 * @author shieory
 * @version $Id: User.java, v 0.1 2019年01月21日 00:46 shieory Exp $
 */
public class User implements Serializable {

    private static final long serialVersionUID = -5691436941378209552L;

    private Integer id;

    private String name;

    private String password;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
