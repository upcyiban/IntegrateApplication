package cn.edu.upc.yb.integrate.common.service;

import cn.edu.upc.yb.integrate.common.dao.AppAdminRepository;
import cn.edu.upc.yb.integrate.common.model.AppAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by lylllcc on 2017/4/2.
 */
@Service
public class AppAdminService {

    @Autowired
    private AppAdminRepository appAdminRepository;

    public boolean isAppAdmin(String appName,int ybid){
        Collection<AppAdmin> admins = appAdminRepository.findByAppNameAndYbid(appName,ybid);
        if(admins.isEmpty() == true)
            return false;
        return true;
    }
}
