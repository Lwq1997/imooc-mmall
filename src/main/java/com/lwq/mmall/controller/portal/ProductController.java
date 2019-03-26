package com.lwq.mmall.controller.portal;

import com.github.pagehelper.PageInfo;
import com.lwq.mmall.common.ServerResponse;
import com.lwq.mmall.service.IProductService;
import com.lwq.mmall.vo.ProductDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Lwq
 * @Date: 2019/3/26 13:06
 * @Version 1.0
 * @Describe
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService iProductService;

    /**
     * 查看商品详情
     * @param productId
     * @return
     */
    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse<ProductDetailVo> detail(Integer productId){
        return iProductService.getProductDetail(productId);
    }

    /**
     * 搜索商品
     * @param categoryId
     * @param keyword
     * @param orderBy
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<PageInfo> list(@RequestParam(value = "categoryId",required = false) Integer categoryId,
                                           @RequestParam(value = "keyword",required = false)String keyword,
                                           @RequestParam(value = "orderBy",defaultValue = "")String orderBy,
                                           @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                                           @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){
        return iProductService.getProductByKeywordCategory(keyword,categoryId,orderBy,pageNum,pageSize);
    }
}
