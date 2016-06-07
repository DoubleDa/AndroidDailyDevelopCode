package com.dyx.cpd.entity;

/**
 * project name：CodePathDemo
 * class describe：
 * create person：dayongxin
 * create time：16/6/7 上午12:05
 * alter person：dayongxin
 * alter time：16/6/7 上午12:05
 * alter remark：
 */
public class MyCustomObjectEntity {
    private String stuName;
    private Integer stuAge;
    private String stuAddress;

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuAddress() {
        return stuAddress;
    }

    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress;
    }
}
