package record;

import java.util.ArrayList;

public class Post {
    private ArrayList<String> listOfPosts = new ArrayList<String>();

    public ArrayList<String> getListOfPosts() {
        return listOfPosts;
    }

    public void setListOfPosts(ArrayList<String> listOfPosts) {
        this.listOfPosts = listOfPosts;
    }
}
