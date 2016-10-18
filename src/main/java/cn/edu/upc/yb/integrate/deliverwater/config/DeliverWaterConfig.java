package cn.edu.upc.yb.integrate.deliverwater.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by 陈子枫 on 2016/10/14.
 */
@Component
public class DeliverWaterConfig {

    @Value("${yibanoauth.deliverwater.APPID}")
    public String appid;

    @Value("${yibanoauth.deliverwater.APPkey}")
    public String appkey;


}

