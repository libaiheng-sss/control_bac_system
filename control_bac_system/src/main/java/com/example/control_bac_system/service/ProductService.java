package com.example.control_bac_system.service;

import com.example.control_bac_system.entity.PageQuery;
import com.example.control_bac_system.entity.PageQueryVo;
import com.example.control_bac_system.entity.Product;

public interface ProductService {

    int addProduct(Product product);

    int deleteProduct(Product product);

    PageQueryVo getProductList(PageQuery pageQuery);
}
