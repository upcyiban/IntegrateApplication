package cn.edu.upc.yb.integrate.second.controller;

import cn.edu.upc.yb.integrate.second.config.SecondConfig;
import cn.edu.upc.yb.integrate.second.dto.JsonMes;
import cn.edu.upc.yb.integrate.second.model.Publish;
import cn.edu.upc.yb.integrate.second.model.OurUser;
import cn.edu.upc.yb.integrate.second.repository.PublishRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Jaxlying on 2016/7/26.
 */
@RestController
@RequestMapping("/second")
public class PublishController {

    private static final Logger log = LoggerFactory.getLogger(PublishController.class);

    public static final String ROOT = "imgdir";

    private final ResourceLoader resourceLoader;

    @Autowired
    private SecondConfig secondConfig;

    @Autowired
    public PublishController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Autowired
    private PublishRepository publishRepository;

    @Autowired
    private HttpSession httpSession;

    @RequestMapping("/getallpublish")
    public Object getAllPublish(){
//        return publishRepository.findByIsdeleteOrderByCreatetimeDesc(false);
        return publishRepository.findByIsdeleteOrderByIdDesc(false);
    }
    @RequestMapping(value = "/publishfindone",method = RequestMethod.GET)
    public Object findOne(int id) {
        return publishRepository.findOne(id);
    }


    /**
     * 显示图片
     * @param filename
     * @return 图片
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{filename:.+}")
    public ResponseEntity<?> getFile(@PathVariable String filename) {

        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(ROOT, filename).toString()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "publish/edit")
    public Object edit(@RequestParam("file") MultipartFile file,
                       RedirectAttributes redirectAttributes, String title, String detail, String qq, String telephone, String price, String species, String degree, int publishiid, int isdeal) {

        String imgname = new String();
        if (!file.isEmpty()) {
            try {
                imgname = System.currentTimeMillis() + file.getOriginalFilename();
                Files.copy(file.getInputStream(), Paths.get(ROOT,imgname));
            } catch (IOException |RuntimeException e) {
                redirectAttributes.addFlashAttribute("message", "Failued to upload " + file.getOriginalFilename() + " => " + e.getMessage());
            }
        } else {
            redirectAttributes.addFlashAttribute("message", "Failed to upload " + file.getOriginalFilename() + " because it was empty");
        }
        OurUser user = (OurUser) httpSession.getAttribute("ouruser");
        System.out.println(user.getId());
        Publish publish = publishRepository.findOne(publishiid);
        publish.updata(secondConfig.imgserver + "/second/" + imgname,title,detail,qq,telephone,price,species,degree,isdeal);
        return new JsonMes(1,"编辑成功");
    }

    @RequestMapping("publish/delete")
    public Object delete(int id){
        Publish publish = publishRepository.findOne(id);
        publish.delete();
        publishRepository.save(publish);
        return new JsonMes(1,"删除成功");
    }

    @RequestMapping("/publish/self")
    public Object findSelfPublish(){
//        YibanBasicUserInfo yibanBasicUserInfo = (YibanBasicUserInfo)httpSession.getAttribute("user");
//        if(yibanBasicUserInfo==null) return new JsonMes(-1,"你还没有登陆");
//        System.out.println(yibanBasicUserInfo.visit_user.userid);
        OurUser user = (OurUser)httpSession.getAttribute("ouruser");
//        return publishRepository.findByYbidAndIsdelete(yibanBasicUserInfo.visit_user.userid,false);
        System.out.println(user.getUserid());
        return publishRepository.findByYbidAndIsdelete(user.getUserid(),false);
    }
}
