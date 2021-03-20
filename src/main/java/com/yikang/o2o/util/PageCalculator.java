package com.yikang.o2o.util;

/**
 * 数据库查询使用的是rowIndex，而前端所需要的是pageIndex
 * 该类负责rowIndex与pageIndex的相互转换
 */
public class PageCalculator {
    public static int calculateRowIndex(int pageIndex, int pageSize) {
        return (pageIndex > 0) ? (pageIndex - 1) * pageSize : 0;
    }
}
