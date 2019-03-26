package com.lwq.mmall.common;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * @Author: Lwq
 * @Date: 2019/3/24 16:34
 * @Version 1.0
 * @Describe
 */
public class Const {

    public static final String CURRENT_USER="currentUser";
    public static final String EMAIL="email";
    public static final String USERNAME="username";

    public interface Role{
        int ROLE_CUSTOMER = 0; //普通用户
        int ROLE_ADMIN = 1;//管理员
    }

    public interface productListOrderBy{
        Set<String> PRICE_ASC_DESC= Sets.newHashSet("price_asc","price_desc");
    }

    public enum productStatusEnum{
        ON_SALE(1,"在售");
        private int code;
        private String value;

        productStatusEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public int getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }
    }
}
