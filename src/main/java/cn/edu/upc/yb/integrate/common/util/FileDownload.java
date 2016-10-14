package cn.edu.upc.yb.integrate.common.util;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Jaxlying on 2016/10/14.
 */
public class FileDownload {

    public void fileDownload(HttpServletResponse response,String downloadName,String filePath) throws FileNotFoundException {
        String fileName = downloadName;
        InputStream inStream = new FileInputStream(filePath);
        response.reset();
        response.setContentType("bin");
        response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        byte[] b = new byte[100];
        int len;
        try {
            while ((len = inStream.read(b)) > 0)
                response.getOutputStream().write(b, 0, len);
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

