package cn.edu.upc.yb.integrate.common.config;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

/**
 * Created by lylllcc on 2017/4/17.
 */
@Component
public class CommonConfig {

    @PostConstruct
    public void makeimgdir() throws IOException {
        File file = new File("file/img/");

        if(!file.exists()){
            file.mkdirs();
        }
    }
}
