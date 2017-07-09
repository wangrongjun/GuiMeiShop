package com.guimei.shop.dao.impl;

import com.guimei.shop.bean.Shop;
import com.guimei.shop.dao.ShopDao;
import com.guimei.shop.framework.GuiMeiDao;

/**
 * by wangrongjun on 2017/6/17.
 */
public class ShopDaoImpl extends GuiMeiDao<Shop> implements ShopDao {
    @Override
    protected Class<Shop> getEntityClass() {
        return Shop.class;
    }
}
