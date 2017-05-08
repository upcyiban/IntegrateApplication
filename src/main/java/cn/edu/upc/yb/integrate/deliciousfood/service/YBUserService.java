package cn.edu.upc.yb.integrate.deliciousfood.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by chenzifeng on 2017/4/23.
 */
@Service
public class YBUserService {

     public  String getMessage(String access_token,int yb_id) throws IOException {
         String url = "https://openapi.yiban.cn/user/other";
         String charset = "UTF-8";// Or in Java 7 and later, use the constant: java.nio.charset.StandardCharsets.UTF_8.name()

         String query = String.format("access_token=%s",
                 URLEncoder.encode(access_token, charset));
         String query1 = String.format("yb_userid=%s",
                 URLEncoder.encode(String.valueOf(yb_id), charset));
         URLConnection connection = new URL(url + "?" + query + '&' + query1).openConnection();
         InputStream response = connection.getInputStream();
         StringBuilder sb = new StringBuilder();
         BufferedReader br = new BufferedReader(new InputStreamReader(response));
         String read;
         while ((read = br.readLine()) != null) {
             sb.append(read);
         }
         System.out.println(sb.toString());
         br.close();

         return sb.toString();
     }
}
