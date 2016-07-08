package cn.edu.upc.yb.integrate.common.auth;

import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.util.MCrypt;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by skyADMIN on 16/7/7.
 */
public class YibanOAuth {

    public Object dealYibanOauth(String verify_request, String appid, String appkey) throws Exception {
        MCrypt mCrypt = new MCrypt(appid, appkey);
        String res = new String(mCrypt.decrypt(verify_request));
        Gson gson = new Gson();
        try {
            YibanBasicUserInfo yibanBasicUserInfo = gson.fromJson(res, YibanBasicUserInfo.class);
            return yibanBasicUserInfo;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ErrorReporter(0, "error parse");
        }
    }

}
