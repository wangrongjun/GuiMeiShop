package com.guimei.shop.dao.impl;

import com.guimei.shop.bean.Evaluate;
import com.guimei.shop.dao.EvaluateDao;
import com.guimei.shop.framework.GuiMeiDao;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * by wangrongjun on 2017/6/17.
 */
public class EvaluateDaoImpl extends GuiMeiDao<Evaluate> implements EvaluateDao {
    @Override
    protected Class<Evaluate> getEntityClass() {
        return Evaluate.class;
    }

    @Override
    public List<Evaluate> queryByGoodsId(int goodsId) {
        String sql = "select Evaluate.* from Evaluate,Orders" +
                " where " +
                "Evaluate.orders=Orders.ordersId" +
                " and " +
                "Orders.goods='" + goodsId + "';";
        return executeQuery(sql, 2, Collections.singletonList("goods"),
                Arrays.asList("nickname", "gender", "headUrl"));
    }
}
