package com.dyx.cpd.listener;

import com.dyx.cpd.entity.MyCustomObjectEntity;

/**
 * project name：CodePathDemo
 * class describe：
 * create person：dayongxin
 * create time：16/6/6 下午11:54
 * alter person：dayongxin
 * alter time：16/6/6 下午11:54
 * alter remark：
 */
public class MyCustomObject {
    public MyCustomObject() {
        this.listener = null;
        asynLoadData();
    }

    private void asynLoadData() {
        MyCustomObjectEntity entity = new MyCustomObjectEntity();
        if (entity != null) {
            if (listener != null) {
                listener.stepOne(entity.getStuName());
                listener.stepTwo(entity.getStuAddress());
                listener.stepThree(entity.getStuAge() + "");
            }
        }
    }

    public interface MyCustomObjectListener {
        /**
         * 步骤一
         *
         * @param titleOne
         */
        public void stepOne(String titleOne);

        /**
         * 步骤二
         *
         * @param titleTwo
         */
        public void stepTwo(String titleTwo);

        /**
         * 步骤三
         *
         * @param titleThree
         */
        public void stepThree(String titleThree);

    }

    private MyCustomObjectListener listener;

    public void setCustomObjectListener(MyCustomObjectListener listener) {
        this.listener = listener;
    }
}
