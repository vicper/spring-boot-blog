package com.shieory.blog.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author shieory
 * @version $Id: Post.java, v 0.1 2019年01月24日 00:01 shieory Exp $
 */
public class Post implements Serializable {

    private static final long serialVersionUID = 7674146525143817703L;

    private Integer id;

    private User author;

    private Integer authorId;

    private String title;

    private String content;

    private Date createTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", author=" + author +
                ", authorId=" + authorId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
