package com.basic.commons.util;

import com.swetake.util.Qrcode;
import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.data.QRCodeImage;
import jp.sourceforge.qrcode.exception.DecodingFailedException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by caol005 on 2015/10/30.
 */
public class QRCodeUtils {

    /**
     * 编码字符串内容到目标File对象中
     * @param encodeddata
     * @param destFile
     * @throws IOException
     */
    public static void qrCodeEncode(String encodeddata,File destFile) throws IOException {
        Qrcode qrcode = new Qrcode();
        qrcode.setQrcodeErrorCorrect('M');
        qrcode.setQrcodeEncodeMode('B');
        qrcode.setQrcodeVersion(7);
        byte[] d = encodeddata.getBytes("GBK");
        BufferedImage bi = new BufferedImage(139, 139, BufferedImage.TYPE_INT_RGB);
        // createGraphics
        Graphics2D g = bi.createGraphics();
        // set background
        g.setBackground(Color.WHITE);
        g.clearRect(0, 0, 139, 139);
        g.setColor(Color.BLACK);

        if (d.length > 0 && d.length < 123) {
            boolean[][] b = qrcode.calQrcode(d);
            for (int i = 0; i < b.length; i++) {
                for (int j = 0; j < b.length; j++) {
                    if (b[j][i]) {
                        g.fillRect(j * 3 + 2, i * 3 + 2, 3, 3);
                    }
                }
            }
        }

        g.dispose();
        bi.flush();

        ImageIO.write(bi, "png", destFile);
        System.out.println("Input Encoded data is："+encodeddata);
    }

    /**
     * 解析二维码，返回解析内容
     * @param imageFile
     * @return
     */
    public static String qrCodeDecode(File imageFile) {
        String decodedData = null;
        QRCodeDecoder decoder = new QRCodeDecoder();
        BufferedImage image = null;
        try {
            image = ImageIO.read(imageFile);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            decodedData = new String(decoder.decode(new J2SEImage(image)), "GBK");
            System.out.println("Output Decoded Data is："+decodedData);
        } catch (DecodingFailedException dfe) {
            System.out.println("Error: " + dfe.getMessage());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return decodedData;
    }

    public static void main(String[] args) {
        String FilePath = "C:\\Demo\\QRCode.png";
        File qrFile = new File(FilePath);

        //编码
        String encodeddata = "{id:10022,name:wandern}";
        try {
            QRCodeUtils.qrCodeEncode(encodeddata, qrFile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        };


        //解码
        String reText = QRCodeUtils.qrCodeDecode(qrFile);
        System.out.println(reText);
    }
}

class J2SEImage implements QRCodeImage {
    BufferedImage image;

    public J2SEImage(BufferedImage image) {
        this.image = image;
    }

    public int getWidth() {
        return image.getWidth();
    }

    public int getHeight() {
        return image.getHeight();
    }

    public int getPixel(int x, int y) {
        return image.getRGB(x, y);
    }
}
