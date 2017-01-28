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
import javax.imageio.ImageIO;

/**
 *
 * @author sofyan
 */
public class EdgeDetection {
    BufferedImage imageFrechan=null;
    BufferedImage imageLaplace=null;
    BufferedImage imagePrewitt=null;
    BufferedImage imageRobert=null;
    BufferedImage imageSobel=null;
    public EdgeDetection(BufferedImage srcImage) throws IOException{
        edgeByFrechan(srcImage);
        edgeByLaplace(srcImage);
        edgeByRobert(srcImage);
        edgeByPrewitt(srcImage);
        edgeBySobel(srcImage);
    }


    //edge-by-frechan
    public void edgeByFrechan(BufferedImage srcImage) throws IOException{
        BufferedImage dst1Image=new BufferedImage(srcImage.getWidth(),srcImage.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
        BufferedImage dst2Image=new BufferedImage(srcImage.getWidth(),srcImage.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
        BufferedImage dst3Image=new BufferedImage(srcImage.getWidth(),srcImage.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
        float[] matriksKernel1 = new float[]{
            -1f, 0f, 1f,
            -1.41f, 0f, 1.41f,
            -1f, 0f, 1f
        };
        float[] matriksKernel2 = new float[]{
            -1f, -1.41f, -1f,
            0f, 0f, 0f,
            1f, 1.41f, 1f
        };
        
        Kernel kernel1 = new Kernel(3, 3, matriksKernel1);
        ConvolveOp op1 = new ConvolveOp(kernel1);
        op1.filter(srcImage, dst1Image);
        Kernel kernel2 = new Kernel(3, 3, matriksKernel2);
        ConvolveOp op2 = new ConvolveOp(kernel2);
        op2.filter(srcImage, dst2Image);
        
        for (int i=0;i<srcImage.getHeight();i++){
            for (int j=0;j<srcImage.getWidth();j++){
                dst3Image.setRGB(j, i, dst1Image.getRGB(j, i)+dst2Image.getRGB(j,i));
            }
        }
        ImageIO.write(dst3Image, "jpg", new File("/media/sofyan/Data/filePCD/edgeDetectionByFrechan.jpg"));
        imageFrechan=dst3Image;
    }
    //edge-by-laplace
    public void edgeByLaplace(BufferedImage srcImage) throws IOException{
        BufferedImage dst1Image=new BufferedImage(srcImage.getWidth(),srcImage.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
        float[] matriksKernel1 = new float[]{
            0f, 1f, 0f,
            1f, -4f, 1f,
            0f, 1f, 0f
        };
        
        Kernel kernel1 = new Kernel(3, 3, matriksKernel1);
        ConvolveOp op1 = new ConvolveOp(kernel1);
        op1.filter(srcImage, dst1Image);
        
        ImageIO.write(dst1Image, "jpg", new File("/media/sofyan/Data/filePCD/edgeDetectionByLaplace.jpg"));
        imageLaplace=dst1Image;
    }
    //edge-by-prewitt
    public void edgeByPrewitt(BufferedImage srcImage) throws IOException{
        BufferedImage dst1Image=new BufferedImage(srcImage.getWidth(),srcImage.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
        BufferedImage dst2Image=new BufferedImage(srcImage.getWidth(),srcImage.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
        BufferedImage dst3Image=new BufferedImage(srcImage.getWidth(),srcImage.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
        float[] matriksKernel1 = new float[]{
            -1f, 0f, 1f,
            -1f, 0f, 1f,
            -1f, 0f, 1f
        };
        float[] matriksKernel2 = new float[]{
            -1f, -1f, -1f,
            0f, 0f, 0f,
            1f, 1f, 1f
        };
        
        Kernel kernel1 = new Kernel(3, 3, matriksKernel1);
        ConvolveOp op1 = new ConvolveOp(kernel1);
        op1.filter(srcImage, dst1Image);
        Kernel kernel2 = new Kernel(3, 3, matriksKernel2);
        ConvolveOp op2 = new ConvolveOp(kernel2);
        op2.filter(srcImage, dst2Image);
        
        for (int i=0;i<srcImage.getHeight();i++){
            for (int j=0;j<srcImage.getWidth();j++){
                dst3Image.setRGB(j, i, dst1Image.getRGB(j, i)+dst2Image.getRGB(j,i));
            }
        }
        ImageIO.write(dst3Image, "jpg", new File("/media/sofyan/Data/filePCD/edgeDetectionByPrewitt.jpg"));
        imagePrewitt=dst3Image;
    }
    //edge-by-robert
    public void edgeByRobert(BufferedImage srcImage) throws IOException{
        BufferedImage dst1Image=new BufferedImage(srcImage.getWidth(),srcImage.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
        BufferedImage dst2Image=new BufferedImage(srcImage.getWidth(),srcImage.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
        BufferedImage dst3Image=new BufferedImage(srcImage.getWidth(),srcImage.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
        float[] matriksKernel1 = new float[]{
            -1f, 0f, 0f,
            0f, 1f, 0f,
            0f, 0f, 0f
        };
        float[] matriksKernel2 = new float[]{
            0f, 0f, -1f,
            0f, 1f, 0f,
            0f, 0f, 0f
        };
        
        Kernel kernel1 = new Kernel(3, 3, matriksKernel1);
        ConvolveOp op1 = new ConvolveOp(kernel1);
        op1.filter(srcImage, dst1Image);
        Kernel kernel2 = new Kernel(3, 3, matriksKernel2);
        ConvolveOp op2 = new ConvolveOp(kernel2);
        op2.filter(srcImage, dst2Image);
        
        for (int i=0;i<srcImage.getHeight();i++){
            for (int j=0;j<srcImage.getWidth();j++){
                dst3Image.setRGB(j, i, dst1Image.getRGB(j, i)+dst2Image.getRGB(j,i));
            }
        }
        ImageIO.write(dst3Image, "jpg", new File("/media/sofyan/Data/filePCD/edgeDetectionByRobert.jpg"));
        imageRobert=dst3Image;
    }
    //edge-by-sobel
    public void edgeBySobel(BufferedImage srcImage) throws IOException{
        BufferedImage dst1Image=new BufferedImage(srcImage.getWidth(),srcImage.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
        BufferedImage dst2Image=new BufferedImage(srcImage.getWidth(),srcImage.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
        BufferedImage dst3Image=new BufferedImage(srcImage.getWidth(),srcImage.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
        float[] matriksKernel1 = new float[]{
            -1f, 0f, 1f,
            -2f, 0f, 2f,
            -1f, 0f, 1f
        };
        float[] matriksKernel2 = new float[]{
            -1f, -2f, -1f,
            0f, 0f, 0f,
            1f, 2f, 1f
        };
        
        Kernel kernel1 = new Kernel(3, 3, matriksKernel1);
        ConvolveOp op1 = new ConvolveOp(kernel1);
        op1.filter(srcImage, dst1Image);
        Kernel kernel2 = new Kernel(3, 3, matriksKernel2);
        ConvolveOp op2 = new ConvolveOp(kernel2);
        op2.filter(srcImage, dst2Image);
        
        for (int i=0;i<srcImage.getHeight();i++){
            for (int j=0;j<srcImage.getWidth();j++){
                dst3Image.setRGB(j, i, dst1Image.getRGB(j, i)+dst2Image.getRGB(j,i));
            }
        }
        ImageIO.write(dst3Image, "jpg", new File("/media/sofyan/Data/filePCD/edgeDetectionBySobel.jpg"));
        imageSobel=dst3Image;
    }
}
