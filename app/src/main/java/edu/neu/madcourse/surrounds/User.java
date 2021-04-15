package edu.neu.madcourse.surrounds;

import android.location.Location;

import java.util.ArrayList;

public class User {
    private int userid;
    private String username;
    private String email;
    private String password;
    private ArrayList<String> subscribed_topics;
    private ArrayList<Post> posts;
    private ArrayList<Reply> replies;
    private Location location;

    public User(int userid, String username, String email, String password, ArrayList<String> subscribed_topics, ArrayList<Post> posts, ArrayList<Reply> replies, Location location) {
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.password = password;
        this.subscribed_topics = subscribed_topics;
        this.posts = posts;
        this.replies = replies;
        this.location = location;
    }

    public User(){}

    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getSubscribed_topics() {
        return subscribed_topics;
    }

    public void setSubscribed_topics(ArrayList<String> subscribed_topics) {
        this.subscribed_topics = subscribed_topics;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public ArrayList<Reply> getReplies() {
        return replies;
    }

    public void setReplies(ArrayList<Reply> replies) {
        this.replies = replies;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
