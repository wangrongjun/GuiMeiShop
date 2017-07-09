package com.guimei.shop.bean;

import com.wang.db2.Id;
import com.wang.db2.Reference;

/**
 * by wangrongjun on 2017/6/19.
 */
public class Address {

    @Id
    private int addressId;
    @Reference
    private Customer customer;
    private String address;

    public Address() {
    }

    public Address(Customer customer, String address) {
        this.customer = customer;
        this.address = address;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
