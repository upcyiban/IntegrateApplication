package cn.edu.upc.yb.integrate.contact.controller;

import cn.edu.upc.yb.integrate.deliciousfood.dto.JsonMes;
import cn.edu.upc.yb.integrate.contact.model.ContactsUnit;
import cn.edu.upc.yb.integrate.contact.repository.ContactJobRepository;
import cn.edu.upc.yb.integrate.contact.repository.ContactsUnitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2017/3/25.
 */
@RestController
@RequestMapping("/contacts")
public class ContactsOfficeController {

    @Autowired
    private ContactsUnitRepository contactsUnitRepository;

    @Autowired
    private ContactJobRepository contactJobRepository;

    @RequestMapping(value = "/createunit",method = RequestMethod.GET)
    public Object createUnit(String name)
    {
        ContactsUnit contactsUnit=new ContactsUnit(name);
        contactsUnitRepository.save(contactsUnit);
        return new JsonMes(1,"创建部门成功");
    }

    @RequestMapping(value = "/createjob",method = RequestMethod.GET)
    public Object cteateJob(String name,String number,int unitid)
    {
        ContactJobRepository contactJobRepository=new 
    }
}

