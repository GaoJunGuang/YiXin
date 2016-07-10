package com.gjg.learn.yixin.entity;

/**
 * Created by Junguang_Gao on 2016/7/6.
 */
public class FoundEntity {
    private int found_image;
    private String found_title;
    private String found_desc;
    private String found_other;
    private String found_item_type;//0--item3 1--item1  2--itme2

    public FoundEntity(int found_image, String found_title, String found_desc, String found_other,String found_item_type) {
        this.found_image = found_image;
        this.found_title = found_title;
        this.found_desc = found_desc;
        this.found_other = found_other;
        this.found_item_type=found_item_type;
    }

    public int getFound_image() {
        return found_image;
    }

    public void setFound_image(int found_image) {
        this.found_image = found_image;
    }

    public String getFound_title() {
        return found_title;
    }

    public void setFound_title(String found_title) {
        this.found_title = found_title;
    }

    public String getFound_desc() {
        return found_desc;
    }

    public void setFound_desc(String found_desc) {
        this.found_desc = found_desc;
    }

    public String getFound_other() {
        return found_other;
    }

    public void setFound_other(String found_other) {
        this.found_other = found_other;
    }

    public String getFound_item_type() {
        return found_item_type;
    }

    public void setFound_item_type(String found_item_type) {
        this.found_item_type = found_item_type;
    }
}
