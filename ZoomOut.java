/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespcd;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.round;
import javax.imageio.ImageIO;

/**
 *
 * @author sofyan
 */
public class ZoomOut {

    BufferedImage imageshow = null;

    public ZoomOut(BufferedImage image) throws IOException {
        BufferedImage image2 = new BufferedImage((int) round((image.getWidth() * 0.5)), (int) round(image.getHeight() * 0.5), BufferedImage.TYPE_INT_RGB);
        //System.out.println("image2 :"+image2.getWidth()+", "+image2.getHeight());
        int jumred = 0, jumgreen = 0, jumblue = 0, m = 0, n = 0;
        for (int i = 0; i < image2.getHeight(); i++) {
            for (int j = 0; j < image2.getWidth(); j++) {
                int clr0 = image.getRGB(m, n);
                int clr1 = image.getRGB(m + 1, n);
                int clr2 = image.getRGB(m, n + 1);
                int clr3 = image.getRGB(m + 1, n + 1);
                //get RGB clr0
                int red0 = (clr0 & 0x00ff0000) >> 16;
                int green0 = (clr0 & 0x0000ff00) >> 8;
                int blue0 = clr0 & 0x000000ff;
                //get RGB clr1
                int red1 = (clr1 & 0x00ff0000) >> 16;
                int green1 = (clr1 & 0x0000ff00) >> 8;
                int blue1 = clr1 & 0x000000ff;
                //get RGB clr2
                int red2 = (clr2 & 0x00ff0000) >> 16;
                int green2 = (clr2 & 0x0000ff00) >> 8;
                int blue2 = clr2 & 0x000000ff;

                //get RGB clr0
                int red3 = (clr3 & 0x00ff0000) >> 16;
                int green3 = (clr3 & 0x0000ff00) >> 8;
                int blue3 = clr3 & 0x000000ff;
                jumred = (red0 + red1 + red2 + red3) / 4;
                jumgreen = (green0 + green1 + green2 + green3) / 4;
                jumblue = (blue0 + blue1 + blue2 + blue3) / 4;
                //jum = round((image.getRGB(m, n) + image.getRGB(m + 1, n) + image.getRGB(m, n + 1) + image.getRGB(m + 1, n + 1)) / 4);
                image2.setRGB(j, i, colorToRGB(0, jumred, jumgreen, jumblue));
                m = m + 2;
            }
            n = n + 2;
            m = 0;
        }
        ImageIO.write(image2, "jpg", new File("/media/sofyan/Data/filePCD/image-ZoomOut.jpg"));
        imageshow = image2;
    }

    public static int colorToRGB(int alpha, int red, int green, int blue) {
        int newPixel = 0;
        newPixel += alpha;
        newPixel = newPixel << 8;
        newPixel += red;
        newPixel = newPixel << 8;
        newPixel += green;
        newPixel = newPixel << 8;
        newPixel += blue;
        // System.out.println(newPixel);
        return newPixel;
    }
}
