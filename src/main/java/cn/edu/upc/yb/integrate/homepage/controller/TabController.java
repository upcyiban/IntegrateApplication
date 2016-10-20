package cn.edu.upc.yb.integrate.homepage.controller;

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

    @GetMapping("/showall")
    public Object showAll(){
        return tabRepository.findAll();
    }

    @GetMapping("/create")
    public Object create(String name, String href){
        Tab tab = new Tab(name,href);
        tabRepository.save(tab);
        return "保存成功";
    }

    @GetMapping("/update")
    public Object update(Integer id, String name, String href){
        Tab tab = tabRepository.findOne(id);
        tab.update(name,href);
        tabRepository.save(tab);
        return "更新成功";
    }

    @GetMapping("/delete")
    public Object delete(Integer id){
        tabRepository.delete(id);
        return "删除成功";
    }


}
