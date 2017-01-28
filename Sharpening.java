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
public class Sharpening {
    BufferedImage imageshow=null;
    public Sharpening (BufferedImage srcImage) throws IOException{
        BufferedImage dstImage=new BufferedImage(srcImage.getWidth(),srcImage.getHeight(),BufferedImage.TYPE_INT_RGB);
        float[] matriksKernel = new float[]{
            0, -1f, 0f,
            -1f, 5f, -1f,
            0f, -1f, 0f
        };
        Kernel kernel = new Kernel(3, 3, matriksKernel);
        ConvolveOp op = new ConvolveOp(kernel);
        op.filter(srcImage, dstImage);
        ImageIO.write(dstImage, "jpg", new File("/media/sofyan/Data/filePCD/image-sharpening.jpg"));
        imageshow=dstImage;
    }
    
}
