/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespcd;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author sofyan
 */
public class ZoomIn {
    BufferedImage imageshow=null;
    public ZoomIn(BufferedImage image) throws IOException {
        BufferedImage image2 = new BufferedImage(image.getWidth() * 2, image.getHeight() * 2, BufferedImage.TYPE_INT_RGB);
        Color c;
        int m = 0, n = 0;
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                image2.setRGB(m, n, image.getRGB(j, i));
                image2.setRGB(m + 1, n, image.getRGB(j, i));
                image2.setRGB(m, n + 1, image.getRGB(j, i));
                image2.setRGB(m + 1, n + 1, image.getRGB(j, i));
                m = m + 2;
            }
            n = n + 2;
            m = 0;
        }
        ImageIO.write(image2, "jpg", new File("/media/sofyan/Data/filePCD/image-ZoomIn.jpg"));
        imageshow=image2;
    }
}
