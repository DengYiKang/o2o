package com.yikang.o2o.web;

import com.yikang.o2o.dto.Result;
import com.yikang.o2o.entity.ProductCategory;
import com.yikang.o2o.entity.Shop;
import com.yikang.o2o.enums.ProductStateEnum;
import com.yikang.o2o.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/shopadmin")
public class ProductCategoryManagementController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @RequestMapping(value = "/getproductcategorylist")
    @ResponseBody
    private Result<List<ProductCategory>> getProductCategoryList(HttpServletRequest request) {
        //TODO:TO BE REMOVED
        Shop shop = new Shop();
        shop.setShopId(11L);
        request.getSession().setAttribute("currentShop", shop);
        //TODO:shop应该从session获得的，这里直接硬编码
        Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
        List<ProductCategory> list = null;
        if (currentShop != null && currentShop.getShopId() != null && currentShop.getShopId() > 0) {
            list = productCategoryService.getProductCategoryList(currentShop.getShopId());
            return new Result<>(true, list);
        } else {
            ProductStateEnum ps = ProductStateEnum.INNER_ERROR;
            return new Result<>(false, ps.getState(), ps.getStateInfo());
        }
    }

}
