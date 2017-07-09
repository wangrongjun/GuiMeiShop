package com.guimei.shop.dao.impl;

import com.guimei.shop.bean.GoodsImage;
import com.guimei.shop.dao.GoodsImageDao;
import com.guimei.shop.framework.GuiMeiDao;
import com.wang.db2.Query;
import com.wang.db2.Where;

import java.util.List;

/**
 * by wangrongjun on 2017/6/17.
 */
public class GoodsImageDaoImpl extends GuiMeiDao<GoodsImage> implements GoodsImageDao {
    @Override
    protected Class<GoodsImage> getEntityClass() {
        return GoodsImage.class;
    }

    @Override
    public List<GoodsImage> queryByGoodsId(int goodsId) {
        return query(Query.build(Where.build("goods", goodsId + "")).maxQueryForeignKeyLevel(0));
    }
}
