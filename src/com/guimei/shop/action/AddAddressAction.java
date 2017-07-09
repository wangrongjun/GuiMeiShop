package com.guimei.shop.action;

import com.guimei.shop.bean.Address;
import com.guimei.shop.bean.Customer;
import com.guimei.shop.dao.AddressDao;
import com.guimei.shop.dao.impl.AddressDaoImpl;
import com.guimei.shop.framework.Action;
import com.guimei.shop.framework.ActionClass;
import com.guimei.shop.util.SessionUtil;
import com.wang.java_util.TextUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * by wangrongjun on 2017/6/20.
 */
public class AddAddressAction extends ActionClass {
    @Override
    protected String execute() throws ServletException, IOException, ParamErrorException, CustomerNotExistsException {
        Customer customer = checkCustomer();
        String address = checkStringParameter("address");

        AddressDao addressDao = new AddressDaoImpl();
        Address newAddress = new Address(customer, address);
        addressDao.insert(newAddress);

        List<Address> addressList = (List<Address>) request.getSession().getAttribute("addressList");
        if (addressList != null) {
            addressList.add(0, new Address(null, address));
        }
        return "-create_order.jsp";
    }
}
