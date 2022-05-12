package com.example.control_bac_system.service;

import com.example.control_bac_system.entity.PageQuery;
import com.example.control_bac_system.entity.PageQueryVo;
import com.example.control_bac_system.entity.Product;

import java.util.List;

public interface ProductService {

    int addProduct(Product product);

    int deleteProduct(Product product);

    PageQueryVo getProductList(PageQuery pageQuery);

    List<Product> getChildrenList(PageQuery pageQuery);
}
