package com.yikang.o2o.dao;

import com.yikang.o2o.BaseTest;
import com.yikang.o2o.entity.ProductCategory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductCategoryDaoTest extends BaseTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    @Ignore
    public void testQueryByShopId() throws Exception{
        long shopId=11;
        List<ProductCategory> productCategories = productCategoryDao.queryProductCategoryList(shopId);
        for (ProductCategory productCategory:productCategories){
            System.out.println(productCategory.getProductCategoryName());
        }
    }

}
