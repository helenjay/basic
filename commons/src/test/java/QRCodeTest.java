import com.basic.commons.util.MatrixToImageWriter;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

/**
 * Created by caol005 on 2015/11/12.
 */
public class QRCodeTest {

    @Test
    public void testCreateQRCode() throws WriterException, IOException {
        String text = "aaabbb"; // 二维码内容
        int width = 300; // 二维码图片宽度
        int height = 300; // 二维码图片高度
        String format = "gif";// 二维码的图片格式

        Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");	// 内容所使用字符集编码

        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);

        // 生成二维码
        File outputFile = new File("d:" + File.separator + "new.gif");
        MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
    }

    @Test
    public void testParseCode(){
        File outputFile = new File("d:" + File.separator + "new.gif");
        MatrixToImageWriter.parseCode(outputFile);

    }
}
