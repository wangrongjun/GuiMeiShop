package com.guimei.shop.action;

import com.guimei.shop.bean.Customer;
import com.guimei.shop.bean.Seller;
import com.guimei.shop.dao.CustomerDao;
import com.guimei.shop.dao.DaoFactory;
import com.guimei.shop.dao.SellerDao;
import com.guimei.shop.framework.ActionSupport;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * by wangrongjun on 2017/6/18.
 */
public class RegisterAction extends ActionSupport {
    @Override
    protected String execute() throws ServletException, IOException, ParamErrorException, CustomerNotExistsException {
        String phone = checkStringParameter("phone");
        String password = checkStringParameter("password");
        String realName = checkStringParameter("realName");
        String nickname = checkStringParameter("nickname");
        String gender = checkStringParameter("gender");
        String identity = checkStringParameter("identity");

        if (identity.equals("customer")) {
            CustomerDao customerDao = DaoFactory.getCustomerDao();
            if (customerDao.queryExists(phone)) {
                request.setAttribute("msg", "该手机号已注册");
                return "register.jsp";
            }
            Customer customer = new Customer(phone, password, realName, nickname, "man".equals(gender) ? 1 : 0,
                    "admin/img/user_default_head.jpg");
            customerDao.insert(customer);
            request.setAttribute("phone", phone);
            request.setAttribute("password", password);
            request.setAttribute("identity", identity);
            return "login.jsp";
        } else {

            SellerDao sellerDao = DaoFactory.getSellerDao();
            if (sellerDao.queryExists(phone)) {
                request.setAttribute("msg", "该手机号已注册");
                return "register.jsp";
            }
            Seller seller = new Seller(phone, password, realName, nickname, "男".equals(gender) ? 1 : 0,
                    "admin/img/user_default_head.jpg");
            sellerDao.insert(seller);
            request.setAttribute("phone", phone);
            request.setAttribute("password", password);
            request.setAttribute("identity", identity);
            return "login.jsp";
        }
    }
}
