package cn.mytype.mvc.controller;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ImagesController extends MyTypeController {

    @ResponseBody
    @RequestMapping(value = "/download/{id}")
    public byte[] getImage(@PathVariable String id) throws Exception {
        byte[] image = null;
        image = FileUtils.readFileToByteArray(new File("d:/myQrCode.png"));
        return image;
    }
}
