package entity;

import record.UserPosts;

public class Organization implements Entity{
    private String orgId;
    private String orgName;
    private String establishmentYear;
    private String status;
    private UserPosts post;
    
    @Override
    public String getId() {
        return orgId;
    }
    public String getEstablishmentYear() {
        return establishmentYear;
    }
    public void setEstablishmentYear(String establishmentYear) {
        this.establishmentYear = establishmentYear;
    }
    @Override
    public String getName() {
        return orgName;
    }
    @Override
    public void setId(String id) {
        this.orgId = id;
    }
    @Override
    public void setName(String name) {
        this.orgName = name;
    }
    @Override
    public String getStatus() {
        return status;
    }
    @Override
    public UserPosts getPost() {
        return post;
    }
    @Override
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public void setPost(UserPosts post) {
        this.post = post;
    }
    @Override
    public Entity splitData(String fileData) {
        Organization org = new Organization();
        if(fileData.contains(",")){
            String[] entityData = fileData.split(",");
            if(entityData.length == 4){
                org.setId(entityData[0]);
                org.setName(entityData[1]);
                org.setEstablishmentYear(entityData[2]);
                org.setStatus(entityData[3]);
            }
        }
        return org;
    }

}
