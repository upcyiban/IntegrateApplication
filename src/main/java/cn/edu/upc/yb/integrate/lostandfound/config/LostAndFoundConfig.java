package cn.edu.upc.yb.integrate.lostandfound.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by yyljj on 2016/5/21.
 */

@Component
public class LostAndFoundConfig {
    @Value("${yibanoauth.lostandfound.APPID}")
    public  String client_id;

    @Value("${yibanoauth.lostandfound.APPkey}")
    public  String AppSecret;

}
