package com.yikang.o2o.dao;

import com.yikang.o2o.BaseTest;
import com.yikang.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AreaDaoTest extends BaseTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQueryArea() {
        List<Area> areaList = areaDao.queryAreas();
        assertEquals(4, areaList.size());
    }
}
