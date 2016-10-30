package cn.edu.upc.yb.integrate.express.controller;

import cn.edu.upc.yb.integrate.express.dto.JsonMes;
import cn.edu.upc.yb.integrate.express.service.GetPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by wh980 on 2016/9/7.
 */
@RestController
@RequestMapping("/express")
public class ExpressCourierController {

    @Autowired
    HttpSession httpSession;

    @RequestMapping(value = "/pay",method = RequestMethod.GET)
    public Object pay(String acess_token, String yb_wx)  {
        //String acess_token = (String) httpSession.getAttribute("acess_token");
        GetPay getPay = new GetPay();
        try{
            getPay.getMessage(acess_token,yb_wx);
        }catch (IOException e){
            System.out.println(e.toString());
            System.out.println("出问题");
            return  new JsonMes(-1,"支付失败");
        }finally {

            return new JsonMes(1,"支付成功");
        }


    }

}
