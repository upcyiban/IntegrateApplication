package cn.edu.upc.yb.integrate.lostandfound.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by wanghaojun on 2016/7/12.
 */
@Component
public class LostAndFoundConfig {

    @Value("${yibanoauth.lostandfound.APPID}")
    public String appid;

    @Value("${yibanoauth.lostandfound.APPkey}")
    public String appkey;
}
