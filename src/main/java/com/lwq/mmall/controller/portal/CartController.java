package com.lwq.mmall.controller.portal;

import com.lwq.mmall.common.Const;
import com.lwq.mmall.common.ResponseCode;
import com.lwq.mmall.common.ServerResponse;
import com.lwq.mmall.pojo.User;
import com.lwq.mmall.service.ICartService;
import com.lwq.mmall.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author: Lwq
 * @Date: 2019/3/26 16:19
 * @Version 1.0
 * @Describe
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    ICartService iCartService;

    /**
     * 添加商品到购物车
     * @param session
     * @param productId
     * @param count
     * @return
     */
    @RequestMapping("add.do")
    @ResponseBody
    public ServerResponse<CartVo> add(HttpSession session, Integer productId, Integer count){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请先登录");
        }
        return iCartService.add(user.getId(),productId,count);
    }

    /**
     * 更新购物车（商品数量）
     * @param session
     * @param productId
     * @param count
     * @return
     */
    @RequestMapping("update.do")
    @ResponseBody
    public ServerResponse<CartVo> update(HttpSession session, Integer productId, Integer count){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请先登录");
        }
        return iCartService.update(user.getId(),productId,count);
    }

    /**
     * 删除商品
     * @param session
     * @param productIds
     * @return
     */
    @RequestMapping("delete_product.do")
    @ResponseBody
    public ServerResponse<CartVo> deleteProduct(HttpSession session,String productIds){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请先登录");
        }
        return iCartService.deleteProduct(user.getId(),productIds);
    }

    /**
     * 查询当前用户的购物车
     * @param session
     * @return
     */
    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<CartVo> list(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请先登录");
        }
        return iCartService.list(user.getId());
    }

    /**
     * 全选
     * @param session
     * @return
     */
    @RequestMapping("select_all.do")
    @ResponseBody
    public ServerResponse<CartVo> selectAll(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请先登录");
        }
        return iCartService.selectOrUnSelect(user.getId(),Const.Cart.CHECKED,null);
    }

    /**
     * 取消全选
     * @param session
     * @return
     */
    @RequestMapping("un_select_all.do")
    @ResponseBody
    public ServerResponse<CartVo> unSelectAll(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请先登录");
        }
        return iCartService.selectOrUnSelect(user.getId(),Const.Cart.UN_CHECKED,null);
    }

    /**
     * 单选某个产品
     * @param session
     * @param productId
     * @return
     */
    @RequestMapping("select.do")
    @ResponseBody
    public ServerResponse<CartVo> select(HttpSession session,Integer productId){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请先登录");
        }
        return iCartService.selectOrUnSelect(user.getId(),Const.Cart.CHECKED,productId);
    }

    /**
     * 取消单选某个产品
     * @param session
     * @param productId
     * @return
     */
    @RequestMapping("un_select.do")
    @ResponseBody
    public ServerResponse<CartVo> unSelect(HttpSession session,Integer productId){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请先登录");
        }
        return iCartService.selectOrUnSelect(user.getId(),Const.Cart.UN_CHECKED,productId);
    }

    /**
     * 计算购物车中的商品总数
     * @param session
     * @return
     */
    @RequestMapping("get_cart_product_count.do")
    @ResponseBody
    public ServerResponse<Integer> getCartProductCount(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createBySuccess(0);
        }
        return iCartService.getCartProductCount(user.getId());
    }
}
