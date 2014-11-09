package cn.mytype.mvc.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.mytype.Constants;

import com.google.code.kaptcha.Producer;

@Controller
public class KaptchaController extends MyTypeController {

    private Producer kaptchaProducer = null;

    @Autowired(required=true)
    @Qualifier(value="kaptchaProducer")
    public void setKaptchaProducer(Producer kaptchaProducer) {
        this.kaptchaProducer = kaptchaProducer;
    }

    @RequestMapping(value="/kaptchaImage")
    @ResponseBody
    public byte[] createCaptcha(HttpServletRequest request) throws Exception {
        // create the text for the image
        String capText = kaptchaProducer.createText();
        // store the text in the session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        // create the image with the text
        BufferedImage bi = kaptchaProducer.createImage(capText);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // write the data out
        ImageIO.write(bi, Constants.IMAGE_TYPE_JPG, out);
        return out.toByteArray();
    }
}
