package com.guimei.shop.framework;

import com.wang.db2.BaseDao;

/**
 * by wangrongjun on 2017/6/17.
 */
public abstract class GuiMeiDao<T> extends BaseDao<T> {

    public GuiMeiDao() {
        super(Config.username, Config.password, Config.dbName, Config.printSql, Config.printResult);
    }

}
