package cn.edu.upc.yb.integrate.common.service;

import cn.edu.upc.yb.integrate.common.dao.CommonAdminDao;
import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.common.model.CommonAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * Created by skyADMIN on 16/7/10.
 */
@Service
public class CommonAdminService {

    @Autowired
    private CommonAdminDao commonAdminDao;

    @Autowired
    private HttpSession httpSession;

    public boolean isCommonAdmin(){
        if (httpSession.getAttribute("user") == null){
            return false;
        }
        YibanBasicUserInfo user = (YibanBasicUserInfo)httpSession.getAttribute("user");
        int Yibanid = user.visit_user.userid;
        Collection<CommonAdmin> commonAdmins = (Collection<CommonAdmin>) commonAdminDao.findByYibanid(Yibanid);
        if (commonAdmins.isEmpty()){
            return false;
        }else {
            return true;
        }
    }

}
