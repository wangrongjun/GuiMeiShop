package com.guimei.shop.action;

import com.guimei.shop.bean.Customer;
import com.guimei.shop.bean.Goods;
import com.guimei.shop.dao.DaoFactory;
import com.guimei.shop.dao.GoodsDao;
import com.guimei.shop.framework.ActionSupport;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * by wangrongjun on 2017/6/21.
 */
public class ShowShopCarAction extends ActionSupport {

    @Override
    protected String execute() throws ServletException, IOException, ParamErrorException, CustomerNotExistsException {
        Customer customer = checkCustomer();
        int pageIndex = getIntegerParameter("pageIndex", 0);

        GoodsDao goodsDao = DaoFactory.getGoodsDao();
        List<Goods> goodsList = goodsDao.queryByCustomerId(
                customer.getCustomerId(), 12 * pageIndex, 12);
        int totalCount = goodsDao.queryCountByCustomerId(customer.getCustomerId());

        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("totalCount", totalCount);
        request.setAttribute("goodsList", goodsList);
        return "shop_car.jsp";
    }

}
