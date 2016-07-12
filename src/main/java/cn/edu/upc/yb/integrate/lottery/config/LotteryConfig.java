package cn.edu.upc.yb.integrate.lottery.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by skyADMIN on 16/7/12.
 */
@Component
public class LotteryConfig {

    @Value("${yibanoauth.lottery.APPID}")
    public String appid;

    @Value("${yibanoauth.lottery.APPkey}")
    public String appkey;

}
