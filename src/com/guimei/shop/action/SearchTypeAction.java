package com.guimei.shop.action;

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
public class SearchTypeAction extends ActionSupport {
    @Override
    protected String execute() throws ServletException, IOException, ParamErrorException, CustomerNotExistsException {
        int goodsTypeId = checkIntegerParameter("goodsTypeId");
        int pageIndex = getIntegerParameter("pageIndex", 0);
        int sortType = getIntegerParameter("sortType", 0);

        GoodsDao goodsDao = DaoFactory.getGoodsDao();
        int totalCount = goodsDao.queryCountByGoodsTypeId(goodsTypeId);
        List<Goods> goodsList = goodsDao.queryByGoodsTypeId(goodsTypeId, pageIndex * 12, 12);

        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("totalCount", totalCount);
        request.setAttribute("sortType", sortType);
        request.setAttribute("goodsList", goodsList);
        request.setAttribute("goodsTypeId", goodsTypeId);
        return "search_goods_type.jsp";
    }
}
