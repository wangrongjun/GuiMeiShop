package com.guimei.shop.action;

import com.guimei.shop.bean.Goods;
import com.guimei.shop.bean.GoodsType;
import com.guimei.shop.dao.GoodsDao;
import com.guimei.shop.dao.GoodsTypeDao;
import com.guimei.shop.dao.impl.GoodsDaoImpl;
import com.guimei.shop.dao.impl.GoodsTypeDaoImpl;
import com.guimei.shop.framework.ActionClass;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * by wangrongjun on 2017/6/21.
 */
public class ShowIndexAction extends ActionClass {
    @Override
    protected String execute() throws ServletException, IOException, ParamErrorException, CustomerNotExistsException {
        int pageIndex = getIntegerParameter("pageIndex", 0);
        int sortType = getIntegerParameter("sortType", 0);

        GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
        List<GoodsType> goodsTypeList = goodsTypeDao.queryAll();
        GoodsDao goodsDao = new GoodsDaoImpl();
        List<Goods> goodsList = goodsDao.begin(12 * pageIndex).count(12).sortType(sortType).queryAll();
        int totalCount = goodsDao.queryCount(null);

        request.getSession().setAttribute("goodsTypeList", goodsTypeList);
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("totalCount", totalCount);
        request.setAttribute("goodsList", goodsList);
        request.setAttribute("sortType", sortType);
        return "index.jsp";
    }
}
