package com.yikang.o2o.dao;

import com.yikang.o2o.BaseTest;
import com.yikang.o2o.entity.ProductCategory;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductCategoryDaoTest extends BaseTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void testBQueryByShopId() {
        long shopId = 11;
        List<ProductCategory> productCategories = productCategoryDao.queryProductCategoryList(shopId);
        for (ProductCategory productCategory : productCategories) {
            System.out.println(productCategory.getProductCategoryName());
        }
    }

    @Test
    public void testABatchInsertProductCategory() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryName("商品类别1");
        productCategory.setPriority(0);
        productCategory.setCreateTime(new Date());
        productCategory.setShopId(11L);
        ProductCategory productCategory2 = new ProductCategory();
        productCategory2.setProductCategoryName("商品类别2");
        productCategory2.setPriority(1);
        productCategory2.setCreateTime(new Date());
        productCategory2.setShopId(11L);
        List<ProductCategory> list = new ArrayList<>();
        list.add(productCategory);
        list.add(productCategory2);
        int effectedNum = productCategoryDao.batchInsertProductCategory(list);
        assertEquals(2, effectedNum);
    }

    @Test
    public void testCDeleteProductCategory() {
        long shopId = 11L;
        List<ProductCategory> list = productCategoryDao.queryProductCategoryList(shopId);
        for (ProductCategory productCategory : list) {
            if ("商品类别1".equals(productCategory.getProductCategoryName())
                    || "商品类别2".equals(productCategory.getProductCategoryName())) {
                int effectedNum = productCategoryDao.deleteProductCategory(productCategory.getProductCategoryId(), shopId);
                assertEquals(1, effectedNum);
            }
        }
    }

}
