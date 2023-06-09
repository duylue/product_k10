package com.product.service.impl;

import com.product.model.MyFile;
import com.product.repo.FileRepo;
import com.product.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileServiceImpl implements FileService {
    private final FileRepo fileRepo;

    public FileServiceImpl(FileRepo fileRepo) {
        this.fileRepo = fileRepo;
    }

    @Override
    public MyFile saveFile(MultipartFile multipartFile ,int pid) {
        MyFile myFile = new MyFile();
        myFile.setFname(multipartFile.getOriginalFilename());
        try {
            myFile.setContent(multipartFile.getBytes());
            myFile.setCtype(multipartFile.getContentType());
            myFile.setPid(pid);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return fileRepo.save(myFile);
    }

    @Override
    public MyFile findFile(int pid) {
        return fileRepo.findById(pid).get();
    }
}
