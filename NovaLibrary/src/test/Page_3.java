package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.LayoutManager;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class Page_3 extends JPanel {

	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public Page_3() throws IOException {
		
		this.setPreferredSize(new Dimension(1000, 555));
		setLayout(null);
		setBackground(Color.white);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 50, 940, 2);
		add(separator);
		
		JLabel corse_label_1 = new JLabel("\u5BB6\u5E38\u83DC\u8C31");
		corse_label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				    
				
			}
		});
		corse_label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		corse_label_1.setBounds(40, 25, 110, 20);
		add(corse_label_1);
		
		JLabel corse_label_2 = new JLabel("\u4F11\u95F2\u517B\u751F");
		corse_label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
			}
		});
		corse_label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		corse_label_2.setBounds(40, 200, 120, 20);
		add(corse_label_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(30, 225, 940, 2);
		add(separator_1);
		
		JLabel corse_label_3 = new JLabel("\u4F53\u80B2\u62A5\u7EB8");
		corse_label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
			}
		});
		corse_label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		corse_label_3.setBounds(40, 375, 141, 20);
		add(corse_label_3);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(30, 400, 940, 2);
		add(separator_2);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(30, 750, 940, 2);
		add(separator_4);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(30, 50, 940, 143);
		add(panel);
		panel.setLayout(null);
		
		JLabel booklabel_1 = new JLabel("");
		booklabel_1.setBounds(40, 0, 130, 140);
		panel.add(booklabel_1);
		
		JLabel booklabel_2 = new JLabel("");
		booklabel_2.setBounds(190, 0, 130, 140);
		panel.add(booklabel_2);
		
		JLabel booklabel_3 = new JLabel("");
		booklabel_3.setBounds(340, 0, 130, 140);
		panel.add(booklabel_3);
		
		JLabel booklabel_4 = new JLabel("");
		booklabel_4.setBounds(490, 0, 130, 140);
		panel.add(booklabel_4);
		
		JLabel booklabel_5 = new JLabel("");
		booklabel_5.setBounds(640, 0, 130, 140);
		panel.add(booklabel_5);
		
		JLabel booklabel_6 = new JLabel("");
		booklabel_6.setBounds(800, 0, 130, 140);
		panel.add(booklabel_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(30, 230, 940, 143);
		add(panel_1);
		
		JLabel booklabel_25 = new JLabel("");
		booklabel_25.setBounds(40, 0, 130, 140);
		panel_1.add(booklabel_25);
		
		JLabel booklabel_26 = new JLabel("");
		booklabel_26.setBounds(190, 0, 130, 140);
		panel_1.add(booklabel_26);
		
		JLabel booklabel_27 = new JLabel("");
		booklabel_27.setBounds(340, 0, 130, 140);
		panel_1.add(booklabel_27);
		
		JLabel booklabel_28 = new JLabel("");
		booklabel_28.setBounds(490, 0, 130, 140);
		panel_1.add(booklabel_28);
		
		JLabel booklabel_29 = new JLabel("");
		booklabel_29.setBounds(640, 0, 130, 140);
		panel_1.add(booklabel_29);
		
		JLabel booklabel_30 = new JLabel("");
		booklabel_30.setBounds(800, 0, 130, 140);
		panel_1.add(booklabel_30);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(30, 405, 940, 143);
		add(panel_2);
		
		JLabel booklabel_7 = new JLabel("");
		booklabel_7.setBounds(40, 0, 130, 140);
		panel_2.add(booklabel_7);
		
		JLabel booklabel_8 = new JLabel("");
		booklabel_8.setBounds(190, 0, 130, 140);
		panel_2.add(booklabel_8);
		
		JLabel booklabel_9 = new JLabel("");
		booklabel_9.setBounds(340, 0, 130, 140);
		panel_2.add(booklabel_9);
		
		JLabel booklabel_10 = new JLabel("");
		booklabel_10.setBounds(490, 0, 130, 140);
		panel_2.add(booklabel_10);
		
		JLabel booklabel_11 = new JLabel("");
		booklabel_11.setBounds(640, 0, 130, 140);
		panel_2.add(booklabel_11);
		
		JLabel booklabel_12 = new JLabel("");
		booklabel_12.setBounds(800, 0, 130, 140);
		panel_2.add(booklabel_12);
		
		setLabelBac("1",booklabel_1);
		setLabelBac("2",booklabel_2);
		setLabelBac("3",booklabel_3);
		setLabelBac("4",booklabel_4);
		setLabelBac("5",booklabel_5);
		setLabelBac("6",booklabel_6);
		
		setLabelBac("1",booklabel_7);
		setLabelBac("2",booklabel_8);
		setLabelBac("3",booklabel_9);
		setLabelBac("4",booklabel_10);
		setLabelBac("5",booklabel_11);
		setLabelBac("6",booklabel_12);
		
		setLabelBac("1",booklabel_25);
		setLabelBac("2",booklabel_26);
		setLabelBac("3",booklabel_27);
		setLabelBac("4",booklabel_28);
		setLabelBac("5",booklabel_29);
		setLabelBac("6",booklabel_30);
		
		JButton button = new JButton("\u6362\u4E00\u6279");
		button.setBounds(877, 25,80,20);
		add(button);
		button.setForeground(Color.black);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setText("»»Ò»Åú");
		
		JButton button_1 = new JButton("\u6362\u4E00\u6279");
		button_1.setBounds(877, 200,80,20);
		add(button_1);
		button_1.setForeground(Color.black);
		button_1.setFocusPainted(false);
		button_1.setContentAreaFilled(false);
		button_1.setText("»»Ò»Åú");
		
		JButton button_2 = new JButton("\u6362\u4E00\u6279");
		button_2.setBounds(877, 375,80,20);
		add(button_2);
		button_2.setForeground(Color.black);
		button_2.setFocusPainted(false);
		button_2.setContentAreaFilled(false);
		button_2.setText("»»Ò»Åú");
		
		
	}
	 void setLabelBac(String a,JLabel b) throws IOException{
			ImageIcon img = new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator + a + ".jpg");
			img.setImage(img.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT));
			//Icon icon=new ImageIcon(img);
			b.setIcon(img);
		}
}
