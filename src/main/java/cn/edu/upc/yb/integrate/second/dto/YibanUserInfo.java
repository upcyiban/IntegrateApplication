package cn.edu.upc.yb.integrate.second.dto;

/**
 * Created by Jaxlying on 2016/7/26.
 */
public class YibanUserInfo {
    public String status;
    public Info info;

    public class Info {
        public int yb_userid;
        public String yb_username;
        public String yb_usernick;
        public char yb_sex;
        public String yb_money;
        public String yb_exp;
        public String yb_userhead;
        public String yb_schoolid;
        public String yb_schoolname;
    }
}
