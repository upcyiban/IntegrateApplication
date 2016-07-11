package cn.edu.upc.yb.integrate.calendar.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Jaxlying on 2016/7/10.
 */
@Component
public class CalendarConfig {

    @Value("${yibanoauth.calendar.APPID}")
    public String appid;

    @Value("${yibanoauth.calendar.APPkey}")
    public String appkey;


}
