package cn.edu.upc.yb.integrate.express.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by 陈子枫 on 2016/10/28.
 */
@Service
public class GetPay {

    @Autowired
    HttpSession httpSession;



    public String getMessage(String access_token, String yb_wx) throws IOException {
        String url = "https://openapi.yiban.cn/pay/yb_wx";
        String charset = "UTF-8";// Or in Java 7 and later, use the constant: java.nio.charset.StandardCharsets.UTF_8.name()

        String query = String.format("access_token=%s",
                URLEncoder.encode(access_token, charset));
        String query1 = String.format("pay=%s",
                URLEncoder.encode(yb_wx, charset));
        URLConnection connection = new URL(url + "?" + query + '&' + query1).openConnection();
        InputStream response = connection.getInputStream();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(response));
        String read;
        while ((read = br.readLine()) != null) {
            sb.append(read);
        }

        br.close();

        return sb.toString();


    }
}
