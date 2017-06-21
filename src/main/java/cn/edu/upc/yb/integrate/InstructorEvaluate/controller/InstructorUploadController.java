package cn.edu.upc.yb.integrate.InstructorEvaluate.controller;

import cn.edu.upc.yb.integrate.InstructorEvaluate.service.InstructorService;
import cn.edu.upc.yb.integrate.InstructorEvaluate.service.InstructorUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * Created by lhy95 on 2017/4/26.
 */
@RestController
@RequestMapping("/instructor")
public class InstructorUploadController {

    private final InstructorUploadService instructorUploadService;

    @Autowired
    public InstructorUploadController(InstructorService instructorService, InstructorUploadService instructorUploadService) {
        this.instructorUploadService = instructorUploadService;
    }

    @PostMapping("/uploadStudent")
    public Map handleStudentUpload(@RequestParam("file") MultipartFile file, String token) {
        return instructorUploadService.importStudentDataFromExcel(file, token);
    }

    @PostMapping("/uploadInstructor")
    public Map handleFileUpload(@RequestParam("file") MultipartFile file, String token) throws IOException {
        return instructorUploadService.importDataFromExcel(file, token);
    }
}
