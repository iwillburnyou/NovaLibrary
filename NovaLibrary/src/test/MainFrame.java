package test;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JSeparator;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private Point pressedPoint;
	private JTextField textField;
	int i=0;
	
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					MainFrame frame = new MainFrame();
					//Thread a=new Thread(rollPicture_1);
					/*Thread b=new Thread(rollPicture_2);
					Thread c=new Thread(rollPicture_3);
					Thread d=new Thread(rollPicture_4);
					Thread e=new Thread(rollPicture_5);*/
					
				    //a.start();
					//frame.setVisible(false);
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
	public MainFrame() throws IOException {
		setBackground(Color.WHITE);
		this.setUndecorated(true);  
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);     
		this.setBounds(200,20, 1000, 700);    
		this.setVisible(true);
		final JLabel bacLabel_4 = new JLabel("");
		
		//this.setOpacity(1);
	
		//Ö÷Ãæ°å
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		contentPane.setLayout(null);
		this.setContentPane(contentPane);
		
		
 		
		//±êÌâÀ¸
		MyPanel topPanel=new MyPanel();
		topPanel.setBounds(0, 0, 1000, 121);
		setPanelBac("nav_bg.png", topPanel);
		topPanel.addMouseMotionListener(new  MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){   
				topPanel_mouseDragged(e);    
				} 
			});
		topPanel.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){  
				topPanel_mousePressed(e);     
				}      
			});
		contentPane.add(topPanel);
		
		
		//Èý½Ç±êÇ©
		final JLabel lblA = new JLabel("");
		lblA.setBounds(283,61, 71, 37);
		setLabelBac_1("nav_checked_arrow.png",lblA);
		lblA.setLocation(320, 61);
		topPanel.setLayout(null);
		topPanel.add(lblA);
		
		
		//¿ØÖÆÇø ×î´ó ×îÐ¡ ¹Ø±Õ
		JPanel controlJP=new JPanel();
		controlJP.setBounds(930, 7, 60, 22);
		controlJP.setBorder(null);
		controlJP.setPreferredSize(new Dimension(60,22));
		controlJP.setOpaque(false);
		controlJP.setLayout(new GridLayout(1,0,0,0));
		topPanel.add(controlJP);
		//×îÐ¡»¯
		JButton minJB=new JButton();
		controlJP.add(minJB);
		minJB.setRolloverIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
                + "/" +"image"+ File.separator+"nav_minimize_click.png"));
		minJB.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				minJB_actionPerformed(e);
			}
		 });
		 minJB.setFocusPainted(false);
		 minJB.setBorderPainted(false);
		 minJB.setContentAreaFilled(false);
		 minJB.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"nav_minimize.png"));
		 
		 //×î´ó»¯
		 JToggleButton maxJB=new JToggleButton();
		 controlJP.add(maxJB);
		 maxJB.setRolloverIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"nav_maximize_click.png"));
		 maxJB.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				maxJB_itemStateChanged(e);
			}
		 });
		 
		 maxJB.setRolloverSelectedIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"nav_maximize_click.png"));
		 maxJB.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"nav_maximize.png"));
		 maxJB.setFocusPainted(false);
		 maxJB.setBorderPainted(false);
		 maxJB.setContentAreaFilled(false);
		 	 
		 //¹Ø±Õ
		 JButton closeJB=new JButton();
		 controlJP.add(closeJB);
		 closeJB.addActionListener(new ActionListener(){
    		 public void actionPerformed(ActionEvent e){
    			 closeJB_actionPerformed(e);
    		 }
		 });
		 closeJB.setRolloverIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"nav_close_click.png"));
		 closeJB.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"nav_close.png"));
		 closeJB.setFocusPainted(false);
		 closeJB.setBorderPainted(false);
		 closeJB.setContentAreaFilled(false);
		 
		 //²Ëµ¥Ãæ°å
		 JPanel panel = new JPanel();
		 panel.setBounds(0, 84, 1000, 37);
		 panel.setBackground(new Color(42, 42, 66));
		 topPanel.add(panel);
		 panel.setLayout(null);
		
		 final JLabel bacLabel_3 = new JLabel("");
		 setLabelBac_1("btn.png",bacLabel_3);
		 bacLabel_3.setBounds(280, 8, 115, 23);
		 
		 //Ê×Ò³ µÚÒ»¿é Êéµ¥¼°ÍÆ¼ö
		 final MyPanel panel_1=new MyPanel();
		 panel_1.setBackground(Color.WHITE);
		 setPanelBac("f.jpg",panel_1);
		 panel_1.setBounds(0, 120, 1000, 250);
		 contentPane.add(panel_1);
		 panel_1.setLayout(null);
		 bacLabel_4.setBounds(340, 95, 120, 120);
		 panel_1.add(bacLabel_4);
		 //Ê×Ò³µÚ¶þ¿é  ÈÈÃÅ
		 final JPanel panel_3 = new JPanel();
		 panel_3.setBackground(Color.WHITE);
		 panel_3.setBounds(0, 370, 1000, 300);
		 contentPane.add(panel_3);
		 panel_3.setLayout(null);	
		 //×¨ÒµÑ§Ï°
		 Page_1 page=new Page_1();
		 final JScrollPane page_1=new JScrollPane(page);
		 page_1.setBounds(0,120,1100,550);
		 page_1.setHorizontalScrollBarPolicy( 
		 JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
		 page_1.setVerticalScrollBarPolicy( 
		 JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		 JScrollBar bar = page_1.getVerticalScrollBar();
		 bar.setBackground(Color.WHITE);
		 page_1.getVerticalScrollBar().setUnitIncrement(30);
		 page_1.setVisible(false);
	 	 contentPane.add(page_1);
	 	 
		 //²Ëµ¥°´Å¥
		 final JButton button_1 = new JButton("New button");
		 button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		 button_1.setForeground(Color.WHITE);
		 button_1.setFocusPainted(false);
		 button_1.setBorderPainted(false);
		 button_1.setContentAreaFilled(false);
		 button_1.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mousePressed(MouseEvent arg0) {
		 		bacLabel_3.setLocation(280,8);
		 		panel_1.setVisible(true);
		 		panel_3.setVisible(true);
		 	}
		 });
		 button_1.setBounds(275, 8, 110, 23);
		 button_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 	}
		 });
		 
		 final JButton button_3 = new JButton("New button");
		 button_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		 button_3.setForeground(Color.WHITE);
		 button_3.setFocusPainted(false);
		 button_3.setBorderPainted(false);
		 button_3.setContentAreaFilled(false);
		 button_3.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mousePressed(MouseEvent arg0) {
		 		bacLabel_3.setLocation(520,8);
		 		panel_1.setVisible(false);
		 		panel_3.setVisible(false);
		 		
		 	}
		 });
		 button_3.setBounds(520, 8, 110, 23);
		 
		 final JButton button_2 = new JButton("New button");
		 button_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		 button_2.setForeground(Color.WHITE);
		 button_2.setFocusPainted(false);
		 button_2.setBorderPainted(false);
		 button_2.setContentAreaFilled(false);
		 button_2.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mousePressed(MouseEvent arg0) {
		 		bacLabel_3.setLocation(400,8);
		 		panel_1.setVisible(false);
		 		panel_3.setVisible(false);
		 		page_1.setVisible(true);
		 	}
		 		
		 	
		 });
		 button_2.setBounds(400, 8, 110, 23);
		 
		 final JButton button_4 = new JButton("New button");
		 button_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		 button_4.setForeground(Color.WHITE);
		 button_4.setFocusPainted(false);
		 button_4.setBorderPainted(false);
		 button_4.setContentAreaFilled(false);
		 button_4.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mousePressed(MouseEvent arg0) {
		 		bacLabel_3.setLocation(640,8);
		 		panel_1.setVisible(false);
		 		panel_3.setVisible(false);
		 	}
		 });
		 button_4.setBounds(640, 8, 110, 23);
		 
		 
		 button_1.setText("\u9996\u9875");
	 	 button_2.setText("\u4E13\u4E1A\u5B66\u4E60");
	 	 button_3.setText("\u4F11\u95F2\u5A31\u4E50");
	 	 button_4.setText("\u5065\u5EB7\u751F\u6D3B");
	 	 panel.add(button_1);
		 panel.add(button_3);
		 panel.add(button_2);
		 panel.add(button_4);
		 panel.add(bacLabel_3);
		 
	 	 
	 	
		 
		 
		 JButton button_a = new JButton("\u8BFA\u74E6\u4E66\u9662");
		 button_a.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mousePressed(MouseEvent arg0) {
		 		lblA.setLocation(320,61);
		 		bacLabel_3.setLocation(280,8);
		 		button_1.setText("Ê×Ò³");
		 		button_2.setText("×¨ÒµÑ§Ï°");
		 		button_3.setText("ÐÝÏÐÓéÀÖ");
		 		button_4.setText("½¡¿µÉú»î");
		 	}
		 });
		 button_a.setBounds(284, 29, 87, 36);
		 button_a.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 	}
		 });
		 
		 JButton button_b = new JButton("\u6211\u7684\u4E66\u9662");
		 button_b.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mousePressed(MouseEvent arg0) {
		 		lblA.setLocation(437,61);
		 		bacLabel_3.setLocation(280,8);
		 		button_1.setText("ÒÑÊÕ²ØÊé¼®");
		 		button_2.setText("ÒÑ¹ºÂòÊé¼®");
		 		button_3.setText("ÒÑÊÛ³öÊé¼®");
		 		button_4.setText("´ýÊÛÊé¼®");
		 	}
		 });
		 button_b.setBounds(402, 29, 87, 36);
		 
		 JButton button_c = new JButton("\u6211\u7684\u4E66\u5305");
		 button_c.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mousePressed(MouseEvent arg0) {
		 		lblA.setLocation(554,61);
		 		bacLabel_3.setLocation(280,8);
		 		button_1.setText("¹ºÎï³µ");
		 		button_2.setText("Çó¹ºÊé¼®");
		 		button_3.setText("ËÑË÷ÀúÊ·");
		 		button_4.setText("ÏµÍ³ÇóÊé");
		 	}
		 });
		 button_c.setBounds(514, 29, 98, 36);
		 //menupanel.setBounds(0, 0, 1000, 121); 
		 Image[] array_1 = new Image[10];
	     Image backimg  = ImageIO.read(new File(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"volume_bg.png"));//¸ù¾ÝÄãÊµ¼ÊÇé¿ö¸ÄÎÄ¼þÂ·¾¶°É
		 array_1[0] = backimg;
		 Dimension dim=new  Dimension(backimg.getWidth(this),backimg.getHeight(this));
		
		 topPanel.add(button_a);
		 topPanel.add(button_b);
		 topPanel.add(button_c);
		 
		 JLabel lblSuper = new JLabel("Supernova");
		 lblSuper.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 18));
		 lblSuper.setForeground(Color.WHITE);
		 lblSuper.setBounds(10, 10, 105, 22);
		 topPanel.add(lblSuper);
		 
		 JButton button_back_1 = new JButton("");
		 button_back_1.setBounds(20, 50, 32, 23);
		 topPanel.add(button_back_1);
		 button_back_1.setRolloverIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"back_click.png"));
		 button_back_1.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"back.png"));
		 button_back_1.setFocusPainted(false);
		 button_back_1.setBorderPainted(false);
		 button_back_1.setContentAreaFilled(false);
		 
		 
		 JButton button_back_2 = new JButton("");
		 button_back_2.setBounds(55, 50, 32, 23);
		 topPanel.add(button_back_2);
		 button_back_2.setRolloverIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"back_click_1.png"));
		 button_back_2.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"back_1.png"));
		 button_back_2.setFocusPainted(false);
		 button_back_2.setBorderPainted(false);
		 button_back_2.setContentAreaFilled(false);
		 
		 JButton searchButton = new JButton("");
		 searchButton.setBounds(165, 50, 23, 23);
		 topPanel.add(searchButton);
		 searchButton.setRolloverIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"nav_srch_btn_click.png"));
		 searchButton.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"nav_srch_btn.png"));
		 searchButton.setFocusPainted(false);
		 searchButton.setBorderPainted(false);
		 searchButton.setContentAreaFilled(false);
		 
		 textField = new JTextField();
		 textField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		 textField.setForeground(Color.LIGHT_GRAY);
		 textField.setText("\u8BF7\u8F93\u5165\u4E66\u540D");
		 textField.setBounds(102, 53, 82, 19);
		 topPanel.add(textField);
		 textField.setColumns(10);
		 textField.setBorder(BorderFactory.createEmptyBorder());
		 
		 JLabel searchLabel = new JLabel("");
		 searchLabel.setBounds(94, 44, 150, 36);
		 topPanel.add(searchLabel);
		 setLabelBac_1("nav_srch_filter.png", searchLabel);
		 
		 JLabel lblNewLabel = new JLabel("\u4E1C\u5927\u5728\u7EBF\u4E8C\u624B\u4E66\u5E02\u573A");
		 lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 9));
		 lblNewLabel.setForeground(Color.WHITE);
		 lblNewLabel.setBounds(110, 17, 87, 15);
		 topPanel.add(lblNewLabel);
		 
		 JButton loginButton = new JButton("\u672A\u767B\u5F55");
		 loginButton.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mousePressed(MouseEvent arg0) {
		 		LoginWin a;
				try {
					a = new LoginWin();
					a.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 		
		 	}
		 });
		 loginButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		 loginButton.setForeground(Color.WHITE);
		 loginButton.setBounds(882, 50, 70, 23);
		 loginButton.setFocusPainted(false);
		 loginButton.setContentAreaFilled(false);
		 loginButton.setText("Î´µÇÂ¼");
		 //loginButton.setBorder(new LineBorder(Color.gray, 1, true));
		 topPanel.add(loginButton);
		 
		 JButton setButton = new JButton("");
		 setButton.setBounds(956, 50, 35, 23);
		 setButton.setRolloverIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"nav_icon_setting_click.png"));
		 setButton.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"nav_icon_setting.png"));
		 setButton.setFocusPainted(false);
		 setButton.setBorderPainted(false);
		 setButton.setContentAreaFilled(false);
		 topPanel.add(setButton);
		
		
		
		
		final JLabel rollPicture_1 = new JLabel();
		rollPicture_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				try {
					setLabelBac_1("trans.png",bacLabel_4);
					bacLabel_4.setLocation(340,95);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		});
		final JLabel rollPicture_2 = new JLabel();
		rollPicture_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				try {
					setLabelBac_1("trans.png",bacLabel_4);
					bacLabel_4.setLocation(460,95);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		final JLabel rollPicture_3 = new JLabel();
		rollPicture_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				try {
					setLabelBac_1("trans.png",bacLabel_4);
					bacLabel_4.setLocation(580,95);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		final JLabel rollPicture_4 = new JLabel();
		rollPicture_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				try {
					setLabelBac_1("trans.png",bacLabel_4);
					bacLabel_4.setLocation(700,95);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		final JLabel rollPicture_5 = new JLabel();
		rollPicture_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				try {
					setLabelBac_1("trans.png",bacLabel_4);
					bacLabel_4.setLocation(820,95);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
	
		setLabelBac("0",rollPicture_1);
		setLabelBac("1",rollPicture_2);
		setLabelBac("2",rollPicture_3);
		setLabelBac("3",rollPicture_4);
		setLabelBac("4",rollPicture_5);
		
		rollPicture_1.setText("a");
		rollPicture_1.setBounds(340, 95, 120, 120);
		panel_1.add(rollPicture_1);
		
		
		rollPicture_2.setText("b");
		rollPicture_2.setBounds(460, 95, 120, 120);
		panel_1.add(rollPicture_2);
		
		
		rollPicture_3.setText("a");
		rollPicture_3.setBounds(580, 95, 120, 120);
		panel_1.add(rollPicture_3);
		
		
		rollPicture_4.setText("b");
		rollPicture_4.setBounds(700, 95, 120, 120);
		panel_1.add(rollPicture_4);
		
		
		rollPicture_5.setText("b");
		rollPicture_5.setBounds(820, 95, 120, 120);
		panel_1.add(rollPicture_5);
		
		JButton button_back_3 = new JButton("");
		button_back_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				    
					try {
						setLabelBac_1("null",bacLabel_4);
						if(i>0){
							i--;
							String s = String.valueOf(i);
							String s_1 = String.valueOf(i+1);
							String s_2 = String.valueOf(i+2);
							String s_3 = String.valueOf(i+3);
							String s_4= String.valueOf(i+4);
							setLabelBac(s,rollPicture_1);
							setLabelBac(s_1,rollPicture_2);
							setLabelBac(s_2,rollPicture_3);
							setLabelBac(s_3,rollPicture_4);
							setLabelBac(s_4,rollPicture_5);
							}
						else{i=0;}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				
			}
		});
		button_back_3.setRolloverIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
                + "/" +"image"+ File.separator+"previous.png"));
		button_back_3.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
                + "/" +"image"+ File.separator+"previous.png"));
		button_back_3.setFocusPainted(false);
		button_back_3.setBorderPainted(false);
		button_back_3.setContentAreaFilled(false);
		button_back_3.setBounds(300, 140, 25, 23);
		panel_1.add(button_back_3);
		
		
		JButton button_back_4 = new JButton("");
		button_back_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				try {
					setLabelBac_1("null",bacLabel_4);
					if(i<5){
						i++;
						String s = String.valueOf(i);
						String s_1 = String.valueOf(i+1);
						String s_2 = String.valueOf(i+2);
						String s_3 = String.valueOf(i+3);
						String s_4= String.valueOf(i+4);
						setLabelBac(s,rollPicture_1);
						setLabelBac(s_1,rollPicture_2);
						setLabelBac(s_2,rollPicture_3);
						setLabelBac(s_3,rollPicture_4);
						setLabelBac(s_4,rollPicture_5);
						}
					else{i=5;}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		button_back_4.setRolloverIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
                + "/" +"image"+ File.separator+"next.png"));
		button_back_4.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
                + "/" +"image"+ File.separator+"next.png"));
		button_back_4.setFocusPainted(false);
		button_back_4.setBorderPainted(false);
		button_back_4.setContentAreaFilled(false);
		button_back_4.setBounds(950, 140, 25, 23);
		panel_1.add(button_back_4);
		
		JLabel bacLabel_1 = new JLabel("");
		bacLabel_1.setBounds(316, 51, 626, 130);
		panel_1.add(bacLabel_1);
		
		JLabel label = new JLabel("\u731C\u4F60\u559C\u6B22");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		label.setForeground(Color.WHITE);
		label.setBounds(340, 35, 81, 24);
		panel_1.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("\u9082\u9005\u7F8E\u597D\uFF0C\u603B\u5728\u4E0D\u7ECF\u610F\u95F4\uFF01");
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(340, 65, 180, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("\u4F60\u7684\u4E66\u5355");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(34, 35, 81, 24);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("\u6839\u636E\u60A8\u7684\u4FE1\u606F\uFF0C\u4E3A\u4F60\u5B9A\u5236\u7684\u4E66\u5355\uFF01");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(34, 66, 219, 14);
		panel_1.add(label_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(0, 670, 1000, 33);
		contentPane.add(panel_2);
		
		
		
		final JLabel label_3 = new JLabel("");
		label_3.setBounds(69,0, 130, 140);
		setLabelBac_1("trans.png",label_3);
		label_3.setVisible(false);
		panel_3.add(label_3);
		
		JLabel label_4 = new JLabel("\u70ED\u95E8\u4E66\u7C4D");
		label_4.setForeground(new Color(255, 69, 0));
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		label_4.setBackground(Color.WHITE);
		label_4.setBounds(33, 27, 70, 30);
		panel_3.add(label_4);
		
		JLabel label_5 = new JLabel("\u4ECA\u65E5\u70ED\u95E8\u4E66\u7C4D\u63A8\u8350");
		label_5.setForeground(Color.DARK_GRAY);
		label_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		label_5.setBounds(113, 37, 139, 15);
		panel_3.add(label_5);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(33, 62, 936, 1);
		panel_3.add(separator);
		
		JLabel booklabel_1 = new JLabel("");
		booklabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				label_3.setVisible(true);
				
				label_3.setLocation(33,92);
				
			}
		});
		booklabel_1.setBounds(33, 92, 130, 140);
		panel_3.add(booklabel_1);
		setLabelBac("5",booklabel_1);
		
		
		JLabel booklabel_i_1 = new JLabel("\u7B2C\u4E00\u672C\u4E66\u4E66\u540D");
		booklabel_i_1.setForeground(Color.DARK_GRAY);
		booklabel_i_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		booklabel_i_1.setBounds(43, 242, 87, 22);
		panel_3.add(booklabel_i_1);
		
		JLabel booklabel_i_2 = new JLabel("\u4EF7\u683C\u548C\u4F5C\u8005");
		booklabel_i_2.setForeground(Color.DARK_GRAY);
		booklabel_i_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		booklabel_i_2.setBounds(43, 263, 81, 15);
		panel_3.add(booklabel_i_2);
		
		JLabel booklabel_i_3 = new JLabel("\u7B2C\u4E8C\u672C\u4E66\u4E66\u540D");
		booklabel_i_3.setForeground(Color.DARK_GRAY);
		booklabel_i_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		booklabel_i_3.setBounds(204, 242, 87, 22);
		panel_3.add(booklabel_i_3);
		
		JLabel booklabel_i_4 = new JLabel("\u4EF7\u683C\u548C\u4F5C\u8005");
		booklabel_i_4.setForeground(Color.DARK_GRAY);
		booklabel_i_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		booklabel_i_4.setBounds(204, 263, 81, 15);
		panel_3.add(booklabel_i_4);
		
		JLabel booklabel_i_5 = new JLabel("\u7B2C\u4E09\u672C\u4E66\u4E66\u540D");
		booklabel_i_5.setForeground(Color.DARK_GRAY);
		booklabel_i_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		booklabel_i_5.setBounds(364, 242, 87, 22);
		panel_3.add(booklabel_i_5);
		
		JLabel booklabel_i_6 = new JLabel("\u4EF7\u683C\u548C\u4F5C\u8005");
		booklabel_i_6.setForeground(Color.DARK_GRAY);
		booklabel_i_6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		booklabel_i_6.setBounds(364, 263, 81, 15);
		panel_3.add(booklabel_i_6);
		
		JLabel booklabel_2 = new JLabel("");
		booklabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				label_3.setVisible(true);
				label_3.setBackground(Color.gray);
				label_3.setLocation(194, 92);
			}
		});
		booklabel_2.setBounds(194, 92, 130, 140);
		panel_3.add(booklabel_2);
		setLabelBac("6",booklabel_2);
		
		JLabel booklabel_3 = new JLabel("");
		booklabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				label_3.setVisible(true);
				label_3.setBackground(Color.gray);
				label_3.setLocation(352, 92);
			}
		});
		booklabel_3.setBounds(354, 92, 130, 140);
		panel_3.add(booklabel_3);
		setLabelBac("7",booklabel_3);
		
		JLabel booklabel_4 = new JLabel("");
		booklabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				label_3.setVisible(true);
				label_3.setBackground(Color.gray);
				label_3.setLocation(514, 92);
			}
		});
		booklabel_4.setBounds(514, 92, 130, 140);
		panel_3.add(booklabel_4);
		setLabelBac("8",booklabel_4);
		
		JLabel booklabel_i_7 = new JLabel("\u7B2C\u56DB\u672C\u4E66\u4E66\u540D");
		booklabel_i_7.setForeground(Color.DARK_GRAY);
		booklabel_i_7.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		booklabel_i_7.setBounds(524, 242, 87, 22);
		panel_3.add(booklabel_i_7);
		
		JLabel booklabel_i_8 = new JLabel("\u4EF7\u683C\u548C\u4F5C\u8005");
		booklabel_i_8.setForeground(Color.DARK_GRAY);
		booklabel_i_8.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		booklabel_i_8.setBounds(524, 263, 81, 15);
		panel_3.add(booklabel_i_8);
		
		JLabel booklabel_i_9 = new JLabel("\u7B2C\u4E94\u672C\u4E66\u4E66\u540D");
		booklabel_i_9.setForeground(Color.DARK_GRAY);
		booklabel_i_9.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		booklabel_i_9.setBounds(687, 242, 87, 22);
		panel_3.add(booklabel_i_9);
		
		JLabel booklabel_i_10 = new JLabel("\u4EF7\u683C\u548C\u4F5C\u8005");
		booklabel_i_10.setForeground(Color.DARK_GRAY);
		booklabel_i_10.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		booklabel_i_10.setBounds(687, 263, 81, 15);
		panel_3.add(booklabel_i_10);
		
		JLabel booklabel_i_12 = new JLabel("\u4EF7\u683C\u548C\u4F5C\u8005");
		booklabel_i_12.setForeground(Color.DARK_GRAY);
		booklabel_i_12.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		booklabel_i_12.setBounds(849, 263, 81, 15);
		panel_3.add(booklabel_i_12);
		
		JLabel booklabel_i_11 = new JLabel("\u7B2C\u516D\u672C\u4E66\u4E66\u540D");
		booklabel_i_11.setForeground(Color.DARK_GRAY);
		booklabel_i_11.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		booklabel_i_11.setBounds(849, 242, 87, 22);
		panel_3.add(booklabel_i_11);
		
		JLabel booklabel_5 = new JLabel("");
		booklabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				label_3.setVisible(true);
				label_3.setBackground(Color.gray);
				label_3.setLocation(677, 92);
			}
		});
		booklabel_5.setBounds(677, 92, 130, 140);
		panel_3.add(booklabel_5);
		setLabelBac("8",booklabel_5);
		
		JLabel booklabel_6 = new JLabel("");
		booklabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				label_3.setVisible(true);
				label_3.setBackground(Color.gray);
				label_3.setLocation(839, 92);
			}
		});
		booklabel_6.setBounds(839, 92, 130, 140);
		panel_3.add(booklabel_6);
		setLabelBac("9",booklabel_6);
		
    	 }
   
     private static Color getMixedColor(Color c1, float pct1, Color c2, float pct2) {
    	 float[] clr1 = c1.getComponents(null);
    	 float[] clr2 = c2.getComponents(null);
    	 for (int i = 0; i < clr1.length; i++) {
    		 clr1[i] = (clr1[i] * pct1) + (clr2[i] * pct2);
    		 }
    	 return new Color(clr1[0], clr1[1], clr1[2], clr1[3]);
    	 }
	   void topPanel_mouseDragged(MouseEvent e){
		 
		 Point point=e.getPoint();
		 Point localPoint=this.getLocation();
		 
		 int x=point.x+localPoint.x-pressedPoint.x;
		 int y=point.y+localPoint.y-pressedPoint.y;
		 
		 setLocation(x,y);    	 
    	 
      }
	   
	   void topPanel_mousePressed(MouseEvent e){
		   pressedPoint=e.getPoint();
	   }
	   
	   void minJB_actionPerformed(ActionEvent e){
		   this.setExtendedState(ICONIFIED);
	   }
	   
	   void maxJB_itemStateChanged(ItemEvent e){
		   if(e.getStateChange()==ItemEvent.SELECTED){
			   this.setExtendedState(MAXIMIZED_BOTH);
		   }else{
			   this.setExtendedState(NORMAL);
		   }
	   }
	   
	   void closeJB_actionPerformed(ActionEvent e){
		   
		   this.dispose();
	   }
	  
	   void setPanelBac(String a,MyPanel b) throws IOException{
			Image[] array = new Image[10];
			Image topimg = ImageIO.read(new File(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator + a));//¸ù¾ÝÄãÊµ¼ÊÇé¿ö¸ÄÎÄ¼þÂ·¾¶°É
			array[0] = topimg;
			b.setPreferredSize(new Dimension(1000, 105));       
			b.setImg(topimg);
		}
	   void setLabelBac(String a,JLabel b) throws IOException{
			ImageIcon img = new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator + a + ".jpg");
			img.setImage(img.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT));
			//Icon icon=new ImageIcon(img);
			b.setIcon(img);
		}
	   void setLabelBac_1(String a,JLabel b) throws IOException{
		    Toolkit toolkit = Toolkit.getDefaultToolkit();
		    Dimension scmSize = toolkit.getScreenSize();
		    Image img = toolkit.getImage("image" + File.separator + a);
		    Icon icon=new ImageIcon(img);
			b.setIcon(icon);
		}
	  
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}


