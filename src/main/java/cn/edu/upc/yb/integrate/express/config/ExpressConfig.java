package cn.edu.upc.yb.integrate.express.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by wh980 on 2016/9/7.
 */
@Component
public class ExpressConfig {

    @Value("${yibanoauth.express.APPID}")
    public String appid;

    @Value("${yibanoauth.express.APPkey}")
    public String appkey;
}
