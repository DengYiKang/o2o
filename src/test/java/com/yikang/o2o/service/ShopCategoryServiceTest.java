package com.yikang.o2o.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import com.yikang.o2o.dto.ImageHolder;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.yikang.o2o.BaseTest;
import com.yikang.o2o.entity.ShopCategory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShopCategoryServiceTest extends BaseTest {
    @Autowired
    private ShopCategoryService shopCategoryService;


    @Test
    @Ignore
    public void testAAddFirstShopCategoryList() throws FileNotFoundException {
        ShopCategory shopCategory1 = new ShopCategory();
        shopCategory1.setShopCategoryId(1L);
        shopCategory1.setShopCategoryName("奶茶");
        shopCategory1.setShopCategoryDesc("奶茶");
        shopCategory1.setPriority(1);
        InputStream is1 = new FileInputStream("/home/yikang/Picture/desktopIcon/idea.png");
        ImageHolder imageHolder1 = new ImageHolder("naicha.png", is1);
        shopCategoryService.addShopCategory(shopCategory1, imageHolder1);
        ShopCategory shopCategory2 = new ShopCategory();
        shopCategory2.setShopCategoryId(2L);
        shopCategory2.setShopCategoryName("二手");
        shopCategory2.setShopCategoryDesc("二手");
        shopCategory2.setPriority(1);
        InputStream is2 = new FileInputStream("/home/yikang/Picture/desktopIcon/idea.png");
        ImageHolder imageHolder2 = new ImageHolder("ershou.png", is2);
        shopCategoryService.addShopCategory(shopCategory2, imageHolder2);
        ShopCategory shopCategory3 = new ShopCategory();
        shopCategory3.setShopCategoryId(3L);
        shopCategory3.setShopCategoryName("美容");
        shopCategory3.setShopCategoryDesc("美容");
        shopCategory3.setPriority(1);
        InputStream is3 = new FileInputStream("/home/yikang/Picture/desktopIcon/idea.png");
        ImageHolder imageHolder3 = new ImageHolder("meirong.png", is3);
        shopCategoryService.addShopCategory(shopCategory3, imageHolder3);
        ShopCategory shopCategory4 = new ShopCategory();
        shopCategory4.setShopCategoryId(4L);
        shopCategory4.setShopCategoryName("家具");
        shopCategory4.setShopCategoryDesc("家具");
        shopCategory4.setPriority(1);
        InputStream is4 = new FileInputStream("/home/yikang/Picture/desktopIcon/idea.png");
        ImageHolder imageHolder4 = new ImageHolder("jiaju.png", is4);
        shopCategoryService.addShopCategory(shopCategory4, imageHolder4);
    }

    @Test
    public void testBAddSecondShopCategoryList() throws FileNotFoundException {
        ShopCategory parent1 = new ShopCategory();
        parent1.setShopCategoryId(1L);
        ShopCategory parent2 = new ShopCategory();
        parent2.setShopCategoryId(2L);
        ShopCategory parent3 = new ShopCategory();
        parent3.setShopCategoryId(3L);
        ShopCategory parent4 = new ShopCategory();
        parent4.setShopCategoryId(4L);

        ShopCategory shopCategory1 = new ShopCategory();
        shopCategory1.setShopCategoryName("咖啡奶茶");
        shopCategory1.setShopCategoryDesc("咖啡奶茶");
        shopCategory1.setPriority(1);
        shopCategory1.setParent(parent1);
        InputStream is1 = new FileInputStream("/home/yikang/Picture/desktopIcon/idea.png");
        ImageHolder imageHolder1 = new ImageHolder("caffe.png", is1);
        shopCategoryService.addShopCategory(shopCategory1, imageHolder1);

        ShopCategory shopCategory2 = new ShopCategory();
        shopCategory2.setShopCategoryName("水果奶茶");
        shopCategory2.setShopCategoryDesc("水果奶茶");
        shopCategory2.setPriority(1);
        shopCategory2.setParent(parent1);
        InputStream is2 = new FileInputStream("/home/yikang/Picture/desktopIcon/idea.png");
        ImageHolder imageHolder2 = new ImageHolder("shuiguo.png", is2);
        shopCategoryService.addShopCategory(shopCategory2, imageHolder2);

        ShopCategory shopCategory3 = new ShopCategory();
        shopCategory3.setShopCategoryName("coco奶茶");
        shopCategory3.setShopCategoryDesc("coco奶茶");
        shopCategory3.setPriority(1);
        shopCategory3.setParent(parent1);
        InputStream is3 = new FileInputStream("/home/yikang/Picture/desktopIcon/idea.png");
        ImageHolder imageHolder3 = new ImageHolder("shuiguo.png", is3);
        shopCategoryService.addShopCategory(shopCategory3, imageHolder3);

        ShopCategory shopCategory4 = new ShopCategory();
        shopCategory4.setShopCategoryName("二手车");
        shopCategory4.setShopCategoryDesc("二手车");
        shopCategory4.setPriority(1);
        shopCategory4.setParent(parent2);
        InputStream is4 = new FileInputStream("/home/yikang/Picture/desktopIcon/idea.png");
        ImageHolder imageHolder4 = new ImageHolder("ershouche.png", is4);
        shopCategoryService.addShopCategory(shopCategory4, imageHolder4);

        ShopCategory shopCategory5 = new ShopCategory();
        shopCategory5.setShopCategoryName("二手房");
        shopCategory5.setShopCategoryDesc("二手房");
        shopCategory5.setPriority(1);
        shopCategory5.setParent(parent2);
        InputStream is5 = new FileInputStream("/home/yikang/Picture/desktopIcon/idea.png");
        ImageHolder imageHolder5 = new ImageHolder("ershoufang.png", is5);
        shopCategoryService.addShopCategory(shopCategory5, imageHolder5);

        ShopCategory shopCategory6 = new ShopCategory();
        shopCategory6.setShopCategoryName("洗面奶");
        shopCategory6.setShopCategoryDesc("洗面奶");
        shopCategory6.setPriority(1);
        shopCategory6.setParent(parent3);
        InputStream is6 = new FileInputStream("/home/yikang/Picture/desktopIcon/idea.png");
        ImageHolder imageHolder6 = new ImageHolder("ximiannai.png", is6);
        shopCategoryService.addShopCategory(shopCategory6, imageHolder6);

        ShopCategory shopCategory7 = new ShopCategory();
        shopCategory7.setShopCategoryName("面膜");
        shopCategory7.setShopCategoryDesc("面膜");
        shopCategory7.setPriority(1);
        shopCategory7.setParent(parent3);
        InputStream is7 = new FileInputStream("/home/yikang/Picture/desktopIcon/idea.png");
        ImageHolder imageHolder7 = new ImageHolder("mianmo.png", is7);
        shopCategoryService.addShopCategory(shopCategory7, imageHolder7);

        ShopCategory shopCategory8 = new ShopCategory();
        shopCategory8.setShopCategoryName("电视机");
        shopCategory8.setShopCategoryDesc("电视机");
        shopCategory8.setPriority(1);
        shopCategory8.setParent(parent4);
        InputStream is8 = new FileInputStream("/home/yikang/Picture/desktopIcon/idea.png");
        ImageHolder imageHolder8 = new ImageHolder("dianshiji.png", is8);
        shopCategoryService.addShopCategory(shopCategory8, imageHolder8);

        ShopCategory shopCategory9 = new ShopCategory();
        shopCategory9.setShopCategoryName("洗衣机");
        shopCategory9.setShopCategoryDesc("洗衣机");
        shopCategory9.setPriority(1);
        shopCategory9.setParent(parent4);
        InputStream is9 = new FileInputStream("/home/yikang/Picture/desktopIcon/idea.png");
        ImageHolder imageHolder9 = new ImageHolder("ershouche.png", is9);
        shopCategoryService.addShopCategory(shopCategory9, imageHolder9);
    }
}
