package com.yikang.o2o.service;

import com.yikang.o2o.dto.ImageHolder;
import com.yikang.o2o.dto.ProductExecution;
import com.yikang.o2o.entity.Product;
import com.yikang.o2o.exception.ProductOperationException;

import java.util.List;

public interface ProductService {
    /**
     * 添加商品信息以及图片处理
     *
     * @param product        商品的基本信息
     * @param thumbnail      缩略图
     * @param productImgList 详情图片列表
     * @return
     * @throws ProductOperationException
     */
    ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList) throws ProductOperationException;
}
