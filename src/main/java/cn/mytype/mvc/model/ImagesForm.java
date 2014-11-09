package cn.mytype.mvc.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class ImagesForm implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 8507349931487130851L;

    private MultipartFile headImg;
    private MultipartFile photo;
    private MultipartFile memuImg;

    public MultipartFile getHeadImg() {
        return headImg;
    }
    public void setHeadImg(MultipartFile headImg) {
        this.headImg = headImg;
    }
    public MultipartFile getPhoto() {
        return photo;
    }
    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }
    public MultipartFile getMemuImg() {
        return memuImg;
    }
    public void setMemuImg(MultipartFile memuImg) {
        this.memuImg = memuImg;
    }
}
