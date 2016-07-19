package com.dyx.hlirp.model;

/**
 * project name：Heterogenous-Layouts-inside-RecyclerView-Project
 * class describe：
 * create person：dayongxin
 * create time：16/7/19 上午11:49
 * alter person：dayongxin
 * alter time：16/7/19 上午11:49
 * alter remark：
 */
public class Template3 {
    private String imgUrl;
    private String imgTitle;
    private String goodsDescription;
    private String goodsMyPrice;
    private String goodsMarketPrice;

    public Template3(String imgUrl, String imgTitle, String goodsDescription, String goodsMyPrice, String goodsMarketPrice) {
        this.imgUrl = imgUrl;
        this.imgTitle = imgTitle;
        this.goodsDescription = goodsDescription;
        this.goodsMyPrice = goodsMyPrice;
        this.goodsMarketPrice = goodsMarketPrice;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgTitle() {
        return imgTitle;
    }

    public void setImgTitle(String imgTitle) {
        this.imgTitle = imgTitle;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    public String getGoodsMyPrice() {
        return goodsMyPrice;
    }

    public void setGoodsMyPrice(String goodsMyPrice) {
        this.goodsMyPrice = goodsMyPrice;
    }

    public String getGoodsMarketPrice() {
        return goodsMarketPrice;
    }

    public void setGoodsMarketPrice(String goodsMarketPrice) {
        this.goodsMarketPrice = goodsMarketPrice;
    }
}
