/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespcd;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.crypto.SealedObject;
import javax.imageio.ImageIO;

/**
 *
 * @author sofyan
 */
public class SegementationByThreshold {
    BufferedImage imageshow=null;
    public SegementationByThreshold(BufferedImage srcImage,int threshold) throws IOException {
        BufferedImage dstImage = new BufferedImage(srcImage.getWidth(), srcImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        //int threshold = 150;

        for (int i = 0; i < srcImage.getHeight(); i++) {
            for (int j = 0; j < srcImage.getWidth(); j++) {
                // Getting pixel color by position srcImage[j][i]
                int clr = srcImage.getRGB(j, i);
                int red = (clr & 0x00ff0000) >> 16;
                int green = (clr & 0x0000ff00) >> 8;
                int blue = clr & 0x000000ff;
                //System.out.println("Red Color value = " + red);
                //System.out.println("Green Color value = " + green);
                //System.out.println("Blue Color value = " + blue);

                int nilaigray = Math.round((red + green + blue) / 3);
                //System.out.println(nilaigray);
                //if((img(ii,jj)>threshold)&&(img(ii,jj)<=255))
                //imgnew(ii,jj)=255;
                //else
                //  img(ii,jj)=0;

                if (nilaigray > threshold && nilaigray <= 255) {
                    dstImage.setRGB(j, i, colorToRGB(0, 255, 255, 255));
                } else {
                    dstImage.setRGB(j, i, colorToRGB(0, 0, 0, 0));
                }
            }
        }
        ImageIO.write(dstImage, "jpg", new File("/media/sofyan/Data/filePCD/image-segmentation.jpg"));
        imageshow=dstImage;
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
        //System.out.println(newPixel);
        return newPixel;
    }

}
