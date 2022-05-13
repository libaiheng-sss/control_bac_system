package com.example.control_bac_system.mapper;

import com.example.control_bac_system.entity.PageQuery;
import com.example.control_bac_system.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    int addProduct(@Param("product") Product product);

    int deleteProduct(@Param("product") Product product);

    Integer selectProductTotal(@Param("pageQuery") PageQuery pageQuery);

    List<Product> selectProductByLimit(@Param("pageQuery")  PageQuery pageQuery);

    int updateProduct(@Param("product") Product product);
}
