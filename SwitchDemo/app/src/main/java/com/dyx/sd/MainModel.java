package com.dyx.sd;

/**
 * project name：SwitchDemo
 * class describe：
 * create person：dayongxin
 * create time：2016/12/26 下午4:34
 * alter person：dayongxin
 * alter time：2016/12/26 下午4:34
 * alter remark：
 */
public class MainModel {
    private String name;
    private int tag;
    private boolean isSelect = false;

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }

    public MainModel(String name, int tag) {
        this.name = name;
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }
}
