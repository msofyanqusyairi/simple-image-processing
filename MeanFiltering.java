/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespcd;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author sofyan
 */
public class MeanFiltering {

    public BufferedImage dstImage ;

    public MeanFiltering(BufferedImage image,String choosen) throws IOException {
        dstImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        if (choosen.equals("3x3")){
            kernel3(image);
        }
        else if(choosen.equals("5x5")){
            kernel5(image);
        }
        else if(choosen.equals("7x7")){
            kernel7(image);
        }
        
    }

    public void kernel3(BufferedImage image) throws IOException {
        float[] matriksKernel = new float[]{
            0.11f, 0.11f, 0.11f,
            0.11f, 0.11f, 0.11f,
            0.11f, 0.11f, 0.11f
        };
        Kernel kernel = new Kernel(3, 3, matriksKernel);
        ConvolveOp op = new ConvolveOp(kernel);
        op.filter(image, dstImage);
        ImageIO.write(dstImage, "jpg", new File("/media/sofyan/Data/filePCD/imageWithMeanFiltering3x3.jpg"));
    }

    public void kernel5(BufferedImage image) throws IOException {
        float[] matriksKernel = new float[]{
            0.04f, 0.04f, 0.04f, 0.04f, 0.04f,
            0.04f, 0.04f, 0.04f, 0.04f, 0.04f,
            0.04f, 0.04f, 0.04f, 0.04f, 0.04f,
            0.04f, 0.04f, 0.04f, 0.04f, 0.04f,
            0.04f, 0.04f, 0.04f, 0.04f, 0.04f
        };
        Kernel kernel = new Kernel(5, 5, matriksKernel);
        ConvolveOp op = new ConvolveOp(kernel);
        op.filter(image, dstImage);
        ImageIO.write(dstImage, "jpg", new File("/media/sofyan/Data/filePCD/imageWithMeanFiltering5x5.jpg"));
    }

    public void kernel7(BufferedImage image) throws IOException {
        float[] matriksKernel = new float[]{
            0.02f, 0.02f, 0.02f, 0.02f, 0.02f, 0.02f, 0.02f,
            0.02f, 0.02f, 0.02f, 0.02f, 0.02f, 0.02f, 0.02f,
            0.02f, 0.02f, 0.02f, 0.02f, 0.02f, 0.02f, 0.02f,
            0.02f, 0.02f, 0.02f, 0.02f, 0.02f, 0.02f, 0.02f,
            0.02f, 0.02f, 0.02f, 0.02f, 0.02f, 0.02f, 0.02f,
            0.02f, 0.02f, 0.02f, 0.02f, 0.02f, 0.02f, 0.02f,
            0.02f, 0.02f, 0.02f, 0.02f, 0.02f, 0.02f, 0.02f
        };
        Kernel kernel = new Kernel(7, 7, matriksKernel);
        ConvolveOp op = new ConvolveOp(kernel);
        op.filter(image, dstImage);
        ImageIO.write(dstImage, "jpg", new File("/media/sofyan/Data/filePCD/imageWithMeanFiltering7x7.jpg"));
    }
}
