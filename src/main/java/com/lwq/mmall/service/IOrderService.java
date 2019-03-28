package com.lwq.mmall.service;

import com.github.pagehelper.PageInfo;
import com.lwq.mmall.common.ServerResponse;
import com.lwq.mmall.vo.OrderVo;

import java.util.Map;

/**
 * @Author: Lwq
 * @Date: 2019/3/27 15:51
 * @Version 1.0
 * @Describe
 */
public interface IOrderService {
    ServerResponse pay(Integer userId, Long orderNo, String path);

    ServerResponse aliCallback(Map<String,String> params);

    ServerResponse<Boolean> queryOrderPayStatus(Integer userId, Long orderNo);

    ServerResponse createOrder(Integer userId, Integer shippingId);

    ServerResponse<String> cancel(Integer userId, Long orderNo);

    ServerResponse getOrderCartProduct(Integer userId);

    ServerResponse<OrderVo> getOrderDetail(Integer userId, Long orderNo);

    ServerResponse<PageInfo> getOrderList(Integer userId, int pageNum, int pageSize);

    ServerResponse<PageInfo> manageList(Integer pageNum, Integer pageSize);

    ServerResponse<OrderVo> manageDetail(Long orderNo);

    ServerResponse<PageInfo> manageSearch(Long orderNo, Integer pageNum, Integer pageSize);

    ServerResponse<String> manageSendGoods(Long orderNo);
}
