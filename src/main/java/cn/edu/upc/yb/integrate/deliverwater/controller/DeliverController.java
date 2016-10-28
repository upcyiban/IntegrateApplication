package cn.edu.upc.yb.integrate.deliverwater.controller;


import cn.edu.upc.yb.integrate.common.dao.CommonAdminDao;
import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.common.dto.YibanBasicUserInfo;
import cn.edu.upc.yb.integrate.common.model.CommonAdmin;
import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import cn.edu.upc.yb.integrate.common.util.FileDownload;
import cn.edu.upc.yb.integrate.deliverwater.dao.DeliverWaterDao;
import cn.edu.upc.yb.integrate.deliverwater.dto.JsonMes;
import cn.edu.upc.yb.integrate.deliverwater.model.DeliverWater;
import cn.edu.upc.yb.integrate.deliverwater.service.ExcelDownLoadService;
import cn.edu.upc.yb.integrate.deliverwater.service.WriteExcelService;
import cn.edu.upc.yb.integrate.deliverwater.util.TelePhone;
import cn.edu.upc.yb.integrate.deliverwater.util.Time;
import org.apache.poi.hssf.record.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by 陈子枫 on 2016/9/29.
 */
@RestController
@RequestMapping("/deliverwater")
public class DeliverController {
    @Autowired
    DeliverWaterDao userDao;

    @Autowired
    private CommonAdminService commonAdminService;

    @Autowired
    HttpSession httpSession;

    @Autowired
    DeliverWaterDao deliverWaterDao;

    @Autowired
    WriteExcelService writeExcelService;

    @Autowired
    private ExcelDownLoadService excelDownLoadService;


    /*
    *给用户的接口，让用户填信息
    */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object create(String blockNumber, String dormitory, String name, String phone, @RequestParam(value = "num", defaultValue = "1") int num, @RequestParam(value = "ticket", defaultValue = "0") int ticket) {
        YibanBasicUserInfo yibanBasicUserInfo = (YibanBasicUserInfo) httpSession.getAttribute("user");
        int yibanid = yibanBasicUserInfo.visit_user.userid;
        String yibanName = yibanBasicUserInfo.visit_user.username;
        if (num<0||ticket<0){
            return new JsonMes(-1,"订购数量有误");
        }
        if (!TelePhone.isCellPhone(phone)) {
            return new JsonMes(-1, "你的电话号码有误");
        }
        DeliverWater deliverWater = new DeliverWater(yibanid, yibanName, blockNumber, dormitory, num, ticket);
        System.out.println("yibanId:" + yibanid);
        System.out.println("name:" + yibanName);
        System.out.println("domitory: " + dormitory);
        userDao.save(deliverWater);
        return new JsonMes(1, "提交成功");

    }


    public boolean print() throws IOException {
        Iterable<DeliverWater> iterable = deliverWaterDao.findByIsdealOrderByBlockNumber(false);
        Iterator<DeliverWater> iterator = iterable.iterator();
        Time time = new Time();

        long now = System.currentTimeMillis();
        System.out.println(now);
        if (!time.judgeTime(now)) {
            writeExcelService.writeExcel(iterator);
            return true;
        } else {
            return false;
        }

    }

    @RequestMapping("/showfilelist")
    public Object showFileList() throws IOException {
        this.print();
        return excelDownLoadService.getAllFile();
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public Object download(HttpServletResponse response, String filename) throws FileNotFoundException {
        if (commonAdminService.isCommonAdmin() == false) return new ErrorReporter(-1, "您没有权限操作");
        File file = new File(filename);
        FileDownload fileDownload = new FileDownload();
        try {
            fileDownload.fileDownload(response, file.getName(), file.getPath());
        } catch (Exception e) {
            System.out.println(e.toString());
            return new JsonMes(-1, "出现异常");
        }
        return new JsonMes(1, "文件打印成功");
    }
}
