package com.gjg.learn.yixin.entity;

/**
 * Created by Junguang_gao on 2016/6/14.
 */
public class FunctionTabEntity {
    private int tab_image;
    private String tab_function_desc;

    public FunctionTabEntity(int tab_image, String tab_function_desc) {
        this.tab_image = tab_image;
        this.tab_function_desc = tab_function_desc;
    }

    public int getTab_image() {
        return tab_image;
    }

    public void setTab_image(int tab_image) {
        this.tab_image = tab_image;
    }

    public String getTab_function_desc() {
        return tab_function_desc;
    }

    public void setTab_function_desc(String tab_function_desc) {
        this.tab_function_desc = tab_function_desc;
    }
}
