package cn.edu.upc.yb.integrate.common.service;

import cn.edu.upc.yb.integrate.common.dao.CommonAdminDao;
import cn.edu.upc.yb.integrate.common.model.CommonAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by skyADMIN on 16/7/10.
 */
@Service
public class CommonAdminService {

    @Autowired
    private CommonAdminDao commonAdminDao;

    public boolean isCommonAdmin(int Yibanid){
        Collection<CommonAdmin> commonAdmins = (Collection<CommonAdmin>) commonAdminDao.findByYibanid(Yibanid);
        if (commonAdmins.isEmpty()){
            return false;
        }else {
            return true;
        }
    }

}
