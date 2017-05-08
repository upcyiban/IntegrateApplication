package cn.edu.upc.yb.integrate.common.auth;

import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.common.util.MCrypt;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by skyADMIN on 16/7/7.
 */
@Service
public class YibanOAuth {

    @Autowired
    private HttpSession httpSession;

    public Object dealYibanOauth(String verify_request, String appid, String appkey) {
        MCrypt mCrypt = new MCrypt(appid, appkey);
        System.out.println("Auth");
        String res = null;
        try {
            res = new String(mCrypt.decrypt(verify_request));
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorReporter(0, "error parse");
        }
        Gson gson = new Gson();
        try {
            YibanBasicUserInfo yibanBasicUserInfo = gson.fromJson(res, YibanBasicUserInfo.class);
            httpSession.setAttribute("user", yibanBasicUserInfo);
            System.out.println("授权成功");
            return yibanBasicUserInfo;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ErrorReporter(0, "error parse");
        }
    }

    public int isAuth(){
        if (httpSession.getAttribute("user")!=null){
            return 1;
        }else {
            return 0;
        }
    }

    public Map dealYibanToken(String verify_request, String appid, String appkey) {
        Map rs = new HashMap();

        MCrypt mCrypt = new MCrypt(appid, appkey);
        String res;
        try {
            res = new String(mCrypt.decrypt(verify_request));
        } catch (Exception e) {
            e.printStackTrace();
            rs.put("status", 1);
            rs.put("errorMsg", "解析Token过程有问题");
            return rs;
        }
        Gson gson = new Gson();
        try {
            Map tokenMap = gson.fromJson(res, Map.class);
            rs.put("status", 0);
            rs.put("data", tokenMap);
            return rs;
        } catch (Exception ex) {
            ex.printStackTrace();
            rs.put("status", 1);
            rs.put("errorMsg", "解析Token过程有问题");
            return rs;
        }
    }
}
