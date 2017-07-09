package com.guimei.shop.action;

import com.guimei.shop.bean.Customer;
import com.guimei.shop.bean.Orders;
import com.guimei.shop.dao.OrdersDao;
import com.guimei.shop.dao.impl.OrdersDaoImpl;
import com.guimei.shop.framework.ActionClass;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * by wangrongjun on 2017/6/22.
 */
public class QueryCustomerOrderListAction extends ActionClass {
    @Override
    protected String execute() throws ServletException, IOException, ParamErrorException, CustomerNotExistsException {
        Customer customer = checkCustomer();

        OrdersDao ordersDao = new OrdersDaoImpl();
        List<Orders> ordersList = ordersDao.queryByCustomerId(customer.getCustomerId());
        int ordersCount = ordersDao.queryCountByCustomerId(customer.getCustomerId());

        request.setAttribute("ordersList", ordersList);
        request.setAttribute("ordersCount", ordersCount);
        return "customer_order_list.jsp";
    }
}
