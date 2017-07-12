package com.guimei.shop.action;

import com.guimei.shop.bean.Address;
import com.guimei.shop.bean.Customer;
import com.guimei.shop.dao.AddressDao;
import com.guimei.shop.dao.DaoFactory;
import com.guimei.shop.framework.ActionSupport;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * by wangrongjun on 2017/6/20.
 */
public class AddAddressAction extends ActionSupport {
    @Override
    protected String execute() throws ServletException, IOException, ParamErrorException, CustomerNotExistsException {
        Customer customer = checkCustomer();
        String address = checkStringParameter("address");

        AddressDao addressDao = DaoFactory.getAddressDao();
        Address newAddress = new Address(customer, address);
        addressDao.insert(newAddress);

        List<Address> addressList = (List<Address>) request.getSession().getAttribute("addressList");
        if (addressList != null) {
            addressList.add(0, new Address(null, address));
        }
        return "-create_order.jsp";
    }
}
