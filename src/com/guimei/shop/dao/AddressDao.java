package com.guimei.shop.dao;

import com.guimei.shop.bean.Address;
import com.wang.db2.Dao;

import java.util.List;

/**
 * by wangrongjun on 2017/6/19.
 */
public interface AddressDao extends Dao<Address> {

    List<Address> queryByCustomerId(int customerId);

}
