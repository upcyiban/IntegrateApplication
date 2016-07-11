package cn.edu.upc.yb.integrate.common.auth;

import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.common.util.MCrypt;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by skyADMIN on 16/7/7.
 */
@Service
public class YibanOAuth {

    @Autowired
    private HttpSession httpSession;

    public Object dealYibanOauth(String verify_request, String appid, String appkey) {
        MCrypt mCrypt = new MCrypt(appid, appkey);
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
            return yibanBasicUserInfo;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ErrorReporter(0, "error parse");
        }
    }

}
