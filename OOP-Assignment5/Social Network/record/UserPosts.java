package record;

import java.util.HashMap;
import java.util.Map;

public class UserPosts {
    private Map<String, Post> userPost = new HashMap<String, Post>();

    public Map<String, Post> getUserPost() {
        return userPost;
    }

    public void setUserPost(Map<String, Post> userPost) {
        this.userPost = userPost;
    }
}
