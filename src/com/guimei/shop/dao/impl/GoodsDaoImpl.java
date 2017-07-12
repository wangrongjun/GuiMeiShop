package com.guimei.shop.dao.impl;

import com.guimei.shop.bean.Goods;
import com.guimei.shop.dao.DaoFactory;
import com.guimei.shop.dao.GoodsDao;
import com.guimei.shop.dao.GoodsImageDao;
import com.guimei.shop.dao.OrdersDao;
import com.guimei.shop.framework.GuiMeiDao;
import com.wang.db2.Query;
import com.wang.db2.Where;

import java.util.Collections;
import java.util.List;

/**
 * by wangrongjun on 2017/6/17.
 */
public class GoodsDaoImpl extends GuiMeiDao<Goods> implements GoodsDao {
    @Override
    protected Class<Goods> getEntityClass() {
        return Goods.class;
    }

    @Override
    protected List<Goods> executeQuery(String sql, int maxQueryForeignKeyLevel,
                                       List<String> ignoreReferenceList,
                                       List<String> requiredReferenceVariableList) {
        List<Goods> goodsList = super.executeQuery(sql, maxQueryForeignKeyLevel,
                ignoreReferenceList, requiredReferenceVariableList);

        GoodsImageDao goodsImageDao = DaoFactory.getGoodsImageDao();
        OrdersDao ordersDao = DaoFactory.getOrdersDao();
        for (Goods goods : goodsList) {
            goods.setGoodsImageList(goodsImageDao.queryByGoodsId(goods.getGoodsId()));
            goods.setSellCount(ordersDao.queryCountByGoodsId(goods.getGoodsId()));
        }
        return goodsList;
    }

    private int begin = 0;
    private int count = 0;
    private int sortType = 0;

    private static String getOrderByWordFromSortType(int sortType) {
        switch (sortType) {
            case 0://综合排序
                return null;
            case 1://销量排序
                return null;
            case 2://价格由低到高
                return "price";
            case 3://价格由高到低
                return "-price";
        }
        return null;
    }

    @Override
    public GoodsDao begin(int begin) {
        this.begin = begin;
        return this;
    }

    @Override
    public GoodsDao count(int count) {
        this.count = count;
        return this;
    }

    @Override
    public GoodsDao sortType(int sortType) {
        this.sortType = sortType;
        return this;
    }

    @Override
    public int queryCountByShopId(int shopId) {
        Where where = Where.build("shop", shopId + "");
        return queryCount(where);
    }

    @Override
    public List<Goods> queryByShopId(int shopId, int begin, int count) {
        Where where = Where.build("shop", shopId + "");
        return query(Query.build(where).maxQueryForeignKeyLevel(0).limit(begin, count));
    }

    @Override
    public int queryCountBySearchWord(String searchWord) {
        Where where = new Where().add("goodsName", "%" + searchWord + "%", Where.QueryMode.LIKE);
        return queryCount(where);
    }

    @Override
    public List<Goods> queryBySearchWord(String searchWord, int begin, int count) {
        Where where = new Where().add("goodsName", "%" + searchWord + "%", Where.QueryMode.LIKE);
        return query(Query.build(where).limit(begin, count).maxQueryForeignKeyLevel(0));
    }

    @Override
    public int queryCountByGoodsTypeId(int goodsTypeId) {
        Where where = Where.build("goodsType", goodsTypeId + "");
        return queryCount(where);
    }

    @Override
    public List<Goods> queryByGoodsTypeId(int goodsTypeId, int begin, int count) {
        Where where = Where.build("goodsType", goodsTypeId + "");
        return query(Query.build(where).limit(begin, count).maxQueryForeignKeyLevel(0));
    }

    @Override
    public List<Goods> queryAll() {
        //TODO 修改java_lib
        String sortType = getOrderByWordFromSortType(this.sortType);
        if (sortType == null) {
            return query(Query.build(null).
                    maxQueryForeignKeyLevel(0).
                    limit(begin, count));
        } else {
            return query(Query.build(null).
                    maxQueryForeignKeyLevel(0).
                    limit(begin, count).
                    orderBy(sortType));
        }
    }

    @Override
    public int queryCountByCustomerId(int customerId) {
        String sql = "select count(*) from Goods,ShopCar" +
                " where " +
                "Goods.goodsId=ShopCar.goods" +
                " and " +
                "ShopCar.customer='" + customerId + "';";
        return executeQueryCount(sql);
    }

    @Override
    public List<Goods> queryByCustomerId(int customerId, int begin, int count) {
        String sql = "select Goods.* from Goods,ShopCar" +
                " where " +
                "Goods.goodsId=ShopCar.goods" +
                " and " +
                "ShopCar.customer='" + customerId + "'";
        if (count > 0 && begin >= 0) {
            sql += " limit " + begin + "," + count;
        }
        sql += ";";
        return executeQuery(sql, 0, Collections.singletonList("shop"), null);
    }

}
