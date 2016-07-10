package com.gjg.learn.yixin;

/**
 * Created by Junguang_Gao on 2016/6/8.
 */
public class MenuEntity {
    private int imageId;//图片
    private int functionId;//功能

    public MenuEntity(int imageId, int functionId) {
        this.imageId = imageId;
        this.functionId = functionId;
    }

    public int getFunctionId() {
        return functionId;
    }

    public void setFunctionId(int functionId) {
        this.functionId = functionId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
