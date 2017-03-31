package cn.edu.upc.yb.integrate.contact.controller;

import cn.edu.upc.yb.integrate.contact.repository.ContactsJobRepository;
import cn.edu.upc.yb.integrate.contact.repository.ContactsUnitRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2017/3/25.
 */
@RestController
@RequestMapping(value = "/contacts")
public class ContactsController {

    @Autowired
    ContactsJobRepository contactJobRepository;

    @Autowired
    ContactsUnitRepository contactsUnitRepository;


    @RequestMapping(value = "/showunit",method = RequestMethod.GET)
    public Object showUnit(){
        return contactsUnitRepository.findAll();
    }

    @RequestMapping(value = "/showjob",method = RequestMethod.GET)
    public Object showJob(int unitid){
        return contactJobRepository.findByContactsUnitId(unitid);
    }
    @RequestMapping(value = "/findjob",method = RequestMethod.GET)
    public Object findJob(String name){
        return contactJobRepository.findByName(name);
    }
}
