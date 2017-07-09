package com.guimei.shop.dao;

import com.guimei.shop.bean.ShopCar;
import com.wang.db2.Dao;

/**
 * by wangrongjun on 2017/6/17.
 */
public interface ShopCarDao extends Dao<ShopCar> {

    int queryCountByCustomerId(int customerId);

}
