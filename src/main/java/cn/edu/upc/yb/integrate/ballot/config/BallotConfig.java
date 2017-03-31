package cn.edu.upc.yb.integrate.ballot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Jaxlying on 2016/11/29.
 */
@Component
public class BallotConfig {

    @Value("${yibanoauth.ballot.APPID}")
    public String appid;

    @Value("${yibanoauth.ballot.APPkey}")
    public String appkey;

    public String appurl = "";

    public String fronturl = "http://yb.upc.edu.cn/project/ballot/%23/get";

}
