package cn.edu.upc.yb.integrate.deliverwater.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 陈子枫 on 2016/10/13.
 */
public class Time {
    private long start;
    private long now;
    private long excessTime;

    public boolean judgeTime(long start){
        this.start = start+8*3600*1000;
        excessTime = this.start%(24*3600*1000);
        if(excessTime>(20*3600*1000)){
            System.out.println("现在是晚上8点以后");
            return true;
        } else{
            System.out.println("现在是晚上8点之前");
            return false;
        }
    }
    public String judgeDate(long start){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-mm-dd");
        String sd = simpleDateFormat.format(new Date(start));
        System.out.println(sd);
        return sd;
    }

}
