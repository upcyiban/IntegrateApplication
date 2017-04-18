package cn.edu.upc.yb.integrate.common;

import cn.edu.upc.yb.integrate.IntegrateApplication;
import cn.edu.upc.yb.integrate.common.dao.AppAdminRepository;
import cn.edu.upc.yb.integrate.common.model.AppAdmin;
import cn.edu.upc.yb.integrate.common.service.AppAdminService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lylllcc on 2017/4/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = IntegrateApplication.class)
@WebAppConfiguration
public class TestAdmin {

    @Autowired
    private AppAdminRepository appAdminRepository;

    @Autowired
    private AppAdminService appAdminService;

    @Test
    @Transactional
    public void addAdmin(){
        AppAdmin appAdmin = new AppAdmin();
        appAdmin.setAppName("test");
        appAdmin.setYbid(5831449);
        appAdminRepository.save(appAdmin);
    }

    @Test
    public void testAdmin(){
        boolean is = appAdminService.isAppAdmin("test",5831449);
        Assert.assertEquals(is,true);
    }
}
