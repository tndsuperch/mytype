package cn.mytype.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.mytype.mvc.model.ImagesForm;

@Controller
public class ImagesController extends MyTypeController {

    @RequestMapping(value = "/images/get/headImg/{id}")
    @ResponseBody
    public byte[] getHeadImg(@PathVariable String id) throws Exception {
        // TODO
        System.out.println("头像："+id+"已从数据库读取。");
        byte[] image = null;
        //image = FileUtils.readFileToByteArray(new File("d:/myQrCode.png"));
        return image;
    }

    @RequestMapping(value = "/images/get/photo/{id}")
    @ResponseBody
    public byte[] getPhoto(@PathVariable String id) throws Exception {
        // TODO
        System.out.println("照片："+id+"已从数据库读取。");
        byte[] image = null;
        //image = FileUtils.readFileToByteArray(new File("d:/myQrCode.png"));
        return image;
    }

    @RequestMapping(value = "/images/get/memuImg/{id}")
    @ResponseBody
    public byte[] getMemuImg(@PathVariable String id) throws Exception {
        // TODO
        System.out.println("菜单图片："+id+"已从数据库读取。");
        byte[] image = null;
        //image = FileUtils.readFileToByteArray(new File("d:/myQrCode.png"));
        return image;
    }

    @RequestMapping(value = "/images/put/headImg")
    @ResponseBody
    public void putHeadImg(ImagesForm imagesForm) {
        // TODO
        System.out.println("头像："+imagesForm.getHeadImg().getOriginalFilename() + "已经被存储到数据库！");
    }

    @RequestMapping(value = "/images/put/photo")
    @ResponseBody
    public void putPhoto(ImagesForm imagesForm) {
        // TODO
        System.out.println("照片："+imagesForm.getPhoto().getOriginalFilename() + "已经被存储到数据库！");
    }

    @RequestMapping(value = "/images/put/memuImg")
    @ResponseBody
    public void putMemuImg(ImagesForm imagesForm) {
        // TODO
        System.out.println("菜谱图片："+imagesForm.getMemuImg().getOriginalFilename() + "已经被存储到数据库！");
    }
}
