package com.example.control_bac_system.service;

import com.example.control_bac_system.entity.PageQuery;
import com.example.control_bac_system.entity.PageQueryVo;
import com.example.control_bac_system.entity.Product;
import com.example.control_bac_system.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{

    @Resource
    private ProductMapper productMapper;

    @Override
    public int addProduct(Product product) {
        Long currentTime = System.currentTimeMillis();
        String code = UUID.randomUUID().toString().replaceAll("-","");
        product.setCreateTime(String.valueOf(currentTime));
        product.setProductCode(code);
        int i = productMapper.addProduct(product);
        return i;
    }

    @Override
    public int deleteProduct(Product product) {
        int i = productMapper.deleteProduct(product);
        return i;
    }

    @Override
    public PageQueryVo getProductList(PageQuery pageQuery) {
        Integer page = pageQuery.getPage();
        Integer limit = pageQuery.getLimit();
        Integer start = (page-1) * limit;
        Integer end = page * limit;
        int currentPage = 0;
        Integer total = productMapper.selectProductTotal(pageQuery);
        if (start >= total && total >= limit && total != 0){
            start = total - limit;
            end = total;
            currentPage = total/limit;
        }
        pageQuery.setStart(start);
        pageQuery.setEnd(end);
        List<Product> products = productMapper.selectProductByLimit(pageQuery);
        PageQueryVo<Product> pageQueryVo = new PageQueryVo<>();
        pageQueryVo.setTotal(total);
        pageQueryVo.setList(products);
        pageQueryVo.setCurrentPage(currentPage);

        return pageQueryVo;
    }

    @Override
    public List<Product> getChildrenList(PageQuery pageQuery) {
        List<Product> products = productMapper.selectProductByLimit(pageQuery);
        return products;
    }

    @Override
    public int updateProduct(Product product) {
        int i = productMapper.updateProduct(product);
        return i;
    }
}
