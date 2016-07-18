package com.dyx.hlirp.model;

import java.util.List;

/**
 * project name：Heterogenous-Layouts-inside-RecyclerView-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/18 下午9:37
 * alter person：dayongxin
 * alter time：16/7/18 下午9:37
 * alter remark：
 */
public class DataModel {

    /**
     * isError : false
     * data : [{"templateType":1,"imgUrl":"http://f1.topitme.com/1/6f/78/11390685454e6786f1l.jpg"},{"templateType":2,"itemTitle":"标题一","imgUrl":"http://f5.topitme.com/5/55/da/1131896597d5bda555l.jpg"},{"templateType":3,"itemTitle":"标题二","itemDescription":"标题二描述","marketPrice":48.99,"myPrice":24.99,"imgUrl":"http://f5.topitme.com/5/27/50/1117376132e6d50275l.jpg"},{"templateType":4,"datas":[{"imgUrl":"http://f6.topitme.com/6/88/72/1155051039a3272886l.jpg","itemTitle":"列表标题1"},{"imgUrl":"http://i10.topitme.com/l018/10018123602647efad.jpg","itemTitle":"列表标题2"},{"imgUrl":"http://f10.topitme.com/l/201101/11/12946817263134.jpg","itemTitle":"列表标题3"},{"imgUrl":"http://f10.topitme.com/l/201101/11/12946817263134.jpg","itemTitle":"列表标题3"},{"imgUrl":"http://f6.topitme.com/6/88/72/1155051039a3272886l.jpg","itemTitle":"列表标题1"},{"imgUrl":"http://i10.topitme.com/l018/10018123602647efad.jpg","itemTitle":"列表标题2"}]},{"templateType":2,"itemTitle":"标题一","imgUrl":"http://f5.topitme.com/5/55/da/1131896597d5bda555l.jpg"},{"templateType":3,"itemTitle":"标题二","itemDescription":"标题二描述","marketPrice":48.99,"myPrice":24.99,"imgUrl":"http://f5.topitme.com/5/27/50/1117376132e6d50275l.jpg"},{"templateType":1,"imgUrl":"http://f1.topitme.com/1/6f/78/11390685454e6786f1l.jpg"},{"templateType":4,"datas":[{"imgUrl":"http://f6.topitme.com/6/88/72/1155051039a3272886l.jpg","itemTitle":"列表标题1"},{"imgUrl":"http://i10.topitme.com/l018/10018123602647efad.jpg","itemTitle":"列表标题2"},{"imgUrl":"http://f10.topitme.com/l/201101/11/12946817263134.jpg","itemTitle":"列表标题3"},{"imgUrl":"http://f10.topitme.com/l/201101/11/12946817263134.jpg","itemTitle":"列表标题3"},{"imgUrl":"http://f6.topitme.com/6/88/72/1155051039a3272886l.jpg","itemTitle":"列表标题1"},{"imgUrl":"http://i10.topitme.com/l018/10018123602647efad.jpg","itemTitle":"列表标题2"}]}]
     */

    private boolean isError;
    /**
     * templateType : 1
     * imgUrl : http://f1.topitme.com/1/6f/78/11390685454e6786f1l.jpg
     */

    private List<DataEntity> data;

    public boolean isIsError() {
        return isError;
    }

    public void setIsError(boolean isError) {
        this.isError = isError;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public static class DataEntity {
        private int templateType;
        private String imgUrl;

        public int getTemplateType() {
            return templateType;
        }

        public void setTemplateType(int templateType) {
            this.templateType = templateType;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }
    }
}
