package com.product.service;

import com.product.model.MyFile;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
     MyFile saveFile(MultipartFile multipartFile, int pid);
     MyFile findFile(int pid);
}
