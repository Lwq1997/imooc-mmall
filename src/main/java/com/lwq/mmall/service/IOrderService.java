package com.lwq.mmall.service;

import com.lwq.mmall.common.ServerResponse;

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
}
