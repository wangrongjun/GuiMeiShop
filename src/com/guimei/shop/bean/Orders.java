package com.guimei.shop.bean;

import com.wang.db2.Id;
import com.wang.db2.Ignore;
import com.wang.db2.Reference;

/**
 * by wangrongjun on 2017/6/16.
 */
public class Orders {

    @Ignore
    public static final int STATE_CONTINUTE = 0;
    @Ignore
    public static final int STATE_SUCCEED = 1;
    @Ignore
    public static final int STATE_FAILED = 2;

    @Id
    private int ordersId;
    @Reference
    private Customer customer;
    @Reference
    private Goods goods;
    private int buyCount;//该商品购买的数量
    private double price;//订单创建时商品的总价格（预防下单后商家修改该商品的价格导致出错）
    private String phone;//收货人的联系电话
    private String receiverName;//收货人的姓名
    private String address;//收货人的收货地址（预防下单后客户修改收货地址导致出错）
    private String createTime;//订单创建时间，格式：”yyyy-MM-dd HH:mm:ss”
    private int state;//订单状态，进行中，关闭，成功

    public Orders() {
    }

    public Orders(Customer customer, Goods goods, int buyCount, double price, String phone,
                  String receiverName, String address, String createTime, int state) {
        this.customer = customer;
        this.goods = goods;
        this.buyCount = buyCount;
        this.price = price;
        this.phone = phone;
        this.receiverName = receiverName;
        this.address = address;
        this.createTime = createTime;
        this.state = state;
    }

    public int getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(int ordersId) {
        this.ordersId = ordersId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(int buyCount) {
        this.buyCount = buyCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String realName) {
        this.receiverName = receiverName;
    }
}
