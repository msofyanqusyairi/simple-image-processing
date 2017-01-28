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
public class Flipping {
    BufferedImage imageShow=null;
    public Flipping(BufferedImage image) throws IOException {
        int c;
        BufferedImage image2 = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        int k = image.getHeight() - 1;
        //int[][] varRotate=new int[image.getWidth()][image.getHeight()];
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                image2.setRGB(j, k, image.getRGB(j, i));
            }
            k = k - 1;
        }
        ImageIO.write(image2, "jpg", new File("/media/sofyan/Data/filePCD/image-Flipping.jpg"));
        imageShow=image2;
    } 
}
