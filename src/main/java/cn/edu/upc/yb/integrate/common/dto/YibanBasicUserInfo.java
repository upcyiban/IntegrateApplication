package cn.edu.upc.yb.integrate.common.dto;

/**
 * Created by skyADMIN on 16/7/8.
 */
public class YibanBasicUserInfo {
    public int visit_time;
    public VisitUser visit_user;
    public VisitOauth visit_oauth;
    public class VisitUser{
        public int userid;
        public String username;
        public String usernick;
        public char usersex;
    }

    public class VisitOauth{
        public String access_token;
        public int token_expires;
    }
}
