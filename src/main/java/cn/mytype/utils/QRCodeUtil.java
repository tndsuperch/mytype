package cn.mytype.utils;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 二维码生成和解析用工具类
 */
public class QRCodeUtil {

    private static Log log = LogFactory.getLog(QRCodeUtil.class);

    private static final String CHARSET = "utf-8";

    // 二维码尺寸
    private static final int QRCODE_SIZE = 300;
    // LOGO宽度
    private static final int WIDTH = 60;
    // LOGO高度
    private static final int HEIGHT = 60;

    /**
     * 编码
     * @param strContent 二维码内容
     * @param strPath 二维码存储文件路径
     */
    public static void encode(String strContent, String strPath) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File(strPath));
            QRCode.from(strContent).withCharset(CHARSET).withSize(300, 300)
                .withErrorCorrection(ErrorCorrectionLevel.H).to(ImageType.PNG).writeTo(fos);
        } catch (Exception e) {
            log.error("二维码生成失败", e);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    log.error("二维码生成失败", e);
                }
            }
        }
    }

    /**
     * 编码
     * @param strContent 二维码内容
     * @param strPath 二维码存储文件路径
     * @param width 宽度
     * @param height 高度
     */
    public static void encode(String strContent, String strPath, int width, int height) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File(strPath));
            QRCode.from(strContent).withCharset(CHARSET).withSize(width, height)
                .withErrorCorrection(ErrorCorrectionLevel.H).to(ImageType.PNG).writeTo(fos);
        } catch (Exception e) {
            log.error("二维码生成失败", e);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    log.error("二维码生成失败", e);
                }
            }
        }
    }

    /**
     * 生成二维码(内嵌LOGO)
     *
     * @param content
     *            内容
     * @param logoPath
     *            LOGO地址
     * @param destPath
     *            存放目录
     */
    public static void encode(String content, String logoPath, String destPath) {
        try {
            BufferedImage image = QRCodeUtil.createImage(content, logoPath, true);
            ImageIO.write(image, ImageType.PNG.toString(), new File(destPath));
        } catch (Exception e) {
            log.error("二维码生成失败", e);
        }
    }

    /**
     * 解码
     * @param imgPath 二维码图片路径
     * @return 解码后的文本
     */
    public static String decode(String imgPath) {
        String resultText = null;
        try {
            File file = new File(imgPath);
            BufferedImage image;
            image = ImageIO.read(file);
            if (image == null) {
                log.error("二维码解码失败");
            }
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(
                    new HybridBinarizer(source));
            Result result;
            Hashtable<DecodeHintType, String> hints = new Hashtable<DecodeHintType, String>();
            hints.put(DecodeHintType.CHARACTER_SET, CHARSET);
            result = new MultiFormatReader().decode(bitmap, hints);
            resultText = result.getText();
        } catch (Exception e) {
            log.error("二维码解码失败", e);
        }
        return resultText;
    }

    /**
     * 生成二维码(内嵌LOGO)
     *
     * @param content
     *            内容
     * @param logoPath
     *            LOGO地址
     * @param needCompress
     *            是否压缩LOGO
     * @throws Exception
     */
    private static BufferedImage createImage(String content, String logoPath,
            boolean needCompress) throws Exception {
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
        hints.put(EncodeHintType.MARGIN, 1);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
                BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE, hints);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage qrImage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                qrImage.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000
                        : 0xFFFFFFFF);
            }
        }
        if (logoPath == null || "".equals(logoPath)) {
            return qrImage;
        }
        // 插入图片
        QRCodeUtil.insertImage(qrImage, logoPath, needCompress);
        return qrImage;
    }

    /**
     * 插入LOGO
     *
     * @param source
     *            二维码图片
     * @param imgPath
     *            LOGO图片地址
     * @param needCompress
     *            是否压缩
     * @throws Exception
     */
    private static void insertImage(BufferedImage source, String logoPath,
            boolean needCompress) throws Exception {
        File file = new File(logoPath);
        if (!file.exists()) {
            log.error("" + logoPath + "    该文件不存在！");
            return;
        }
        Image src = ImageIO.read(new File(logoPath));
        int width = src.getWidth(null);
        int height = src.getHeight(null);
        if (needCompress) { // 压缩LOGO
            if (width > WIDTH) {
                width = WIDTH;
            }
            if (height > HEIGHT) {
                height = HEIGHT;
            }
            Image image = src.getScaledInstance(width, height,
                    Image.SCALE_SMOOTH);
            BufferedImage tag = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics g = tag.getGraphics();
            g.drawImage(image, 0, 0, null); // 绘制缩小后的图
            g.dispose();
            src = image;
        }
        // 插入LOGO
        Graphics2D graph = source.createGraphics();
        int x = (QRCODE_SIZE - width) / 2;
        int y = (QRCODE_SIZE - height) / 2;
        graph.drawImage(src, x, y, width, height, null);
        Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
        graph.setStroke(new BasicStroke(3f));
        graph.draw(shape);
        graph.dispose();
    }

    public static void main(String[] args) {
        String imgPath = "D:/myQrCode.png";
        QRCodeUtil.encode("http://172.30.125.10:8080/HomeFood/homefood01.html", "D:/page1_img1.jpg", imgPath);
        System.out.println(QRCodeUtil.decode(imgPath));
    }

}
