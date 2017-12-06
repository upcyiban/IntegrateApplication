package cn.edu.upc.yb.integrate.speaktoteacher.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by wanghaojun on 2017/3/29.
 */
@Component
public class SttConfig {

    @Value("${yibanoauth.speaktoteacher.APPID}")
    public String appid;

    @Value("${yibanoauth.speaktoteacher.APPkey}")
    public String appkey;

    public String fronturl = "http://yb.upc.edu.cn/project/speaktoteacher/message.html";
}
