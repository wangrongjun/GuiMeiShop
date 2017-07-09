package com.guimei.shop.bean;

import com.wang.db2.Id;
import com.wang.db2.Ignore;
import com.wang.db2.Reference;

/**
 * by wangrongjun on 2017/6/16.
 */
public class Evaluate {

    @Ignore
    public static final int LEVEL_BAD = 0;
    @Ignore
    public static final int LEVEL_NORMAL = 1;
    @Ignore
    public static final int LEVEL_GOOD = 2;

    @Id
    private int evaluateId;
    @Reference
    private Orders orders;//Order外键，对某次购物（对应一份订单）的评价
    private String content;//评价内容
    private int level;//评价，好评，中评，差评
    private String time;//评价时间，格式：”yyyy-MM-dd HH:mm:ss”

    public Evaluate() {
    }

    public Evaluate(Orders orders, String content, int level, String time) {
        this.orders = orders;
        this.content = content;
        this.level = level;
        this.time = time;
    }

    public int getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(int evaluateId) {
        this.evaluateId = evaluateId;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
