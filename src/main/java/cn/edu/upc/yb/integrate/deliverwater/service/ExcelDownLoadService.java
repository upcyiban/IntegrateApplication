package cn.edu.upc.yb.integrate.deliverwater.service;

import cn.edu.upc.yb.integrate.calendar.dto.JsonMes;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jaxlying on 2016/10/17.
 */
@Service
public class ExcelDownLoadService {
    public Object getAllFile(){
        File dir = new File("deliverwater");
        if(!dir.exists()){
            System.out.println("文件夹不存在");
            return new JsonMes(-1,"文件夹不存在");
        }
        LinkedList<File> fileList = new LinkedList<>();
        File[] files = dir.listFiles();
        for (File file2 : files) {
            fileList.add(file2);
        }
        List<String> filelists = new ArrayList<>();
        for (File file2:fileList
                ) {
            filelists.add(file2.getPath());
        }
        return filelists;
    }
}
