package com.lwq.mmall.service;

import com.lwq.mmall.common.ServerResponse;
import com.lwq.mmall.vo.CartVo;

/**
 * @Author: Lwq
 * @Date: 2019/3/26 16:19
 * @Version 1.0
 * @Describe
 */
public interface ICartService {

    ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);

    ServerResponse<CartVo> update(Integer id, Integer productId, Integer count);

    ServerResponse<CartVo> deleteProduct(Integer userId, String productIds);

    ServerResponse<CartVo> list(Integer userId);

    ServerResponse<CartVo> selectOrUnSelect(Integer userId, Integer checked,Integer productId);

    ServerResponse<Integer> getCartProductCount(Integer userId);
}
