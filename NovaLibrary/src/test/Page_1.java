package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.LayoutManager;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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

public class Page_1 extends JPanel {

	/**
	 * Create the panel.
	 */
	public Page_1() {
		
		this.setPreferredSize(new Dimension(1000,900));
		setLayout(null);
		setBackground(Color.white);
		
		final JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(30, 623, 940, 220);
		panel.setVisible(false);
		add(panel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 50, 940, 2);
		add(separator);
		
		JLabel corse_label_1 = new JLabel("\u5EFA\u7B51");
		corse_label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(panel.isVisible()){
					panel.setVisible(false);
				}
				else {
					panel.setVisible(true);
					panel.setLocation(30,60);
				}
				    
				
			}
		});
		corse_label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		corse_label_1.setBounds(40, 25, 110, 20);
		add(corse_label_1);
		
		JLabel corse_label_2 = new JLabel("\u673A\u68B0\u5DE5\u7A0B");
		corse_label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(panel.isVisible()){
					panel.setVisible(false);
				}
				else {
					panel.setVisible(true);
					panel.setLocation(30,95);
				}
			}
		});
		corse_label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		corse_label_2.setBounds(40, 60, 120, 20);
		add(corse_label_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(30, 85, 940, 2);
		add(separator_1);
		
		JLabel corse_label_3 = new JLabel("\u80FD\u6E90\u4E0E\u73AF\u5883");
		corse_label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(panel.isVisible()){
					panel.setVisible(false);
				}
				else {
					panel.setVisible(true);
					panel.setLocation(30,130);
				}
			}
		});
		corse_label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		corse_label_3.setBounds(40, 95, 141, 20);
		add(corse_label_3);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(30, 120, 940, 2);
		add(separator_2);
		
		JLabel corse_label_4 = new JLabel("\u4FE1\u606F\u79D1\u5B66\u4E0E\u5DE5\u7A0B");
		corse_label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(panel.isVisible()){
					panel.setVisible(false);
				}
				else {
					panel.setVisible(true);
					panel.setLocation(30,165);
				}
			}
		});
		corse_label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		corse_label_4.setBounds(40, 130, 141, 20);
		add(corse_label_4);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(30, 155, 940, 2);
		add(separator_3);
		
		JLabel corse_label_5 = new JLabel("\u571F\u6728\u5DE5\u7A0B");
		corse_label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(panel.isVisible()){
					panel.setVisible(false);
				}
				else {
					panel.setVisible(true);
					panel.setLocation(30,200);
				}
			}
		});
		corse_label_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		corse_label_5.setBounds(40, 165, 141, 20);
		add(corse_label_5);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(30, 190, 940, 2);
		add(separator_4);
		
		JLabel corse_label_6 = new JLabel("\u7535\u5B50\u79D1\u5B66\u4E0E\u5DE5\u7A0B");
		corse_label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(panel.isVisible()){
					panel.setVisible(false);
				}
				else {
					panel.setVisible(true);
					panel.setLocation(30,235);
				}
			}
		});
		corse_label_6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		corse_label_6.setBounds(40, 200, 141, 20);
		add(corse_label_6);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(30, 225, 940, 2);
		add(separator_5);
		
		JLabel corse_label_7 = new JLabel("\u6570\u5B66");
		corse_label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(panel.isVisible()){
					panel.setVisible(false);
				}
				else {
					panel.setVisible(true);
					panel.setLocation(30,270);
				}
			}
		});
		corse_label_7.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		corse_label_7.setBounds(40, 235, 141, 20);
		add(corse_label_7);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(30, 260, 940, 2);
		add(separator_6);
		
		JLabel corse_label_8 = new JLabel("\u81EA\u52A8\u5316");
		corse_label_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(panel.isVisible()){
					panel.setVisible(false);
				}
				else {
					panel.setVisible(true);
					panel.setLocation(30,305);
				}
			}
		});
		corse_label_8.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		corse_label_8.setBounds(40, 270, 141, 20);
		add(corse_label_8);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(30, 295, 940, 2);
		add(separator_7);
		
		JLabel corse_label_9 = new JLabel("\u8BA1\u7B97\u673A\u79D1\u5B66\u4E0E\u5DE5\u7A0B");
		corse_label_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(panel.isVisible()){
					panel.setVisible(false);
				}
				else {
					panel.setVisible(true);
					panel.setLocation(30,340);
				}
			}
		});
		corse_label_9.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		corse_label_9.setBounds(40, 305, 141, 20);
		add(corse_label_9);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(30, 330, 940, 2);
		add(separator_8);
		
		JLabel corse_label_10 = new JLabel("\u7269\u7406");
		corse_label_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(panel.isVisible()){
					panel.setVisible(false);
				}
				else {
					panel.setVisible(true);
					panel.setLocation(30,375);
				}
			}
		});
		corse_label_10.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		corse_label_10.setBounds(40, 340, 141, 20);
		add(corse_label_10);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setBounds(30, 365, 940, 2);
		add(separator_9);
		
		JLabel corse_label_11 = new JLabel("\u751F\u7269\u79D1\u5B66\u4E0E\u533B\u5B66\u5DE5\u7A0B");
		corse_label_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(panel.isVisible()){
					panel.setVisible(false);
				}
				else {
					panel.setVisible(true);
					panel.setLocation(30,410);
				}
			}
		});
		corse_label_11.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		corse_label_11.setBounds(40, 375, 184, 20);
		add(corse_label_11);
		
		JSeparator separator_10 = new JSeparator();
		separator_10.setBounds(30, 400, 940, 2);
		add(separator_10);
		
		JLabel corse_label_12 = new JLabel("\u6750\u6599\u79D1\u5B66\u4E0E\u5DE5\u7A0B");
		corse_label_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(panel.isVisible()){
					panel.setVisible(false);
				}
				else {
					panel.setVisible(true);
					panel.setLocation(30,445);
				}
			}
		});
		corse_label_12.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		corse_label_12.setBounds(40, 410, 141, 20);
		add(corse_label_12);
		
		JSeparator separator_11 = new JSeparator();
		separator_11.setBounds(30, 435, 940, 2);
		add(separator_11);
		
		JLabel corse_label_13 = new JLabel("\u4EBA\u6587");
		corse_label_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(panel.isVisible()){
					panel.setVisible(false);
				}
				else {
					panel.setVisible(true);
					panel.setLocation(30,480);
				}
			}
		});
		corse_label_13.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		corse_label_13.setBounds(40, 445, 141, 20);
		add(corse_label_13);
		
		JSeparator separator_12 = new JSeparator();
		separator_12.setBounds(30, 470, 940, 2);
		add(separator_12);
		
		JLabel corse_label_14 = new JLabel("\u7ECF\u6D4E\u7BA1\u7406");
		corse_label_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(panel.isVisible()){
					panel.setVisible(false);
				}
				else {
					panel.setVisible(true);
					panel.setLocation(30,515);
				}
			}
		});
		corse_label_14.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		corse_label_14.setBounds(40, 480, 141, 20);
		add(corse_label_14);
		
		JSeparator separator_13 = new JSeparator();
		separator_13.setBounds(30, 505, 940, 2);
		add(separator_13);
		
		JLabel corse_label_15 = new JLabel("\u7535\u6C14\u5DE5\u7A0B");
		corse_label_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(panel.isVisible()){
					panel.setVisible(false);
				}
				else {
					panel.setVisible(true);
					panel.setLocation(30,550);
				}
			}
		});
		corse_label_15.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		corse_label_15.setBounds(40, 515, 141, 20);
		add(corse_label_15);
		
		JSeparator separator_14 = new JSeparator();
		separator_14.setBounds(30, 540, 940, 2);
		add(separator_14);
		
		JLabel corse_label_16 = new JLabel("\u5916\u56FD\u8BED");
		corse_label_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(panel.isVisible()){
					panel.setVisible(false);
				}
				else {
					panel.setVisible(true);
					panel.setLocation(30,585);
				}
			}
		});
		corse_label_16.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		corse_label_16.setBounds(40, 550, 141, 20);
		add(corse_label_16);
		
		JSeparator separator_15 = new JSeparator();
		separator_15.setBounds(30, 575, 940, 2);
		add(separator_15);
		
		JLabel corse_label_17 = new JLabel("\u5316\u5B66\u5316\u5DE5");
		corse_label_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(panel.isVisible()){
					panel.setVisible(false);
				}
				else {
					panel.setVisible(true);
					panel.setLocation(30,620);
				}
			}
		});
		corse_label_17.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		corse_label_17.setBounds(40, 585, 141, 20);
		add(corse_label_17);
		
		JSeparator separator_16 = new JSeparator();
		separator_16.setBounds(30, 610, 940, 2);
		add(separator_16);
		
		
		
	}
}
