package cn.edu.upc.yb.integrate.InstructorEvaluate.controller;

import cn.edu.upc.yb.integrate.InstructorEvaluate.service.InstructorService;
import cn.edu.upc.yb.integrate.common.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by lhy95 on 2017/4/26.
 */
@RestController
@RequestMapping("/instructor")
public class InstructorController {

    private final InstructorService instructorService;
    private final StorageService storageService;

    @Autowired
    public InstructorController(InstructorService instructorService, StorageService storageService) {
        this.instructorService = instructorService;
        this.storageService = storageService;
    }

    @RequestMapping("/getInstructor")
    public HashMap<String, Object> getInstructor() {
        return instructorService.getAllInstructor();
    }

    @PostMapping("/uploadInstructor")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = "instructor" + new Date().getTime();
        storageService.store(file, fileName);
        instructorService.importDataFromExcel(fileName);
        return "0";
    }
}
