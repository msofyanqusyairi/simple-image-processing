/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespcd;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author sofyan
 */
public class ShowImage{

    public ShowImage(BufferedImage imagesrc,BufferedImage imagedst,String titlesrc,String titledst,String namaFileSrc,String lokasiFileDst) {
        //Frame Destination Image
        JFrame framedst = new JFrame();
        framedst.setTitle(titledst);
        framedst.setSize(imagedst.getWidth()+10, imagedst.getHeight()+38);
        Container containerdst = framedst.getContentPane();
        containerdst.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        Icon icondst = new ImageIcon(lokasiFileDst);
        JLabel labelIcondst = new JLabel(icondst);
        labelIcondst.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        containerdst.add(labelIcondst);
        framedst.getContentPane().setBackground(Color.WHITE);
        //Frame Src Image
        JFrame framesrc = new JFrame();
        framesrc.setTitle(titlesrc);
        framesrc.setSize(imagesrc.getWidth()+10, imagesrc.getHeight()+38);        
        Container containersrc = framesrc.getContentPane();
        containersrc.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        Icon iconsrc = new ImageIcon("/media/sofyan/Data/filePCD/"+namaFileSrc);
        JLabel labelIconsrc = new JLabel(iconsrc);
        labelIconsrc.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        containersrc.add(labelIconsrc);
        framesrc.getContentPane().setBackground(Color.WHITE);
        //frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framesrc.setVisible(true);

        framesrc.show(true);
        
        framedst.setVisible(true);

        framedst.show(true);
    }
}
