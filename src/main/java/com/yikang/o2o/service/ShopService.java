package com.yikang.o2o.service;

import com.yikang.o2o.dto.ShopExecution;
import com.yikang.o2o.entity.Shop;


import java.io.InputStream;

public interface ShopService {
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName);
}
