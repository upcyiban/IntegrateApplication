package cn.edu.upc.yb.integrate.deliciousfood.dto;

import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

/**
 * Created by chenzifeng on 2017/4/23.
 */
public class YBUserDto {

    private String head;
    private String name;

    public YBUserDto(String head, String name) {
        this.head = head;
        this.name = name;
    }

    public YBUserDto() {
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
