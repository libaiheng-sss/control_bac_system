package com.example.control_bac_system.controller;

import com.example.control_bac_system.entity.PageQuery;
import com.example.control_bac_system.entity.PageQueryVo;
import com.example.control_bac_system.entity.Product;
import com.example.control_bac_system.model.ResultModel;
import com.example.control_bac_system.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("product")
public class ProductController {

    @Resource
    private ProductService productService;


    @PostMapping("add")
    public String addProduct(@RequestBody Product product){

        int i = productService.addProduct(product);
        String result = ResultModel.SUCCESS("200", "添加产品成功", i);
        return result;
    }

    @DeleteMapping("delete")
    public String deleteProduct(@RequestBody Product product){
        int i = productService.deleteProduct(product);
        String result = ResultModel.SUCCESS("200", "删除产品成功", i);
        return result;
    }

    @PostMapping("getList")
    public String getProductList(@RequestBody PageQuery pageQuery){
        PageQueryVo pageQueryVo = productService.getProductList(pageQuery);
        String result = ResultModel.SUCCESS("200", "获取产品列表", pageQueryVo);
        return result;
    }
}
