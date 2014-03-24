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

import javax.swing.JPanel;

public class Page_2 extends JPanel {

	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public Page_2() throws IOException {
		
		this.setPreferredSize(new Dimension(1000,900));
		setLayout(null);
		setBackground(Color.white);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 50, 940, 2);
		add(separator);
		
		JLabel corse_label_1 = new JLabel("\u65F6\u5C1A\u6742\u5FD7");
		corse_label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				    
				
			}
		});
		corse_label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		corse_label_1.setBounds(40, 25, 110, 20);
		add(corse_label_1);
		
		JLabel corse_label_2 = new JLabel("\u6587\u5B66\u540D\u8457");
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
		
		JLabel corse_label_3 = new JLabel("\u4F11\u95F2\u5C0F\u8BF4");
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
		
		JLabel corse_label_4 = new JLabel("\u6F2B\u753B\u4E66");
		corse_label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
			}
		});
		corse_label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		corse_label_4.setBounds(40, 550, 141, 20);
		add(corse_label_4);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(30, 575, 940, 2);
		add(separator_3);
		
		JLabel corse_label_5 = new JLabel("\u5176\u4ED6");
		corse_label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
			}
		});
		corse_label_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		corse_label_5.setBounds(40, 725, 141, 20);
		add(corse_label_5);
		
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(30, 580, 940, 143);
		add(panel_3);
		
		JLabel booklabel_13 = new JLabel("");
		booklabel_13.setBounds(40, 0, 130, 140);
		panel_3.add(booklabel_13);
		
		JLabel booklabel_14 = new JLabel("");
		booklabel_14.setBounds(190, 0, 130, 140);
		panel_3.add(booklabel_14);
		
		JLabel booklabel_15 = new JLabel("");
		booklabel_15.setBounds(340, 0, 130, 140);
		panel_3.add(booklabel_15);
		
		JLabel booklabel_16 = new JLabel("");
		booklabel_16.setBounds(490, 0, 130, 140);
		panel_3.add(booklabel_16);
		
		JLabel booklabel_17 = new JLabel("");
		booklabel_17.setBounds(640, 0, 130, 140);
		panel_3.add(booklabel_17);
		
		JLabel booklabel_18 = new JLabel("");
		booklabel_18.setBounds(800, 0, 130, 140);
		panel_3.add(booklabel_18);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(30, 755, 940, 143);
		add(panel_4);
		
		JLabel booklabel_19 = new JLabel("");
		booklabel_19.setBounds(40, 0, 130, 140);
		panel_4.add(booklabel_19);
		
		JLabel booklabel_20 = new JLabel("");
		booklabel_20.setBounds(190, 0, 130, 140);
		panel_4.add(booklabel_20);
		
		JLabel booklabel_21 = new JLabel("");
		booklabel_21.setBounds(340, 0, 130, 140);
		panel_4.add(booklabel_21);
		
		JLabel booklabel_22 = new JLabel("");
		booklabel_22.setBounds(490, 0, 130, 140);
		panel_4.add(booklabel_22);
		
		JLabel booklabel_23 = new JLabel("");
		booklabel_23.setBounds(640, 0, 130, 140);
		panel_4.add(booklabel_23);
		
		JLabel booklabel_24 = new JLabel("");
		booklabel_24.setBounds(800, 0, 130, 140);
		panel_4.add(booklabel_24);
		
		setLabelBac("7",booklabel_1);
		setLabelBac("8",booklabel_2);
		setLabelBac("9",booklabel_3);
		setLabelBac("7",booklabel_4);
		setLabelBac("8",booklabel_5);
		setLabelBac("9",booklabel_6);
		
		setLabelBac("7",booklabel_7);
		setLabelBac("8",booklabel_8);
		setLabelBac("9",booklabel_9);
		setLabelBac("7",booklabel_10);
		setLabelBac("8",booklabel_11);
		setLabelBac("9",booklabel_12);
		
		setLabelBac("1",booklabel_13);
		setLabelBac("2",booklabel_14);
		setLabelBac("3",booklabel_15);
		setLabelBac("4",booklabel_16);
		setLabelBac("5",booklabel_17);
		setLabelBac("6",booklabel_18);
		
		setLabelBac("1",booklabel_19);
		setLabelBac("2",booklabel_20);
		setLabelBac("3",booklabel_21);
		setLabelBac("4",booklabel_22);
		setLabelBac("5",booklabel_23);
		setLabelBac("6",booklabel_24);
		
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
		
		JButton button_3 = new JButton("\u6362\u4E00\u6279");
		button_3.setBounds(877, 550,80,20);
		add(button_3);
		button_3.setForeground(Color.black);
		button_3.setFocusPainted(false);
		button_3.setContentAreaFilled(false);
		button_3.setText("»»Ò»Åú");
		
		JButton button_4 = new JButton("\u6362\u4E00\u6279");
		button_4.setBounds(877, 725, 80,20);
		add(button_4);
		button_4.setForeground(Color.black);
		button_4.setFocusPainted(false);
		button_4.setContentAreaFilled(false);
		button_4.setText("»»Ò»Åú");
		
		
	}
	 void setLabelBac(String a,JLabel b) throws IOException{
			ImageIcon img = new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator + a + ".jpg");
			img.setImage(img.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT));
			//Icon icon=new ImageIcon(img);
			b.setIcon(img);
		}
}

