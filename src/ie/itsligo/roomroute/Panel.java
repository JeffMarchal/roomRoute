package ie.itsligo.roomroute;

import java.awt.Graphics;
import javax.swing.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;

public class Panel extends JPanel {
	

public void paintComponent(Graphics g){
    g.drawString("Your QRCode:", 10, 20);
    try {
        Image img = ImageIO.read(new File("myQRCode.png"));
        g.drawImage(img, 0, 30, this);
      } catch (IOException e) {
        e.printStackTrace();
      }
  }               
}