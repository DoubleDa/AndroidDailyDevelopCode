package com.dyx.lcd.ui;

import android.app.Activity;
import android.os.Bundle;

import com.dyx.lcd.R;

/**
 * project name：LeakCanaryDemo
 * class describe：
 * create person：dayongxin
 * create time：2016/11/1 上午11:55
 * alter person：dayongxin
 * alter time：2016/11/1 上午11:55
 * alter remark：
 */
public class NotStaticAct extends Activity{
    private static Person mPerson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_static);
        initData();
    }

    private void initData() {
        if(mPerson==null){
            mPerson=new Person();
            mPerson.setAge(18);
            mPerson.setName("哒哒");
            mPerson.setNum(1);
        }
    }

    static class Person{
        private int num;
        private String name;
        private int age;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
