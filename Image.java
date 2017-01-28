/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespcd;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author sofyan
 */
public class Image {

    public BufferedImage image;
    public int width;
    public int height;
    public Color c = null;

    public Image(String dir) {
        try {
            File input = new File(dir);
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();
            int count = 0;

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    count++;
                    c = new Color(image.getRGB(j, i));
                    //System.out.println("S.No: " + count + " Red: " + c.getRed() + " Green: " + c.getGreen() + " Blue: " + c.getBlue());
                }
            }
            //ImageIO.write(image, "jpg", new File("D:/image2.jpg"));
        } catch (Exception e) {
        }

    }
}
