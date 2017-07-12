package com.guimei.shop.dao.impl_h;

import com.guimei.shop.bean.Goods;
import com.guimei.shop.dao.GoodsDao;
import com.guimei.shop.framework.HibernateDao;

import java.util.List;

/**
 *  by wangrongjun on 2017/7/12.
 */
public class GoodsDaoHImpl extends HibernateDao<Goods> implements GoodsDao{
    @Override
    public GoodsDao begin(int begin) {
        return null;
    }

    @Override
    public GoodsDao count(int count) {
        return null;
    }

    @Override
    public GoodsDao sortType(int sortType) {
        return null;
    }

    @Override
    public int queryCountByShopId(int shopId) {
        return 0;
    }

    @Override
    public List<Goods> queryByShopId(int shopId, int begin, int count) {
        return null;
    }

    @Override
    public int queryCountBySearchWord(String searchWord) {
        return 0;
    }

    @Override
    public List<Goods> queryBySearchWord(String searchWord, int begin, int count) {
        return null;
    }

    @Override
    public int queryCountByGoodsTypeId(int goodsTypeId) {
        return 0;
    }

    @Override
    public List<Goods> queryByGoodsTypeId(int goodsTypeId, int begin, int count) {
        return null;
    }

    @Override
    public int queryCountByCustomerId(int customerId) {
        return 0;
    }

    @Override
    public List<Goods> queryByCustomerId(int customerId, int begin, int count) {
        return null;
    }

    @Override
    protected Class<Goods> getEntityClass() {
        return null;
    }
}
