package com.yikang.o2o.service;

import com.yikang.o2o.BaseTest;
import com.yikang.o2o.dto.ImageHolder;
import com.yikang.o2o.dto.ShopExecution;
import com.yikang.o2o.entity.Area;
import com.yikang.o2o.entity.PersonInfo;
import com.yikang.o2o.entity.Shop;
import com.yikang.o2o.entity.ShopCategory;
import com.yikang.o2o.enums.ShopStateEnum;
import com.yikang.o2o.exception.ShopOperationException;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest {


    @Autowired
    private ShopService shopService;

    @Test
    public void testQueryShopListAndCount() {
        Shop shopCondition = new Shop();
        PersonInfo owner = new PersonInfo();
        owner.setUserId(1L);
        shopCondition.setOwner(owner);
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(1L);
        shopCondition.setShopCategory(shopCategory);
        ShopExecution se = shopService.getShopList(shopCondition, 1, 5);
        if (se.getState() == ShopStateEnum.SUCCESS.getState()) {
            for (Shop shop : se.getShopList()) {
                System.out.println(shop.getShopId());
            }
            System.out.println(se.getCount());
        }
        se = shopService.getShopList(shopCondition, 2, 5);
        if (se.getState() == ShopStateEnum.SUCCESS.getState()) {
            for (Shop shop : se.getShopList()) {
                System.out.println(shop.getShopId());
            }
            System.out.println(se.getCount());
        }
    }

    @Test
    @Ignore
    public void testAddShop() throws ShopOperationException, FileNotFoundException {
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
        shop.setShopName("测试的店铺1");
        shop.setShopDesc("test1");
        shop.setShopAddr("test1");
        shop.setPhone("test1");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");
        File shopImg = new File("/home/yikang/Picture/user_800_450.jpg");
        InputStream inputStream = new FileInputStream(shopImg);
        ShopExecution se = shopService.addShop(shop, new ImageHolder(shopImg.getName(), inputStream));
        assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
    }
}
