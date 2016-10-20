package cn.edu.upc.yb.integrate.homepage.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/10/20.
 */
@Component
public class HomePageConfig {
    @Value("${yibanoauth.homepage.APPID}")
    public String appid;
    @Value("${yibanoauth.homepage.APPkey}")
    public String appkey;
}
