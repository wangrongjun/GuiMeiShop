package com.guimei.shop.action;

import com.guimei.shop.bean.Customer;
import com.guimei.shop.bean.Seller;
import com.guimei.shop.dao.CustomerDao;
import com.guimei.shop.dao.SellerDao;
import com.guimei.shop.dao.impl.CustomerDaoImpl;
import com.guimei.shop.dao.impl.SellerDaoImpl;
import com.guimei.shop.framework.ActionClass;
import com.wang.java_util.MathUtil;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * by wangrongjun on 2017/6/17.
 */
public class LoginAction extends ActionClass {
    @Override
    protected String execute() throws ParamErrorException, ServletException, IOException {
        String phone = checkStringParameter("phone");
        String password = checkStringParameter("password");
        String identity = checkStringParameter("identity");

        if (identity.equals("customer")) {// 如果是客户登录
            CustomerDao customerDao = new CustomerDaoImpl();
            Customer customer = customerDao.query(phone, password);
            if (customer != null) {
                request.getSession().invalidate();
                request.getSession().setAttribute("customer", customer);
                return "-index.jsp";
            } else {
                request.setAttribute("msg", "用户名或密码错误");
                return "login.jsp";
            }
        } else {// 如果是商家登录
            SellerDao sellerDao = new SellerDaoImpl();
            Seller seller = sellerDao.query(phone, password);
            if (seller != null) {
                request.getSession().invalidate();
                request.getSession().setAttribute("seller", seller);
                return "-index_seller.jsp";
            } else {
                request.setAttribute("msg", "用户名或密码错误");
                return "login.jsp";
            }
        }
    }
}
