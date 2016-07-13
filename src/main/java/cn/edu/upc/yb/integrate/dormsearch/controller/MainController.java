package cn.edu.upc.yb.integrate.dormsearch.controller;

import cn.edu.upc.yb.integrate.dormsearch.model.DormList;
import cn.edu.upc.yb.integrate.dormsearch.dao.DormListDao;
import cn.edu.upc.yb.integrate.dormsearch.dto.ErrorJsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by skyADMIN on 16/6/27.
 */

@RestController
@RequestMapping("/dorm")
public class MainController {

    @Autowired
    private DormListDao dormListDao;

    @RequestMapping("/getdorm")
    public Object getDorm(String name, String number){
        Collection<DormList> dormList = (Collection<DormList>) dormListDao.findByNameAndNumber(name, number);
        if (dormList.isEmpty()){
            return new ErrorJsonMsg(1, "查询结果为空,请确认学号和姓名");
        }else {
            return dormList;
        }
    }

    @RequestMapping("/getroommate")
    public Iterable<DormList> getRoommates(String dormnumber){
        return dormListDao.findByDormnumber(dormnumber);
    }
}
