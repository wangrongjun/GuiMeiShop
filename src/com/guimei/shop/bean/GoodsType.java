package com.guimei.shop.bean;

import com.wang.db2.Column;
import com.wang.db2.Id;

/**
 * by wangrongjun on 2017/6/18.
 */
public class GoodsType {

    @Id
    private int goodsTypeId;
    @Column(length = 50, nullable = false, unique = true)
    private String name;

    public GoodsType() {
    }

    public GoodsType(String name) {
        this.name = name;
    }

    public int getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(int goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
