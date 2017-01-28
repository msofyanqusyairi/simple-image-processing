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
import static java.lang.Math.round;
import javax.imageio.ImageIO;

/**
 *
 * @author sofyan
 */
public class Sampling {

    BufferedImage imageshow = null;

    public Sampling(BufferedImage image, int p) throws IOException {
        BufferedImage imagesampling = image;
        int x = imagesampling.getWidth();
        int y = imagesampling.getHeight();
        

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j = j + p) {
                int meanred=0,meangreen=0,meanblue=0;
                int jumred = 0,jumgreen=0,jumblue=0;
                for (int k = j; (k < (p + j)) && (k < x); k++) {
                    int clr = image.getRGB(k, i);
                    int red = (clr & 0x00ff0000) >> 16;
                    int green = (clr & 0x0000ff00) >> 8;
                    int blue = clr & 0x000000ff;

                    //int nilaigray = Math.round((red + green + blue) / 3);
                    jumred=jumred+red;
                    jumgreen=jumgreen+green;
                    jumblue=jumblue+blue;
                    //jum = jum + nilaigray;
                    //System.out.println("k : "+k +", j: "+j+",i : "+i);
                }
                //mean = round(jum / p);
                meanred=jumred/p;
                meangreen=jumgreen/p;
                meanblue=jumblue/p;
                for (int k = j; (k < (p + j)) && (k < x); k++) {
                    //c = new Color(image.getRGB(k, i));
                    image.setRGB(k, i, colorToRGB(0, meanred, meangreen, meanblue));
                    //System.out.println("k : "+k +",i : "+i);
                }
                // System.out.println(", j: "+j+",i : "+i);
            }
        }

        ImageIO.write(image, "jpg", new File("/media/sofyan/Data/filePCD/hasil-sampling.jpg"));
        imageshow = image;
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
