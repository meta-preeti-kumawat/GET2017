package entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import record.UserPosts;

public class User implements Entity{
    private String userId;
    private String userName;
    private Date dateOfBirth;
    private String gender;
    private String status;
    private UserPosts post;
    
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getId() {
        return this.userId;
    }

    @Override
    public String getName() {
        return this.userName;
    }

    @Override
    public void setId(String id) {
        this.userId = id;
    }

    @Override
    public void setName(String name) {
        this.userName = name;
    }

    @Override
    public UserPosts getPost() {
        return this.post;
    }

    @Override
    public void setPost(UserPosts post) {
        this.post = post;
    }

    @Override
    public Entity splitData(String fileData) {
        User user = new User();
        if(fileData.contains(",")){
            String[] entityData = fileData.split(",");
            if(entityData.length == 5){
                user.setId(entityData[0]);
                user.setName(entityData[1]);
                DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
                Date date;
                try {
                    date = format.parse(entityData[2]);
                    user.setDateOfBirth(date);
                    
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                user.setGender(entityData[3]);
                user.setStatus(entityData[4]);
            }
        }
        return user;
    }
}
