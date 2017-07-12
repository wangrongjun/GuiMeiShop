package com.guimei.shop.action;

import com.guimei.shop.bean.Address;
import com.guimei.shop.bean.Customer;
import com.guimei.shop.bean.Goods;
import com.guimei.shop.dao.AddressDao;
import com.guimei.shop.dao.DaoFactory;
import com.guimei.shop.dao.GoodsDao;
import com.guimei.shop.framework.ActionSupport;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * by wangrongjun on 2017/6/20.
 */
public class ConfirmOrderAction extends ActionSupport {
    @Override
    protected String execute() throws ServletException, IOException, ParamErrorException, CustomerNotExistsException {
        Customer customer = checkCustomer();
        int goodsId = checkIntegerParameter("goodsId");
        int count = checkIntegerParameter("count");

        GoodsDao goodsDao = DaoFactory.getGoodsDao();
        Goods goods = goodsDao.queryById(goodsId);
        AddressDao addressDao = DaoFactory.getAddressDao();
        List<Address> addressList = addressDao.queryByCustomerId(customer.getCustomerId());

        request.getSession().setAttribute("goods", goods);
        request.getSession().setAttribute("addressList", addressList);
        request.getSession().setAttribute("count", count);
        return "create_order.jsp";
    }
}
