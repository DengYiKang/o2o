package com.yikang.o2o.dao;

import com.yikang.o2o.BaseTest;
import com.yikang.o2o.dto.ShopExecution;
import com.yikang.o2o.entity.Area;
import com.yikang.o2o.entity.PersonInfo;
import com.yikang.o2o.entity.Shop;
import com.yikang.o2o.entity.ShopCategory;
import com.yikang.o2o.service.ShopService;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;

    @Autowired
    private ShopService shopService;


    @Test
    @Ignore
    public void testModifyShop() {
        Shop shop = shopDao.queryByShopId(1);
        shop.setShopName("L的店铺");
        try {
            InputStream fis = new FileInputStream(new File("/home/yikang/publicPro/upload/images/item/shop/1/dante.jpg"));
            ShopExecution shopExecution = shopService.modifyShop(shop, fis, "dante.jpg");
            System.out.println(shopExecution.getShop().getShopImg());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQueryByShopId() {
        long shopId = 1;
        Shop shop = shopDao.queryByShopId(shopId);
        System.out.println(shop.getArea().getAreaName());
        System.out.println(shop.getShopCategory().getShopCategoryName());
    }

    @Test
    public void testInsertShop() {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        int effectedNum = shopDao.insertShop(shop);
        assertEquals(1, effectedNum);
    }

    @Test
    @Ignore
    public void testUpdateShop() {
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopDesc("测试描述");
        shop.setShopAddr("测试地址");
        shop.setLastEditTime(new Date());
        int effectedNum = shopDao.updateShop(shop);
        assertEquals(1, effectedNum);
    }
}
