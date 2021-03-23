package com.yikang.o2o.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import com.yikang.o2o.dto.ImageHolder;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.yikang.o2o.BaseTest;
import com.yikang.o2o.entity.HeadLine;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HeadLineServiceTest extends BaseTest {
    @Autowired
    private HeadLineService headLineService;


    @Test
    public void testAAddHeadLine() throws FileNotFoundException {
        HeadLine headLine = new HeadLine();
        headLine.setLineLink("https://www.baidu.com/");
        headLine.setEnableStatus(1);
        headLine.setPriority(1);
        headLine.setLineName("headline 1");
        InputStream inputStream1 = new FileInputStream("/home/yikang/Picture/back.png");
        InputStream inputStream2 = new FileInputStream("/home/yikang/Picture/back.png");
        InputStream inputStream3 = new FileInputStream("/home/yikang/Picture/back.png");
        InputStream inputStream4 = new FileInputStream("/home/yikang/Picture/back.png");
        headLineService.addHeadLine(headLine, new ImageHolder("headline1.jpg", inputStream1));
        HeadLine headLine1 = new HeadLine();
        headLine1.setLineLink("https://www.baidu.com/");
        headLine1.setEnableStatus(1);
        headLine1.setPriority(2);
        headLine1.setLineName("headline 2");
        headLineService.addHeadLine(headLine1, new ImageHolder("headline2.jpg", inputStream2));
        HeadLine headLine2 = new HeadLine();
        headLine2.setLineLink("https://www.baidu.com/");
        headLine2.setEnableStatus(1);
        headLine2.setPriority(3);
        headLine2.setLineName("headline 3");
        headLineService.addHeadLine(headLine2, new ImageHolder("headline3.jpg", inputStream3));
        HeadLine headLine4 = new HeadLine();
        headLine4.setLineLink("https://www.baidu.com/");
        headLine4.setEnableStatus(1);
        headLine4.setPriority(2);
        headLine4.setLineName("headline 4");
        headLineService.addHeadLine(headLine4, new ImageHolder("headline4.jpg", inputStream4));
    }

    @Test
    public void testBGetHeadLineList() {
        List<HeadLine> headLineList = headLineService.getHeadLineList(new HeadLine());
        System.out.println(headLineList.get(0).getLineName());
        HeadLine headLineCondition = new HeadLine();
        headLineCondition.setEnableStatus(1);
        headLineList = headLineService.getHeadLineList(headLineCondition);
        System.out.println(headLineList.get(0).getLineName());
    }
}
