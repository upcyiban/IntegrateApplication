package cn.edu.upc.yb.integrate.InstructorEvaluate.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by lhy95 on 2017/4/30.
 */
@Component
public class InstructorConfig {

    @Value("${yibanoauth.instructor.APPID}")
    public String appid;

    @Value("${yibanoauth.instructor.APPkey}")
    public String appkey;
}
