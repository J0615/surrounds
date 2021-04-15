package edu.neu.madcourse.surrounds;

import android.location.Location;

import java.util.ArrayList;
import java.util.Date;

public class Post {
    private int post_id;
    private int sent_by;
    private Location sent_location;
    private String content;
    private Date date;
    private ArrayList<Reply> replies;
    private int upvote;
    private ArrayList<String> tag;

    public Post(int post_id, int sent_by, Location sent_location, String content, Date date, ArrayList<Reply> replies, int upvote, ArrayList<String> tag) {
        this.post_id = post_id;
        this.sent_by = sent_by;
        this.sent_location = sent_location;
        this.content = content;
        this.date = date;
        this.replies = replies;
        this.upvote = upvote;
        this.tag = tag;
    }

    public Post(){}

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getSent_by() {
        return sent_by;
    }

    public void setSent_by(int sent_by) {
        this.sent_by = sent_by;
    }

    public Location getSent_location() {
        return sent_location;
    }

    public void setSent_location(Location sent_location) {
        this.sent_location = sent_location;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Reply> getReplies() {
        return replies;
    }

    public void setReplies(ArrayList<Reply> replies) {
        this.replies = replies;
    }

    public int getUpvote() {
        return upvote;
    }

    public void setUpvote(int upvote) {
        this.upvote = upvote;
    }

    public ArrayList<String> getTag() {
        return tag;
    }

    public void setTag(ArrayList<String> tag) {
        this.tag = tag;
    }
}
