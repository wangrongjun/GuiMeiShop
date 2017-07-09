package com.guimei.shop.dao;

import com.guimei.shop.bean.Customer;
import com.wang.db2.Dao;

/**
 * by wangrongjun on 2017/6/17.
 */
public interface CustomerDao extends Dao<Customer> {

    Customer query(String phone, String password);

    boolean queryExists(String phone);

    boolean updateHeadUrl(int customerId, String headUrl);

}
