package cn.mytype.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ImageUtil {

    private static Log log = LogFactory.getLog(ImageUtil.class);

    private static String JPEG = "JPEG";

    /***
     * 功能 :调整图片大小
     * @param srcImgPath 原图片路径
     * @param distImgPath  转换大小后图片路径
     * @param width   转换后图片宽度
     * @param height  转换后图片高度
     */
    public static boolean resizeImage(String srcImgPath, String distImgPath,
            int width, int height) {

        try {
            File srcFile = new File(srcImgPath);
            Image srcImg = ImageIO.read(srcFile);

            BufferedImage buffImg = null;
            buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            buffImg.getGraphics().drawImage(
                    srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0,
                    0, null);

            ImageIO.write(buffImg, JPEG, new File(distImgPath));

            return true;
        } catch (Exception e) {
            log.error("图片大小变换失败！", e);
            return false;
        }
    }

    public static int getImageWidth(String imgPath) throws Exception {
        File picture = new File(imgPath);
        BufferedImage bufImg =ImageIO.read(new FileInputStream(picture));
        return bufImg.getWidth();
    }

    public static int getImageHeight(String imgPath) throws Exception {
        File picture = new File(imgPath);
        BufferedImage bufImg =ImageIO.read(new FileInputStream(picture));
        return bufImg.getHeight();
    }

    public static long getImageLength(String imgPath) throws Exception {
        File picture = new File(imgPath);
        return picture.length();
    }

}
