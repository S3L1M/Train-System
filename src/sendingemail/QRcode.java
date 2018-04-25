/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendingemail;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.NotFoundException;
import javax.imageio.ImageIO;

/**
 *
 * @author mina
 */
public class QRcode {

    public static void QR(String Name,String phone) throws WriterException, IOException,
			NotFoundException {
            
         
          
          
		String qrCodeData = Name+""+phone;//BT70T KOL 7AGA gowa string el qrcodedata be string 
		String filePath;//Makan el file ely haysgel feh image
                
		String charset = "UTF-8"; // or "ISO-8859-1" Momkn nkteb beh 3arbe
		Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
                /*
                hintmap->>>>btob2a Enmuiton
                Map ->>>>>> baya5od el 3adad bta3 el 7agt ely hatt7t fe el Qrcode 
                ErrorCorrectionlevel ->>>>>>>>> howa hena bay5od enumation 
                EncodeHintType ->>>>>>> howa hena by3ml enmution ll size , margin, Maxsize, Min_size, CHARACTER_SET ,shape 
                */
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
                filePath=Name+".png";
                /*
                Hena el filepath b2sm kol wa7ed
                */
		createQRCode(qrCodeData, filePath, charset, hintMap, 200, 200);
                /*
                        bta5od -->> el qrdata,we asm el file , format el katba,we el enmtuion,we el size bat3 el sora
                */
                System.out.println("QR Code image created successfully!");

		System.out.println("Data read from QR Code: "+ readQRCode(filePath, hintMap));

	}

	public static void createQRCode(String qrCodeData, String filePath,String charset, Map hintMap, int qrCodeheight, int qrCodewidth)throws WriterException, IOException {
		BitMatrix matrix = new MultiFormatWriter().encode(new String(qrCodeData.getBytes(charset), charset),BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight, hintMap);
		/*
                BitMatrix ->>>>bat3ml el width we size we el qrcode we tar2et elkatba
                Encode-->>bat5le el baynat leeee remoooz
                */
                MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.') + 1), new File(filePath));
                /*
                btktb fe el file bta5od el matrix  we el file path
                */
        }

	public static String readQRCode(String filePath, Map hintMap)
			throws FileNotFoundException, IOException, NotFoundException {
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
				new BufferedImageLuminanceSource(
						ImageIO.read(new FileInputStream(filePath)))));
                /*bt3mel read image */
                Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap,
				hintMap);
                /*btrg3 el result ely rag3et*/
		return qrCodeResult.getText();
	}
}
