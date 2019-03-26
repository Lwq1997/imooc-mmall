package com.lwq.mmall.service;

import com.lwq.mmall.common.ServerResponse;
import com.lwq.mmall.pojo.Category;

import java.util.List;

/**
 * @Author: Lwq
 * @Date: 2019/3/25 10:55
 * @Version 1.0
 * @Describe
 */
public interface ICategoryService {

    ServerResponse addCategory(String categoryName, Integer parentId);

    ServerResponse updateCategoryName(Integer categoryId, String categoryName);

    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);

    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);
}
