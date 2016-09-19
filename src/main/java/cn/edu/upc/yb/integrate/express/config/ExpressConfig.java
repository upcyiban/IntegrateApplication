package cn.edu.upc.yb.integrate.express.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by wh980 on 2016/9/7.
 */
public class ExpressConfig {

    @Value("${yibanoauth.express.APPID}")
    public String appid;

    @Value("${yibanoauth.express.APPkey}")
    public String appkey;
}
