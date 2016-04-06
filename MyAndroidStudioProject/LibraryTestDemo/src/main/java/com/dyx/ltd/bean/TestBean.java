package com.dyx.ltd.bean;

/**
 * Created by Da on 2016/4/1.
 */
public class TestBean {

    /**
     * hasError : false
     * errorMessage : null
     * errorCode : 200
     * data : {"url":"http://192.168.7.81/download/v40006_test.apk","versionCode":40006,"versionMessage":"1、更新a；2、更新b；"}
     */

    private boolean hasError;
    private Object errorMessage;
    private int errorCode;
    /**
     * url : http://192.168.7.81/download/v40006_test.apk
     * versionCode : 40006
     * versionMessage : 1、更新a；2、更新b；
     */

    private DataBean data;

    public boolean isHasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    public Object getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(Object errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String url;
        private int versionCode;
        private String versionMessage;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getVersionCode() {
            return versionCode;
        }

        public void setVersionCode(int versionCode) {
            this.versionCode = versionCode;
        }

        public String getVersionMessage() {
            return versionMessage;
        }

        public void setVersionMessage(String versionMessage) {
            this.versionMessage = versionMessage;
        }
    }
}
