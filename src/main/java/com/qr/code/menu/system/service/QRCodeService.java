// QRCodeService.java
package com.qr.code.menu.system.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

@Service
public class QRCodeService {
    public String generateQRCode(String data) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 250, 250);

        BufferedImage qrImage = new BufferedImage(250, 250, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < 250; x++) {
            for (int y = 0; y < 250; y++) {
                qrImage.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(qrImage, "png", baos);
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }
}
