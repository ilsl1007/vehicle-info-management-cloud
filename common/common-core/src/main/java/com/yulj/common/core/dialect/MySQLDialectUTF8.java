package com.yulj.common.core.dialect;

import org.hibernate.dialect.MySQL5Dialect;

/**
 * @Classname MySQLDialectUTF8
 * @Description <h1>重写数据库方言</h1>
 * @Author yulj
 * @Date: 2020/6/8 21:23
 */
public class MySQLDialectUTF8 extends MySQL5Dialect {

    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }

}
