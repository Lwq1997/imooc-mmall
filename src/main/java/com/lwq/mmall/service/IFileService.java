package com.lwq.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: Lwq
 * @Date: 2019/3/25 17:56
 * @Version 1.0
 * @Describe
 */
public interface IFileService {

    String upload(MultipartFile file, String path);
}
