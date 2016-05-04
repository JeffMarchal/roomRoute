package ie.itsligo.roomroute;
import javax.swing.*;


public class Window extends JFrame {

	public JButton button = new JButton();
	public Window(){             
    
		this.setTitle("QRCode Timetable");
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);                
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setContentPane(new Panel());
		this.setVisible(true);
    
	}       
}