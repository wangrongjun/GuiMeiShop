package com.guimei.shop.dao.impl;

import com.guimei.shop.bean.Customer;
import com.guimei.shop.dao.CustomerDao;
import com.guimei.shop.framework.GuiMeiDao;
import com.wang.db2.Where;

import java.util.List;

/**
 * by wangrongjun on 2017/6/17.
 */
public class CustomerDaoImpl extends GuiMeiDao<Customer> implements CustomerDao {
    @Override
    protected Class<Customer> getEntityClass() {
        return Customer.class;
    }

    @Override
    public Customer query(String phone, String password) {
        List<Customer> list = query(Where.build("phone", phone).add("password", password));
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean queryExists(String phone) {
        return queryCount(Where.build("phone", phone)) > 0;
    }

    @Override
    public boolean updateHeadUrl(int customerId, String headUrl) {
        Customer customer = queryById(customerId);
        customer.setHeadUrl(headUrl);
        return update(customer);
    }

}
