package cn.edu.upc.yb.integrate.bulletinboard.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by skyADMIN on 16/7/7.
 */
@Component
public class BulletinBoardOauthConfig {

    @Value("${yibanoauth.bulletinboard.APPID}")
    public String appid;

    @Value("${yibanoauth.bulletinboard.APPkey}")
    public String appkey;

}
