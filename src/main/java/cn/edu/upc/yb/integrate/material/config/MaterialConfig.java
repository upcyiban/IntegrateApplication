package cn.edu.upc.yb.integrate.material.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by wanghaojun on 2017/2/16.
 */
@Component
public class MaterialConfig {

    @Value("${yibanoauth.material.APPID}")
    public String appid;

    @Value("${yibanoauth.material.APPkey}")
    public String appkey;
}
