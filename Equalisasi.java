/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespcd;

import java.awt.image.BufferedImage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author sofyan
 */
public class Equalisasi {

    public Equalisasi(BufferedImage srcImage) {
        double n = (double) srcImage.getWidth() * srcImage.getHeight();
        double[] nk = new double[256];
        double[] rk = new double[256];
        double[] prk = new double[256];
        double[] sk = new double[256];
        double count = 0;
        for (int point = 0; point < 256; point++) {
            rk[point] = point / 255.0;
            //System.out.println(rk[point]+";");
            count = 0;
            for (int i = 0; i < srcImage.getHeight(); i++) {
                for (int j = 0; j < srcImage.getWidth(); j++) {
                    int clr = srcImage.getRGB(j, i);
                    int red = (clr & 0x00ff0000) >> 16;
                    int green = (clr & 0x0000ff00) >> 8;
                    int blue = clr & 0x000000ff;
                    //System.out.println("Red Color value = " + red);
                    //System.out.println("Green Color value = " + green);
                    //System.out.println("Blue Color value = " + blue);

                    int nilaigray = Math.round((red + green + blue) / 3);
                    //System.out.println(nilaigray);
                    if (nilaigray == point) {
                        count++;
                    }

                }

            }
            nk[point] = count;
            //System.out.println(count+" "+n);
            prk[point] = count / n;
            //System.out.println(prk[point]+";");

        }
        double jum = 0.0;
        System.out.println("Sk kumulatif");
        for (int i = 0; i < 256; i++) {
            jum = jum + prk[i];
            //System.out.println(jum+" "+prk[i]);
            sk[i] = jum;
            //System.out.println(sk[i]);
        }
        System.out.println("Sk mendekati rk");
        for (int j = 0; j < 256; j++) {
            double min = 9999.99999;
            int pos = 0;

            while (pos < 256) {
                //System.out.println(sk[j]+" "+rk[pos]);
                double selisih = sk[j] - rk[pos];
                double absolut = Math.abs(selisih);
                if (selisih < min) {
                    //System.out.println(" masuk");
                    min = rk[j];//System.out.println(rk[pos]);
                }
                pos++;
            }
            sk[j] = min;
            //System.out.println(sk[j]);
        }
/*
        DefaultCategoryDataset dcd = new DefaultCategoryDataset();
        for (int i=0;i<256;i++){
            dcd.setValue(prk[i],rk[i]+"","");
        }
        

        JFreeChart freeChart = ChartFactory.createBarChart("Pariwisata Indonesia 2012", "Tahun", "Kunjungan Wisatawan(Dalam Persen / %)", dcd, PlotOrientation.VERTICAL, true, true, true); //String arg0,String arg1,String arg2,Category Datasheet,Plot Orientation,boolean arg4,boolean arg5,boolean arg6
        ChartFrame cf = new ChartFrame("Data Kota Pariwisata Indonesia", freeChart);

        cf.setSize(1000, 800);
        cf.setVisible(true);
        cf.setLocationRelativeTo(null); */
    }
}
