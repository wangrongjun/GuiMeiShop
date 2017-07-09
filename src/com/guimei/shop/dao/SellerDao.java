package com.guimei.shop.dao;

import com.guimei.shop.bean.Seller;
import com.wang.db2.Dao;

/**
 * by wangrongjun on 2017/6/17.
 */
public interface SellerDao extends Dao<Seller> {

    Seller query(String phone, String password);

    boolean queryExists(String phone);
}
