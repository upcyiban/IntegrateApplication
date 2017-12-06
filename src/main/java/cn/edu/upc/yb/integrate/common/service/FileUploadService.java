package cn.edu.upc.yb.integrate.common.service;

import cn.edu.upc.yb.integrate.common.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by lylllcc on 2017/4/17.
 */
@Service
public class FileUploadService {

    private final StorageService storageService;

    @Autowired
    public FileUploadService(StorageService storageService){
        this.storageService = storageService;
    }


    public void store(MultipartFile file, String name){
        storageService.store(file,name);
    }
}
