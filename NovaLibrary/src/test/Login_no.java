package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
//未登录
public class Login_no extends JFrame {

	private MyPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_no frame = new Login_no();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Login_no() throws IOException {
		setBackground(Color.WHITE);
		this.setUndecorated(true);  
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);     
		this.setVisible(true);
		setBounds(500, 200, 450, 300);
		contentPane = new MyPanel();
		setContentPane(contentPane);
		setPanelBac("D:\\srtp_hu\\pro_2\\pro_2\\pro_1\\image\\topbg.png",contentPane);
		contentPane.setLayout(null);
		
		JButton button_1 = new JButton("");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				close();
			}
		});
		button_1.setRolloverIcon(new ImageIcon("D:\\srtp_hu\\pro_2\\pro_2\\pro_1\\image\\nav_close_click.png"));
		button_1.setIcon(new ImageIcon("D:\\srtp_hu\\pro_2\\pro_2\\pro_1\\image\\nav_close.png"));
		button_1.setFocusPainted(false);
		button_1.setBorderPainted(false);
		button_1.setContentAreaFilled(false);
		button_1.setBounds(418, 0, 32, 23);
		contentPane.add(button_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 89, 200, 201);
		contentPane.add(panel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(220, 89, 220, 201);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setBounds(10, 25, 58, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setBounds(10, 50, 58, 15);
		panel.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(78, 22, 132, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(78, 47, 132, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button_a = new JButton("\u767B\u9646");
		button_a.setBounds(20, 80, 67, 23);
		panel.add(button_a);
		
		JButton button_b = new JButton("\u6CE8\u518C");
		button_b.setBounds(58, 148, 93, 23);
		panel.add(button_b);
		
		JButton button_c = new JButton("\u5FD8\u8BB0\u5BC6\u7801");
		button_c.setBounds(97, 80, 93, 23);
		panel.add(button_c);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 130, 200, 2);
		panel.add(separator);
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBackground(Color.WHITE);
	}

	void setPanelBac(String a,MyPanel b) throws IOException{
		Image[] array = new Image[10];
		Image topimg = ImageIO.read(new File(a));//根据你实际情况改文件路径吧
		array[0] = topimg;
		b.setPreferredSize(new Dimension(1000, 105));       
		b.setImg(topimg);
	}
	private void close() {
		// TODO Auto-generated method stub
		this.dispose();
	}
}
