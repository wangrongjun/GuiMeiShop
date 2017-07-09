package com.guimei.shop.dao.impl;

import com.guimei.shop.bean.Seller;
import com.guimei.shop.dao.SellerDao;
import com.guimei.shop.framework.GuiMeiDao;
import com.wang.db2.Where;

import java.util.List;

/**
 * by wangrongjun on 2017/6/17.
 */
public class SellerDaoImpl extends GuiMeiDao<Seller> implements SellerDao {
    @Override
    protected Class<Seller> getEntityClass() {
        return Seller.class;
    }

    @Override
    public Seller query(String phone, String password) {
        List<Seller> list = query(Where.build("phone", phone).add("password", password));
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean queryExists(String phone) {
        List<Seller> list = query(Where.build("phone", phone));
        return list != null && list.size() > 0;
    }
}
