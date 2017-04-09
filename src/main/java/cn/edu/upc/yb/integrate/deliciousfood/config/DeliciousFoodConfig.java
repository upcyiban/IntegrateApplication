package cn.edu.upc.yb.integrate.deliciousfood.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by 陈子枫 on 2017/2/20.
 */
@Component
public class DeliciousFoodConfig {
    @Value("${yibanoauth.deliciousfood.APPID}")
    public String appid;

    @Value("${yibanoauth.deliciousfood.APPkey}")
    public String appkey;
}
