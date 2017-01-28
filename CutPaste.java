/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespcd;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author sofyan
 */
public class CutPaste {
    public BufferedImage imageshow=null;
    public CutPaste(BufferedImage image,int xAsal,int yAsal,int xTarget, int yTarget, int panjangAsal, int lebarAsal) throws IOException {
        BufferedImage image2 = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        BufferedImage tempImage = new BufferedImage(panjangAsal, lebarAsal, BufferedImage.TYPE_INT_RGB);
        int m = 0, n = 0;
        for (int i = yAsal; i < lebarAsal+yAsal; i++) {
            for (int j = xAsal; j < panjangAsal+xAsal; j++) {
                tempImage.setRGB(m, n, image.getRGB(j, i));
                image.setRGB(j, i, -1);
                m++;
            }
            m = 0;
            n++;
        }
        m = 0;
        n = 0;
        image2 = image;
        for (int i = yTarget; i < lebarAsal+yTarget; i++) {
            for (int j = xTarget; j < panjangAsal+xTarget; j++) {
                image2.setRGB(j, i, tempImage.getRGB(m, n));
                m++;
            }
            n++;
            m = 0;
        }
        ImageIO.write(image2, "jpg", new File("/media/sofyan/Data/filePCD/image-CutPaste.jpg"));
        imageshow=image2;
    }
}
