package com.gjg.learn.yixin.entity;

/**
 * Created by Junguang_gao on 2016/6/14.
 */
public class FriendEntity {
    private int friend_image;
    private String friend_name;
    private String pingyin_friend_name;

    public FriendEntity(String friend_name) {
        this.friend_name = friend_name;
    }

    public FriendEntity(int friend_image, String friend_name) {
        this.friend_image = friend_image;
        this.friend_name = friend_name;
    }

    public FriendEntity(String friend_name, String pingyin_friend_name){
        this.friend_name=friend_name;
        this.pingyin_friend_name=pingyin_friend_name;
    }

    public int getFriend_image() {
        return friend_image;
    }

    public void setFriend_image(int friend_image) {
        this.friend_image = friend_image;
    }

    public String getFriend_name() {
        return friend_name;
    }

    public void setFriend_name(String friend_name) {
        this.friend_name = friend_name;
    }

    public String getPingyin_friend_name() {
        return pingyin_friend_name;
    }

    public void setPingyin_friend_name(String pingyin_friend_name) {
        this.pingyin_friend_name = pingyin_friend_name;
    }
}
