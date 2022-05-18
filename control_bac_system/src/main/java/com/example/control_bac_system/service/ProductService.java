package com.example.control_bac_system.service;

import com.example.control_bac_system.entity.PageQuery;
import com.example.control_bac_system.entity.PageQueryVo;
import com.example.control_bac_system.entity.Product;
import com.example.control_bac_system.entity.vo.OrderProductVo;

import java.util.List;

public interface ProductService {

    int addProduct(Product product);

    int deleteProduct(Product product);

    PageQueryVo getProductList(PageQuery pageQuery);

    List<Product> getChildrenList(PageQuery pageQuery);

    int updateProduct(Product product);

    List<OrderProductVo> getOrderProductList();
}
