package seu.Client.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import k.User;
/**
 * 食堂模块主界面
 * @author kidd
 *
 */
public class CanMainPanel extends JPanel {
	User user;
	ImageIcon background = new ImageIcon(this.getClass().getResource("/image/食堂1.png")); 
    //JLabel label = new JLabel(background);
    
	public CanMainPanel(User us){
		
		user =us; 
		this.setLayout(null);
		this.setVisible(true);
		this.setBounds(0, 0, 900, 650);
	    //label.setBounds(-10, -20, this.getWidth(), this.getHeight()); 
	   //this.add(label);
		this.setOpaque(false); 	
		
	}

	protected void paintComponent(Graphics g) {  
       g.drawImage(background.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);  
    } 
	
}
