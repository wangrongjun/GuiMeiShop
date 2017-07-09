package com.guimei.shop.dao.impl;

import com.guimei.shop.bean.GoodsImage;
import com.guimei.shop.bean.Orders;
import com.guimei.shop.dao.GoodsImageDao;
import com.guimei.shop.dao.OrdersDao;
import com.guimei.shop.framework.GuiMeiDao;
import com.wang.db2.Query;
import com.wang.db2.Where;

import java.util.List;

/**
 * by wangrongjun on 2017/6/17.
 */
public class OrdersDaoImpl extends GuiMeiDao<Orders> implements OrdersDao {
    @Override
    protected Class<Orders> getEntityClass() {
        return Orders.class;
    }

    @Override
    public List<Orders> queryByCustomerId(int customerId) {
        List<Orders> ordersList = query(Query.build(Where.build("customer", customerId + "")).
                maxQueryForeignKeyLevel(2).
                ignore("customer").
                orderBy("-createTime")
        );

        GoodsImageDao goodsImageDao = new GoodsImageDaoImpl();
        for (Orders orders : ordersList) {
            List<GoodsImage> goodsImageList = goodsImageDao.queryByGoodsId(orders.getGoods().getGoodsId());
            orders.getGoods().setGoodsImageList(goodsImageList);
        }

        return ordersList;
    }

    @Override
    public int queryCountByCustomerId(int customerId) {
        return queryCount(Where.build("customer", customerId + ""));
    }

    @Override
    public int queryCountByGoodsId(int goodsId) {
        return queryCount(Where.build("goods", goodsId + ""));
    }
}
