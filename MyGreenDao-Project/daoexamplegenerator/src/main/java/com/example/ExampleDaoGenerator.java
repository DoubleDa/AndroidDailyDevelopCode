package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class ExampleDaoGenerator {
    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "com.dyx.mgdp.greendao");
        addBlog(schema);
        new DaoGenerator().generateAll(schema, "G:/Android_Studio_Project/MyGreenDao-Project/app/src/main/java-gen");
    }

    private static void addBlog(Schema schema) {
        //1、创建表
        Entity blog = schema.addEntity("Blog");

        //2、设置表中字段名称
        blog.addIdProperty();
        blog.addStringProperty("author").notNull();
        blog.addStringProperty("tab").notNull();
        blog.addStringProperty("comment").notNull();
        blog.addDateProperty("date");
    }
}
