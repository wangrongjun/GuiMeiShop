package com.guimei.shop.dao.impl;

import com.guimei.shop.bean.Address;
import com.guimei.shop.dao.AddressDao;
import com.guimei.shop.framework.GuiMeiDao;
import com.wang.db2.Query;
import com.wang.db2.Where;

import java.util.List;

/**
 * by wangrongjun on 2017/6/19.
 */
public class AddressDaoImpl extends GuiMeiDao<Address> implements AddressDao {
    @Override
    protected Class<Address> getEntityClass() {
        return Address.class;
    }

    @Override
    public List<Address> queryByCustomerId(int customerId) {
        return query(Query.build(Where.build("customer", customerId + "")).maxQueryForeignKeyLevel(0));
    }
}
