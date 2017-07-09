package com.guimei.shop.dao.impl;

import com.guimei.shop.bean.GoodsType;
import com.guimei.shop.dao.GoodsTypeDao;
import com.guimei.shop.framework.GuiMeiDao;
import com.wang.db2.Query;

import java.util.List;

/**
 * by wangrongjun on 2017/6/18.
 */
public class GoodsTypeDaoImpl extends GuiMeiDao<GoodsType> implements GoodsTypeDao {
    @Override
    protected Class<GoodsType> getEntityClass() {
        return GoodsType.class;
    }

    @Override
    public List<GoodsType> queryAll() {
        return query(Query.build(null).orderBy("goodsTypeId"));
    }
}
