package com.lwq.mmall.service;

import com.github.pagehelper.PageInfo;
import com.lwq.mmall.common.ServerResponse;
import com.lwq.mmall.pojo.Shipping;

/**
 * @Author: Lwq
 * @Date: 2019/3/26 20:35
 * @Version 1.0
 * @Describe
 */
public interface IShippingService {

    ServerResponse add(Integer userId, Shipping shipping);

    ServerResponse del(Integer userId, Integer shippingId);

    ServerResponse update(Integer userId, Shipping shipping);

    ServerResponse select(Integer userId, Integer shippingId);

    ServerResponse<PageInfo> list(Integer userId, Integer pageNum, Integer pageSize);
}
