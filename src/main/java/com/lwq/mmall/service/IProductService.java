package com.lwq.mmall.service;

import com.github.pagehelper.PageInfo;
import com.lwq.mmall.common.ServerResponse;
import com.lwq.mmall.pojo.Product;
import com.lwq.mmall.vo.ProductDetailVo;
import com.lwq.mmall.vo.ProductListVo;

/**
 * @Author: Lwq
 * @Date: 2019/3/25 16:06
 * @Version 1.0
 * @Describe
 */
public interface IProductService {
    ServerResponse saveOrUpdateProduct(Product product);

    ServerResponse setSaleStatus(Integer productId, Integer status);

    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductList(Integer pageNum, Integer pageSize);

    ServerResponse<PageInfo> searchProduct(String productName, Integer productId, Integer pageNum, Integer pageSize);

    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductByKeywordCategory(String keyword, Integer categoryId, String orderBy, Integer pageNum, Integer pageSize);

}
