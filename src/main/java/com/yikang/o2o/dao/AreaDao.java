package com.yikang.o2o.dao;

import com.yikang.o2o.entity.Area;

import java.util.List;

public interface AreaDao {
    /**
     * 列出区域列表
     * @return areaList
     */
    List<Area> queryAreas();

    int insertArea(Area area);

    int updateArea(Area area);
}
