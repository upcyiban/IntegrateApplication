package cn.edu.upc.yb.integrate.competiton.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by wanghaojun on 2017/4/9.
 */
@Component
public class CompetionConfig {
    @Value("${yibanoauth.competition.APPID}")
    public String appid;

    @Value("${yibanoauth.competition.APPkey}")
    public String appkey;
}
