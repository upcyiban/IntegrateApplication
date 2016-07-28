package cn.edu.upc.yb.integrate.second.controller;

import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import cn.edu.upc.yb.integrate.second.dto.JsonMes;
import cn.edu.upc.yb.integrate.second.model.Publish;
import cn.edu.upc.yb.integrate.second.repository.PublishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jaxlying on 2016/7/26.
 */
@RestController
@RequestMapping("/second/admin")
public class AdminController {

    @Autowired
    private PublishRepository publishRepository;

    @Autowired
    private CommonAdminService commonAdminService;

    @RequestMapping("/findall")
    public Object findAll(){
        if (commonAdminService.isCommonAdmin() == false) return new JsonMes(-1, "您没有权限操作");
        return publishRepository.findByIsdelete(false);
    }

    @RequestMapping("/delete")
    public Object delete(int id){
        if (commonAdminService.isCommonAdmin() == false) return new JsonMes(-1, "您没有权限操作");
        Publish publish = publishRepository.findOne(id);
        publish.delete();
        publishRepository.save(publish);
        return new JsonMes(1,"删除成功");

    }
}
