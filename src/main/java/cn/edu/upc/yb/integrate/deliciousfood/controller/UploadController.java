package cn.edu.upc.yb.integrate.deliciousfood.controller;

import cn.edu.upc.yb.integrate.common.dto.ErrorReporter;
import cn.edu.upc.yb.integrate.common.service.CommonAdminService;
import cn.edu.upc.yb.integrate.deliciousfood.dao.VarietyOfDishesDao;
import cn.edu.upc.yb.integrate.deliciousfood.dto.JsonMes;
import cn.edu.upc.yb.integrate.deliciousfood.dto.ResultData;
import cn.edu.upc.yb.integrate.deliciousfood.model.VarietyOfDishes;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created by 陈子枫 on 2017/2/23.
 */
@RestController
@RequestMapping(value = "/upload")
public class UploadController {

    @Autowired
    CommonAdminService commonAdminService;

    @Autowired
    VarietyOfDishesDao varietyOfDishesDao;

    @RequestMapping(value = "/picture", method = RequestMethod.POST)
    @ResponseBody
    public Object photoUpload(MultipartFile file, HttpServletRequest request, HttpServletResponse response, HttpSession session,int id) throws IllegalStateException, IOException {
        ResultData<Object> resultData = new ResultData<>();

        if(!commonAdminService.isCommonAdmin()) return new ErrorReporter(-1,"您没有权限操作");
        VarietyOfDishes varietyOfDishes = varietyOfDishesDao.findOne(id);
        if (file != null) {// 判断上传的文件是否为空
            varietyOfDishes.setPath(null);// 文件路径
            String type = null;// 文件类型
            String fileName = file.getOriginalFilename();// 文件原名称
            System.out.println("上传的文件原名称:" + fileName);
            // 判断文件类型
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            if (type != null) {// 判断文件类型是否为空

                if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath = request.getSession().getServletContext().getRealPath("/");
                    // 自定义的文件名称
                    String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
                    // 设置存放图片文件的路径
                   varietyOfDishes.setPath(realPath +/*System.getProperty("file.separator")+*/trueFileName);
                    System.out.println("存放图片文件的路径:" + varietyOfDishes.getPath());
                    // 转存文件到指定的路径
                    file.transferTo(new File(varietyOfDishes.getPath()));
                    System.out.println("文件成功上传到指定目录下");
                    varietyOfDishesDao.save(varietyOfDishes);

                } else {
                    System.out.println("不是我们想要的文件类型,请按要求重新上传");
                    return new ErrorReporter(-1,"上传失败");

                }

            } else {
                System.out.println("文件类型为空");
                return new ErrorReporter(-1,"文件类型为空");

            }

        } else {
            System.out.println("没有找到相对应的文件");
            return new ErrorReporter(-1,"没有找到相对应的文件");

        }
        return new JsonMes(1,"上传成功" );

    }

}
