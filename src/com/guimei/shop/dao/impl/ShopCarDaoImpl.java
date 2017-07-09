package com.guimei.shop.dao.impl;

import com.guimei.shop.bean.ShopCar;
import com.guimei.shop.dao.ShopCarDao;
import com.guimei.shop.framework.GuiMeiDao;
import com.wang.db2.Where;

/**
 * by wangrongjun on 2017/6/16.
 */
public class ShopCarDaoImpl extends GuiMeiDao<ShopCar> implements ShopCarDao {
    @Override
    protected Class<ShopCar> getEntityClass() {
        return ShopCar.class;
    }

    @Override
    public int queryCountByCustomerId(int customerId) {
        return queryCount(Where.build("customer", customerId + ""));
    }
}
