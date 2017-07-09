package com.guimei.shop.dao;

import com.guimei.shop.bean.Orders;
import com.wang.db2.Dao;

import java.util.List;

/**
 * by wangrongjun on 2017/6/17.
 */
public interface OrdersDao extends Dao<Orders> {
    List<Orders> queryByCustomerId(int customerId);

    int queryCountByCustomerId(int customerId);

    int queryCountByGoodsId(int goodsId);
}
