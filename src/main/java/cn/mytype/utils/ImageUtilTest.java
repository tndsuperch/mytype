package cn.mytype.utils;

import org.junit.Test;

public class ImageUtilTest {
    @Test
    public void resizeImageTest() throws Exception {

        ImageUtil.resizeImage("C:\\Users\\xyuser\\Desktop\\2014-09-27 133336.jpg",
                "C:\\Users\\xyuser\\Desktop\\resized_2014-09-27 133336.jpg",160,160);

        System.out.println(ImageUtil.getImageWidth("C:\\Users\\xyuser\\Desktop\\2014-09-27 133336.jpg"));

        System.out.println(ImageUtil.getImageHeight("C:\\Users\\xyuser\\Desktop\\2014-09-27 133336.jpg"));
    }

}
