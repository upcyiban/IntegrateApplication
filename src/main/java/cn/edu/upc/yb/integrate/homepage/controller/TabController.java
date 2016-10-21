package cn.edu.upc.yb.integrate.homepage.controller;

import cn.edu.upc.yb.integrate.calendar.dto.JsonMes;
import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import cn.edu.upc.yb.integrate.homepage.model.Tab;
import cn.edu.upc.yb.integrate.homepage.repository.TabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ybdevelop on 2016/10/18.
 */
@RestController
@RequestMapping("homepage/tab")
public class TabController {
    @Autowired
    TabRepository tabRepository;

    @Autowired
    CommonAdminService commonAdminService;

    @GetMapping("/showall")
    public Object showAll(){
        if(commonAdminService.isCommonAdmin()){
            return tabRepository.findAll();
        }else{
            return new JsonMes(1,"你还没有登陆或者你不是管理员");
        }
    }

    @GetMapping("/create")
    public Object create(String name, String href){
        if(commonAdminService.isCommonAdmin()){
            Tab tab = new Tab(name,href);
            tabRepository.save(tab);
            return new JsonMes(0,"保存成功");
        }else{
            return new JsonMes(1,"你还没有登陆或者你不是管理员");
        }

    }

    @GetMapping("/update")
    public Object update(Integer id, String name, String href){
        if(commonAdminService.isCommonAdmin()){
            Tab tab = tabRepository.findOne(id);
            tab.update(name,href);
            tabRepository.save(tab);
            return new JsonMes(0,"更新成功");
        }else{
            return new JsonMes(1,"你还没有登陆或者你不是管理员");
        }
    }

    @GetMapping("/delete")
    public Object delete(Integer id){
        if(commonAdminService.isCommonAdmin()){
            tabRepository.delete(id);
            return new JsonMes(0,"删除成功");
        }else{
            return new JsonMes(1,"你还没有登陆或者你不是管理员");
        }
    }


}
