package cn.edu.upc.yb.integrate.second.controller;

import cn.edu.upc.yb.integrate.second.config.SecondConfig;
import cn.edu.upc.yb.integrate.second.model.Publish;
import cn.edu.upc.yb.integrate.second.model.OurUser;
import cn.edu.upc.yb.integrate.second.repository.PublishRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Jaxlying on 2016/7/27.
 */
@Controller
@RequestMapping("/second")
public class ImgController {

    private static final Logger log = LoggerFactory.getLogger(PublishController.class);

    public static final String ROOT = "imgdir";

    private final ResourceLoader resourceLoader;

    @Autowired
    public ImgController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Autowired
    private PublishRepository publishRepository;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private SecondConfig secondConfig;

    /**
     * 发布
     * @param file
     * @param redirectAttributes
     * @param title
     * @param detail
     * @param qq
     * @param telephone
     * @param price
     * @param species
     * @param degree
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/publish")
    public String publish(@RequestParam("file") MultipartFile file,
                          RedirectAttributes redirectAttributes, String title, String detail, String qq, String telephone, String price, String species, String degree) {

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
        System.out.println(user.getUserid());
        Publish publish = new Publish(secondConfig.imgserver + "/second/" + imgname,title,detail,qq,telephone,price,species,degree,user.getUserid(),user.getUsername(),user.getYbhead());
        publish.setYbid(user.getUserid());
        publishRepository.save(publish);
        return "redirect:" + secondConfig.fontend;
    }
}
