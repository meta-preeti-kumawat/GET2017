package entity;

import record.UserPosts;

public interface Entity {
    
    public abstract String getId();
    public abstract String getName();
    public abstract void setId(String id);
    public abstract void setName(String name);
    public abstract String getStatus();
    public abstract UserPosts getPost();
    public abstract void setStatus(String name);
    public abstract void setPost(UserPosts post);
    public abstract Entity splitData(String fileData);
}
