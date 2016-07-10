package com.gjg.learn.yixin.entity;

/**
 * Created by Junguang_gao on 2016/6/13.
 */
public class SmsEntity {
    private int image_resource_id;
    private String sms_title;
    private String sms_content;
    private String sms_receive_time;
    private String sms_not_read;

    public SmsEntity(int image,String title,String time){
        this.image_resource_id=image;
        this.sms_title=title;
        this.sms_receive_time=time;

    }

    public SmsEntity(int image_resource_id, String sms_title, String sms_content, String sms_receive_time, String sms_not_read) {
        this.image_resource_id = image_resource_id;
        this.sms_title = sms_title;
        this.sms_content = sms_content;
        this.sms_receive_time = sms_receive_time;
        this.sms_not_read = sms_not_read;
    }

    public int getImage_resource_id() {
        return image_resource_id;
    }

    public void setImage_resource_id(int image_resource_id) {
        this.image_resource_id = image_resource_id;
    }

    public String getSms_title() {
        return sms_title;
    }

    public void setSms_title(String sms_title) {
        this.sms_title = sms_title;
    }

    public String getSms_content() {
        return sms_content;
    }

    public void setSms_content(String sms_content) {
        this.sms_content = sms_content;
    }

    public String getSms_receive_time() {
        return sms_receive_time;
    }

    public void setSms_receive_time(String sms_receive_time) {
        this.sms_receive_time = sms_receive_time;
    }

    public String getSms_not_read() {
        return sms_not_read;
    }

    public void setSms_not_read(String sms_not_read) {
        this.sms_not_read = sms_not_read;
    }
}
