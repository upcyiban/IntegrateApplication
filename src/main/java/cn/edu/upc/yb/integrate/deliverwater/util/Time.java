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
        System.out.println();
        System.out.println(excessTime);
        System.out.println(start);
        System.out.println(System.currentTimeMillis());
        if(excessTime>(20*3600*1000)){
            return true;
        } else{
            return false;
        }
    }

    /**
     * 判断是否在给定的时刻之后
     * @param start   输入时间
     * @param hour     所求时间的小时（24）
     * @param day       所求时间与此刻所差天数
     *
     *@return
     */
    public boolean judgeTime(long start,int hour,int day){
        this.start = start+8*3600*1000;

        long  getTime = System.currentTimeMillis()+ 8*3600*1000+day*24*3600*1000+(24-hour)*3600*1000;


        excessTime = this.start%(24*3600*1000);
        if(excessTime>getTime){

            return true;
        } else{

            return false;
        }

    }
    public String judgeDate(long start){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-mm-dd");
        String sd = simpleDateFormat.format(new Date(start));
        System.out.println(sd);
        return sd;
    }
    public long zeroPoint(){
        long time = System.currentTimeMillis();
        long t1 = time/(24*3600*1000);
        return time - t1;
    }
}
