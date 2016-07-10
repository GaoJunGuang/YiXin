package com.gjg.learn.yixin.entity;

/**
 * Created by Junguang_Gao on 2016/6/20.
 */
public class ContactsEntity {
    private int isPlayInto;
    private String name;
    private String phoneNumber;
    private String time;

    public ContactsEntity() {

    }
    public ContactsEntity(int isPlayInto, String name, String phoneNumber, String time) {
        this.isPlayInto = isPlayInto;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.time = time;
    }

    public int getIsPlayInto() {
        return isPlayInto;
    }

    public void setIsPlayInto(int isPlayInto) {
        this.isPlayInto = isPlayInto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
