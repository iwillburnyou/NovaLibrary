package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
//已登录
public class LoginWin extends JFrame {

	private MyPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWin frame = new LoginWin();
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
	public LoginWin() throws IOException {
		setBackground(Color.WHITE);
		this.setUndecorated(true);  
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);     
		this.setVisible(true);
		setBounds(500, 200, 450, 300);
		contentPane = new MyPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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
		
		JLabel label_1 = new JLabel("");
		setLabelBac("avatar_mask.png", label_1);
		label_1.setBounds(40, 21, 120, 120);
		contentPane.add(label_1);
		
		JLabel label_wel = new JLabel("***\uFF0C\u6B22\u8FCE\u56DE\u6765\uFF01");
		label_wel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_wel.setForeground(Color.WHITE);
		label_wel.setBounds(194, 48, 136, 23);
		contentPane.add(label_wel);
		
		JLabel label_2 = new JLabel("\u7167\u7247\r\n");
		label_2.setForeground(Color.BLACK);
		label_2.setBounds(48, 36, 98, 91);
		contentPane.add(label_2);
	}
	 void setPanelBac(String a,MyPanel b) throws IOException{
			Image[] array = new Image[10];
			Image topimg = ImageIO.read(new File(a));//根据你实际情况改文件路径吧
			array[0] = topimg;
			b.setPreferredSize(new Dimension(1000, 105));       
			b.setImg(topimg);
		}
	 void setLabelBac(String a,JLabel b) throws IOException{
		    Toolkit toolkit = Toolkit.getDefaultToolkit();
		    Dimension scmSize = toolkit.getScreenSize();
		    Image img = toolkit.getImage("image" + File.separator + a);
		    Icon icon=new ImageIcon(img);
			b.setIcon(icon);
		}
	 private void close() {
			// TODO Auto-generated method stub
			this.dispose();
		}

}
