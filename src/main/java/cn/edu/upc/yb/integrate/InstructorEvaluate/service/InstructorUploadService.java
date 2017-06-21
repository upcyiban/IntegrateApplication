package cn.edu.upc.yb.integrate.InstructorEvaluate.service;

import cn.edu.upc.yb.integrate.InstructorEvaluate.dao.InstructorDao;
import cn.edu.upc.yb.integrate.InstructorEvaluate.dao.RecordDao;
import cn.edu.upc.yb.integrate.InstructorEvaluate.dao.StudentDao;
import cn.edu.upc.yb.integrate.InstructorEvaluate.model.Instructor;
import cn.edu.upc.yb.integrate.InstructorEvaluate.model.Student;
import cn.edu.upc.yb.integrate.common.storage.StorageService;
import cn.edu.upc.yb.integrate.common.util.JsonWebToken;
import io.jsonwebtoken.Claims;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lhy95 on 2017/6/20.
 */
@Service
public class InstructorUploadService {

    private final InstructorDao instructorDao;
    private final JsonWebToken jsonWebToken;
    private final RecordDao recordDao;
    private final StorageService storageService;
    private final StudentDao studentDao;

    @Autowired
    public InstructorUploadService(InstructorDao instructorDao, JsonWebToken jsonWebToken, RecordDao recordDao, StorageService storageService, StudentDao studentDao) {
        this.instructorDao = instructorDao;
        this.jsonWebToken = jsonWebToken;
        this.recordDao = recordDao;
        this.storageService = storageService;
        this.studentDao = studentDao;
    }

    // 存储上传的excel表
    private String storeExcelFile(MultipartFile file) {
        String fileName = "instructor" + new Date().getTime();
        storageService.store(file, fileName);
        return fileName;
    }

    // 从excel文件里导入数据到数据库然后删除文件
    public Map<String, Serializable> importDataFromExcel(MultipartFile file, String token) throws IOException {
        // 用来返回结果
        HashMap<String, Serializable> rs = new HashMap<String, java.io.Serializable>();

        // 鉴权
        if (!isAdmin(token)) {
            rs.put("status", 0);
            rs.put("errorMsg", "身份异常");
            return rs;
        }

        // 存储excel文件，获取其文件名
        String fileName = storeExcelFile(file);

        // 导入新数据就清除旧数据
        instructorDao.deleteAll();

        // 获取excel文件
        File tempFile = new File("file/img/" + fileName);
        Workbook wb = new HSSFWorkbook(new FileInputStream(tempFile));

        // 读取excel中的有效信息，以数组返回给instructors并存进数据库
        Iterable<Instructor> instructors = readExcelValue(wb);
        instructorDao.save(instructors);

        //删除上传的临时文件
        if (tempFile.exists()) {
            tempFile.delete();
        }

        rs.put("status", 0);
        return rs;
    }

    // 读取excel文件，返回辅导员集合
    private Iterable<Instructor> readExcelValue(Workbook wb) {
        ArrayList<Instructor> instructors = new ArrayList<Instructor>();

        // 获取默认的表格
        Sheet sheet = wb.getSheet("Sheet1");

        int rowNumber = sheet.getPhysicalNumberOfRows();

        DataFormatter formatter = new DataFormatter();

        for (int i = 1; i < rowNumber; i++) {
            Instructor instructor = new Instructor();
            Cell cell = sheet.getRow(i).getCell(0);
            instructor.setAcademy(formatter.formatCellValue(cell));
            cell = sheet.getRow(i).getCell(1);
            instructor.setNumber(formatter.formatCellValue(cell));
            cell = sheet.getRow(i).getCell(2);
            instructor.setName(formatter.formatCellValue(cell));
            instructors.add(instructor);
        }

        return instructors;
    }

    private Boolean isAdmin(String token) {
        Claims claims = jsonWebToken.getClaimsFromToken(token);
        if (claims != null) {
            if (claims.get("role").equals("admin")) {
                return true;
            }
        }
        return false;
    }

    public Map importStudentDataFromExcel(MultipartFile file, String token) throws IOException {
        // 用来返回结果
        HashMap<String, Serializable> rs = new HashMap<String, java.io.Serializable>();

        // 鉴权
        if (!isAdmin(token)) {
            rs.put("status", 0);
            rs.put("errorMsg", "身份异常");
            return rs;
        }

        // 存储excel文件，获取其文件名
        String fileName = storeExcelFile(file);

        // 导入新数据就清除旧数据
        studentDao.deleteAll();

        // 获取excel文件
        File tempFile = new File("file/img/" + fileName);
        Workbook wb = new HSSFWorkbook(new FileInputStream(tempFile));

        // 读取excel中的有效信息，以数组返回给instructors并存进数据库
        Iterable<Student> students = readStudentExcelValue(wb);
        studentDao.save(students);

        //删除上传的临时文件
        if (tempFile.exists()) {
            tempFile.delete();
        }

        rs.put("status", 0);
        return rs;
    }

    // 读取学生表excel文件，返回学生集合
    private Iterable<Student> readStudentExcelValue(Workbook wb) {
        ArrayList<Student> students = new ArrayList<Student>();

        // 获取默认的表格
        Sheet sheet = wb.getSheet("Sheet1");

        int rowNumber = sheet.getPhysicalNumberOfRows();

        DataFormatter formatter = new DataFormatter();

        for (int i = 1; i < rowNumber; i++) {
            Student student = new Student();
            Cell cell = sheet.getRow(i).getCell(0);
            // todo: 学生信息读入
//            student.setAcademy(formatter.formatCellValue(cell));


            students.add(student);
        }

        return students;
    }
}
