package com.gjg.learn.yixin.entity;

/**
 * Created by Junguang_Gao on 2016/7/7.
 */
public class MeEntity {
    private int image;
    private String title;
    private int isHaveNewMessage;//0--没有  1--有

    public MeEntity(int image, String title,int isHaveNewMessage) {
        this.image = image;
        this.title = title;
        this.isHaveNewMessage=isHaveNewMessage;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIsHaveNewMessage() {
        return isHaveNewMessage;
    }

    public void setIsHaveNewMessage(int isHaveNewMessage) {
        this.isHaveNewMessage = isHaveNewMessage;
    }
}
