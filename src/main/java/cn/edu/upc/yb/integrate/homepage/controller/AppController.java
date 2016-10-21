package cn.edu.upc.yb.integrate.homepage.controller;


import cn.edu.upc.yb.integrate.calendar.dto.JsonMes;
import cn.edu.upc.yb.integrate.common.model.CommonAdmin;
import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import cn.edu.upc.yb.integrate.homepage.model.App;
import cn.edu.upc.yb.integrate.homepage.repository.AppRepository;
import cn.edu.upc.yb.integrate.homepage.storage.StorageFileNotFoundException;
import cn.edu.upc.yb.integrate.homepage.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ybdevelop on 2016/10/18.
 */
@RestController
@RequestMapping("/homepage/app")
public class AppController {
    private final StorageService storageService;

    @Autowired
    public CommonAdminService commonAdminService;

    @Autowired
    public AppController(StorageService storageService) {
        this.storageService = storageService;
    }

    @Autowired
    public AppRepository appRepository;

    @GetMapping("/icon/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> showFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                .body(file);
    }

    @GetMapping("/showall")
    public Object showAll(){
        if(commonAdminService.isCommonAdmin()){
            return appRepository.findAll();
        }else{
            return new JsonMes(1,"你还没有登陆或者你不是管理员");
        }
    }

    @PostMapping("/create")
    public Object create(@RequestParam("icon") MultipartFile icon, String name) {
        if(commonAdminService.isCommonAdmin()){
            storageService.store(icon,name);
            App app = new App(name);
            appRepository.save(app);
            return new JsonMes(0,"添加成功");
        }else{
            return new JsonMes(1,"你还没有登陆或者你不是管理员");
        }
    }
    @PostMapping("/update")
    public Object update(Integer id, @RequestParam("file") MultipartFile icon, String name){
        if(commonAdminService.isCommonAdmin()) {
            storageService.store(icon,name);
            App app = appRepository.findOne(id);
            app.update(name);
            appRepository.save(app);
            return new JsonMes(0,"更新成功");
        }else{
            return new JsonMes(1,"你还没有登陆或者你不是管理员");
        }

    }
    @GetMapping("/delete")
    public Object delete(Integer id){
        if(commonAdminService.isCommonAdmin()) {
            appRepository.delete(id);
            return new JsonMes(0,"删除成功");
        }else{
            return new JsonMes(1,"你还没有登陆或者你不是管理员");
        }

    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
