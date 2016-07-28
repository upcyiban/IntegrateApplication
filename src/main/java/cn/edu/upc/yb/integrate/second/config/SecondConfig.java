package cn.edu.upc.yb.integrate.second.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Jaxlying on 2016/7/28.
 */

@Component
public class SecondConfig {

    @Value("${yibanoauth.second.APPID}")
    public String appid;

    @Value("${yibanoauth.second.APPkey}")
    public String appkey;

    @Value("${yibanoauth.second.frontend}")
    public String fontend;

    @Value("${yibanoauth.second.imgserver}")
    public String imgserver;


}

