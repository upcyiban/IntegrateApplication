package cn.edu.upc.yb.integrate.deliverwater.model;

/**
 * Created by 陈子枫 on 2016/10/13.
 */
public class Time {
    private long now;
    private long excessTime;

    public boolean judgeTime(){
        now = System.currentTimeMillis()+8*3600*1000;
        excessTime = now%(24*3600*1000);
        if(excessTime>(20*3600*1000)){
            System.out.println("现在是晚上8点以后");
            return true;
        } else{
            System.out.println("现在是晚上8点之前");
            return false;
        }
    }

}
