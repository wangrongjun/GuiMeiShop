package com.guimei.shop.test;

import com.guimei.shop.bean.Customer;
import com.guimei.shop.dao.*;
import com.guimei.shop.dao.impl_h.CustomerDaoHImpl;
import com.guimei.shop.framework.HibernateDao;
import com.wang.java_util.GsonUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * by wangrongjun on 2017/7/12.
 */
public class HibernateDaoTest {

    private CustomerDao customerDao;

    @Test
    public void testGuiMeiDao() {
        Customer ÍõÈÙ¿¡ = new Customer("15521302230", "123", "ÍõÈÙ¿¡", "Ó¢¿¡", 1, "admin/img/customer_1.jpg");
        Customer Ä­Ä­ = new Customer("13023796942", "123", "Ä­Ä­", "Ä­±¦¶ù", 0, "admin/img/customer_2.jpg");

        customerDao.insert(ÍõÈÙ¿¡);
        customerDao.insert(Ä­Ä­);
        GsonUtil.printFormatJson(customerDao.query("15521302230", "123"));
        GsonUtil.printFormatJson(customerDao.queryById(2));
        GsonUtil.printFormatJson(customerDao.queryAll());
    }

    @Before
    public void init() {
        customerDao = new CustomerDaoHImpl();
    }

    @After
    public void close() {
        HibernateDao.closeSessionFactory();
    }

}
