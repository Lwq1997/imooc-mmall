package com.lwq.mmall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.lwq.mmall.common.ServerResponse;
import com.lwq.mmall.dao.ShippingMapper;
import com.lwq.mmall.pojo.Shipping;
import com.lwq.mmall.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: Lwq
 * @Date: 2019/3/26 20:36
 * @Version 1.0
 * @Describe
 */
@Service("iShippingService")
public class ShippingServiceImpl implements IShippingService {

    @Autowired
    ShippingMapper shippingMapper;

    @Override
    public ServerResponse add(Integer userId, Shipping shipping) {
        shipping.setUserId(userId);
        int resultCount = shippingMapper.insert(shipping);
        if(resultCount > 0){
            Map<String,Integer> map = Maps.newHashMap();
            map.put("shipping",shipping.getId());
            return ServerResponse.createBySuccess("添加地址成功",map);
        }
        return ServerResponse.createByErrorMessage("添加地址失败");
    }

    @Override
    public ServerResponse del(Integer userId, Integer shippingId) {
        int resultCount = shippingMapper.deleteByShippingIdUserId(userId,shippingId);
        if(resultCount > 0){
            return ServerResponse.createBySuccess("删除地址成功");
        }
        return ServerResponse.createByErrorMessage("删除地址失败");
    }

    @Override
    public ServerResponse update(Integer userId, Shipping shipping) {
        shipping.setUserId(userId);
        int resultCount = shippingMapper.updateByShipping(shipping);
        if(resultCount > 0){
            return ServerResponse.createBySuccess("更新地址成功");
        }
        return ServerResponse.createByErrorMessage("更新地址失败");
    }

    @Override
    public ServerResponse select(Integer userId, Integer shippingId) {
        Shipping shipping = shippingMapper.selectByShippingIdUserId(userId,shippingId);
        if(shipping==null){
            return ServerResponse.createByErrorMessage("无法查询到该地址");
        }
        return ServerResponse.createBySuccess("更新地址成功",shipping);
    }

    @Override
    public ServerResponse<PageInfo> list(Integer userId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Shipping> shippingList = shippingMapper.selectByUserId(userId);
        PageInfo pageInfo = new PageInfo(shippingList);
        return ServerResponse.createBySuccess(pageInfo);
    }
}
