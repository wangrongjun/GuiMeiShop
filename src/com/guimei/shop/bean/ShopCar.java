package com.guimei.shop.bean;

import com.wang.db2.Id;
import com.wang.db2.Reference;

/**
 * by wangrongjun on 2017/6/16.
 */
public class ShopCar {

    @Id
    private int carId;
    @Reference
    private Customer customer;
    @Reference
    private Goods goods;

    public ShopCar() {
    }

    public ShopCar(Customer customer, Goods goods) {
        this.customer = customer;
        this.goods = goods;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
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
}
