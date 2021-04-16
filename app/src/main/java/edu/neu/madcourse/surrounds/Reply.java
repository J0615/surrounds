package edu.neu.madcourse.surrounds;

public class Reply {
    private int reply_id;
    private int sent_by;
    private String content;
    private int post_id;
    private int upvote;

    public Reply(int reply_id, int sent_by, String content, int post_id, int upvote) {
        this.reply_id = reply_id;
        this.sent_by = sent_by;
        this.content = content;
        this.post_id = post_id;
        this.upvote = upvote;
    }
    public Reply(){}

    public int getReply_id() {
        return reply_id;
    }

    public void setReply_id(int reply_id) {
        this.reply_id = reply_id;
    }

    public int getSent_by() {
        return sent_by;
    }

    public void setSent_by(int sent_by) {
        this.sent_by = sent_by;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getUpvote() {
        return upvote;
    }

    public void setUpvote(int upvote) {
        this.upvote = upvote;
    }
}
