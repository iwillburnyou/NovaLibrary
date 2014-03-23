package seu.Client.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;

import org.omg.CORBA.Object;


import seu.Client.bz.impl.CommonImpl;
import seu.Client.bz.impl.ISubjseleImpl;

import seu.Client.util.GBLAdd;
import seu.Client.vo.Subject;


import k.MessageType;
import k.User;

/**
 * ѡ��ģ���û�������
 * @author kidd
 *
 */
public class AllSubjPanel extends JPanel implements ActionListener,
MessageType{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//��ѯ�α����
//	private JTable jt;
	//ѡ�����
	private JScrollPane jspMain;
	private JPanel jpSubj0 = new JPanel(); 
	//ѡ�����
	//�������
	private JButton jbSelected = new JButton("��ѡ�γ�");
	public JButton jbReturn = new JButton("����");
	private JButton jbAllcurriculum=new JButton("�鿴���пγ�");
	private JButton jbAllcredit=new JButton("��ѡ�γ�ѧ��ͳ��");
	
	private ImageIcon background;
	private SubjSeleView ssv;
	Font font = new Font("΢���ź�", Font.ROMAN_BASELINE, 15);
	User user=new User();

	
	SingleSubjPanel ssp0 = new SingleSubjPanel("��ѧ",(JFrame)this.getParent());
	SingleSubjPanel ssp1 = new SingleSubjPanel("����",(JFrame)this.getParent());
	SingleSubjPanel ssp2 = new SingleSubjPanel("Ӣ��",(JFrame)this.getParent());
	SingleSubjPanel ssp3 = new SingleSubjPanel("����",(JFrame)this.getParent());
	SingleSubjPanel ssp4 = new SingleSubjPanel("���������",(JFrame)this.getParent());
	SingleSubjPanel ssp5 = new SingleSubjPanel("����",(JFrame)this.getParent());
	SingleSubjPanel ssp6 = new SingleSubjPanel("����",(JFrame)this.getParent());
	SingleSubjPanel ssp7 = new SingleSubjPanel("��Ȼ��ѧ",(JFrame)this.getParent());
	
	private JPanel jpTop = new JPanel(){                                  
    
		/**
		 * 
		 */
		public void paintComponent(Graphics g) {                          //���غ���������ͼƬ  
			  ImageIcon img = new ImageIcon(this.getClass().getResource("/image/ѧ��ѡ����.jpg"));
				  g.drawImage(img.getImage(),0, 0, getSize().width, getSize().height, this);
			} 
	//private static final long serialVersionUID = 1L;
	};
	 

	
	
	//��Ƭ�������
	private JPanel jpCard = new JPanel();                                
	private CardLayout cardLayout = new CardLayout(10,10);              //��Ƭʽ���֣������¾࣬���Ҿࣩ
	
	public AllSubjPanel(SubjSeleView ssv1,User us){
		/**
		 *
		 */
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//try {
		//	UIManager.setLookAndFeel("com.nilo.plaf.nimrod.NimRODLookAndFeel");
		//	} catch (Exception e) {}
		//SwingUtilities.updateComponentTreeUI(this);
		
		this.ssv = ssv1;
		this.user=us;
		jpTop.setOpaque(false);
		repaint();
	    setSubjMainPanel();
		setSubjTopPanel();				
		setSubjCardPanel();
		setSubjInfo();

		setSubjStuViewPanel();
		jbReturn.addActionListener(this);
        jbSelected.addActionListener(this);
	    jbAllcurriculum.addActionListener(this);
	    jbAllcredit.addActionListener(this);
	}

	

	private void setSubjStuViewPanel() {
	    
		this.setLayout(null);
		jpTop.setBounds(0, 0, 1366, 150);
		this.add(jpTop);
		jpCard.setBounds(0,150,1366,600);
		this.add(jpCard);
	//	this.setLayout(new BorderLayout());
	//	this.add(jpTop, BorderLayout.NORTH);
	//	this.add(jpCard, BorderLayout.CENTER);
	}

	//��Ƭ�����
	private void setSubjCardPanel() {
		
		jpCard.setLayout(cardLayout);
		jpCard.add(jspMain, "1");
//		jpCard.add(new JScrollPane(jt), "2");
	}

	//�����������
	private void setSubjTopPanel() {
	
		jpTop.setLayout(null);
		
		jbAllcurriculum.setBounds(560,115,140,30);
		jbAllcurriculum.setFont(font);
		jbAllcurriculum.setBorder(null);
		jbAllcurriculum.setContentAreaFilled(false);
	//	jbselected.setOpaque(false);
		jbAllcurriculum.setBorder(BorderFactory.createRaisedBevelBorder());
		jpTop.add(jbAllcurriculum);
		
		jbSelected.setBounds(700,115,100,30);
		jbSelected.setFont(font);
		jbSelected.setBorder(null);
		jbSelected.setContentAreaFilled(false);
		jbSelected.setOpaque(false);
		jbSelected.setBorder(BorderFactory.createRaisedBevelBorder());
		jpTop.add(jbSelected);
     //	jpTop.setOpaque(false);
		
	//
		jbAllcredit.setBounds(800,115,160,30);
		jbAllcredit.setFont(font);
		jbAllcredit.setBorder(null);
		jbAllcredit.setContentAreaFilled(false);
	    jbAllcredit.setBorder(BorderFactory.createRaisedBevelBorder());
		jpTop.add(jbAllcredit);
		
		jbReturn.setBounds(960,115,100,30);
		jbReturn.setFont(font);
		jbReturn.setBorder(null);
		jbReturn.setContentAreaFilled(false);
	//	jbselected.setOpaque(false);
		jbReturn.setBorder(BorderFactory.createRaisedBevelBorder());
		jpTop.add(jbReturn);
		

		
	  
	  
		
		SwingUtilities.updateComponentTreeUI(jpTop);
	}

	//ѡ���������
	public void setSubjMainPanel() {
		/**
		 * ����ѡ�����
		 */
		jpSubj0.setLayout(new GridBagLayout());
		jpSubj0.setBackground(Color.white);
		GridBagConstraints gbConstraints = new GridBagConstraints();     //Create an GridBagConstraints object
		gbConstraints.fill = GridBagConstraints.BOTH;
		gbConstraints.anchor = GridBagConstraints.CENTER;
		// ��ʼ���γ����

		GBLAdd.addComp(ssp0, jpSubj0, gbConstraints, 0, 0, 1, 1, 0, 0);
		GBLAdd.addComp(ssp1, jpSubj0, gbConstraints, 0, 1, 1, 1, 0, 0);
		GBLAdd.addComp(ssp2, jpSubj0, gbConstraints, 0, 2, 1, 1, 0, 0);
		GBLAdd.addComp(ssp3, jpSubj0, gbConstraints, 0, 3, 1, 1, 0, 0);
		GBLAdd.addComp(ssp4, jpSubj0, gbConstraints, 0, 4, 1, 1, 0, 0);
		GBLAdd.addComp(ssp5, jpSubj0, gbConstraints, 0, 5, 1, 1, 0, 0);
		GBLAdd.addComp(ssp6, jpSubj0, gbConstraints, 0, 6, 1, 1, 0, 0);
		GBLAdd.addComp(ssp7, jpSubj0, gbConstraints, 0, 7, 1, 1, 0, 0);
		
		jspMain = new JScrollPane(jpSubj0);  
		jspMain.getVerticalScrollBar().setUnitIncrement(10);         //����JScrollPane�������ֹ�����
		SwingUtilities.updateComponentTreeUI(jspMain);
	   	
	
	}
	public void setSubjInfo() {
	
		String sql0="select*from SubjInfo where �γ�����='��ѧ'";
		 Vector<Vector> v0=ISubjseleImpl.getMath(sql0); 
	//	Vector v0=DbHelper.executeQuery(sql0);
		if(!v0.isEmpty())
		{
		String s00=(String)((Vector) v0.get(0)).get(0);
		String s01=(String)((Vector) v0.get(0)).get(1);
		String s02=(String)((Vector) v0.get(0)).get(2);
		String s03=(String)((Vector) v0.get(0)).get(3);
		String s04=(String)((Vector) v0.get(0)).get(4);
		String s05=(String)((Vector) v0.get(0)).get(5);
	    final Subject selectCourse0=new Subject(s00,s01,s02,s03,s04,s05);
		ssp0.jlSubjName.setText("�γ����ƣ�" + selectCourse0.getName());
		ssp0.jlSubjTeacher.setText("�ον�ʦ��" + selectCourse0.getTeacher());
		ssp0.jlSubjId.setText("�γ̱�ţ�" + selectCourse0.getId());
		ssp0.jlSubjNum.setText("��ʱ��" + selectCourse0.getNum());
		ssp0.jlSubjCredit.setText("ѧ�֣�" + selectCourse0.getCredit());
		
		 ssp0.jbElect.addActionListener(new ActionListener() {
			 
			public void actionPerformed(ActionEvent e) {
				//System.out.print(1);
				if(e.getSource()==ssp0.jbElect)			
				{	
					String SQL0;
				    SQL0="insert into "+user.getCardNo()+"(�γ�ID,�γ�����,�ο���ʦ ,��ʱ����,ѧ��) values('"+selectCourse0.getId()+"','"+selectCourse0.getName()+"','"+selectCourse0.getTeacher()+"','"+selectCourse0.getNum()+"','"+selectCourse0.getCredit()+"')";
				   ISubjseleImpl.addMath(SQL0);
				    // 	try {DbHelper.executeUpdate(SQL0);}
				//	catch (SQLException c) {c.printStackTrace();}
						// TODO Auto-generated catch block				
	 	      }
				
			}
		 });
		 ssp0.jbCancel.addActionListener(new ActionListener() {
		    	
		     public void actionPerformed(ActionEvent e) {
		        if(e.getSource()==ssp0.jbCancel)
			  {
			 	String SQL00="delete  from "+user.getCardNo()+" where �γ�����='"+selectCourse0.getName()+"'";
			 	 ISubjseleImpl.delMath(SQL00);
				//try {DbHelper.executeUpdate(SQL00);}
				//catch (SQLException cc) {cc.printStackTrace();}
					// TODO Auto-generated catch block	
			}
		   }
		    });
		}
		if(v0.isEmpty()){ssp0.jbElect.setEnabled(false);}
		
	   String sql1="select*from SubjInfo where �γ�����='����'";
	   Vector v1=ISubjseleImpl.getPhysics(sql1); 
	//   Vector v1=DbHelper.executeQuery(sql1);
		if(!v1.isEmpty())
		{	
			String s10=(String)((Vector) v1.get(0)).get(0);
		    String s11=(String)((Vector) v1.get(0)).get(1);
		    String s12=(String)((Vector) v1.get(0)).get(2);
		    String s13=(String)((Vector) v1.get(0)).get(3);
		    String s14=(String)((Vector) v1.get(0)).get(4);
		    String s15=(String)((Vector) v1.get(0)).get(5);
		    final Subject selectCourse1=new Subject(s10,s11,s12,s13,s14,s15);
		    ssp1.jlSubjName.setText("�γ����ƣ�" + selectCourse1.getName());
		    ssp1.jlSubjTeacher.setText("�ον�ʦ��" + selectCourse1.getTeacher());
		    ssp1.jlSubjId.setText("�γ̱�ţ�" + selectCourse1.getId());
		    ssp1.jlSubjNum.setText("��ʱ��" + selectCourse1.getNum());
		    ssp1.jlSubjCredit.setText("ѧ�֣�" + selectCourse1.getCredit());
		    
		    ssp1.jbElect.addActionListener(new ActionListener() {
				 
				public void actionPerformed(ActionEvent e) {
					//System.out.print(1);
					if(e.getSource()==ssp1.jbElect)			
					{	
						String SQL1;
					    SQL1="insert into "+user.getCardNo()+"(�γ�ID,�γ�����,�ο���ʦ ,��ʱ����,ѧ��) values('"+selectCourse1.getId()+"','"+selectCourse1.getName()+"','"+selectCourse1.getTeacher()+"','"+selectCourse1.getNum()+"','"+selectCourse1.getCredit()+"')";
					    ISubjseleImpl.addPhysics(SQL1);
					    //	try {DbHelper.executeUpdate(SQL1);}
						//catch (SQLException c) {c.printStackTrace();}
							// TODO Auto-generated catch block				
		 	      }
				}
		    });
		    ssp1.jbCancel.addActionListener(new ActionListener() {
		    	
		     public void actionPerformed(ActionEvent e) {
		        if(e.getSource()==ssp1.jbCancel)
			  {
			 	String SQL11="delete  from "+user.getCardNo()+" where �γ�����='"+selectCourse1.getName()+"'";
			 	ISubjseleImpl.delPhysics(SQL11);
			//	try {DbHelper.executeUpdate(SQL11);}
			//	catch (SQLException cc) {cc.printStackTrace();}
					// TODO Auto-generated catch block	
			}
		   }
		    });
		}
		if(v1.isEmpty()){ssp1.jbElect.setEnabled(false);}     
		    
		
		String sql2="select*from SubjInfo where �γ�����='Ӣ��'";
		Vector v2=ISubjseleImpl.getEnglish(sql2);
		//Vector v2=DbHelper.executeQuery(sql2);
		if(!v2.isEmpty())
		{
		String s20=(String)((Vector) v2.get(0)).get(0);
		String s21=(String)((Vector) v2.get(0)).get(1);
		String s22=(String)((Vector) v2.get(0)).get(2);
		String s23=(String)((Vector) v2.get(0)).get(3);
		String s24=(String)((Vector) v2.get(0)).get(4);
		String s25=(String)((Vector) v2.get(0)).get(5);
		final Subject selectCourse2=new Subject(s20,s21,s22,s23,s24,s25);
		ssp2.jlSubjName.setText("�γ����ƣ�" + selectCourse2.getName());
		ssp2.jlSubjTeacher.setText("�ον�ʦ��" + selectCourse2.getTeacher());
		ssp2.jlSubjId.setText("�γ̱�ţ�" + selectCourse2.getId());
		ssp2.jlSubjNum.setText("��ʱ��" + selectCourse2.getNum());
		ssp2.jlSubjCredit.setText("ѧ�֣�" + selectCourse2.getCredit());
		
		  ssp2.jbElect.addActionListener(new ActionListener() {
				 
				public void actionPerformed(ActionEvent e) {
					//System.out.print(1);
					if(e.getSource()==ssp2.jbElect)			
					{	
						String SQL2;
						System.out.println(user.getCardNo());
					    SQL2="insert into "+user.getCardNo()+"(�γ�ID,�γ�����,�ο���ʦ ,��ʱ����,ѧ��) values('"+selectCourse2.getId()+"','"+selectCourse2.getName()+"','"+selectCourse2.getTeacher()+"','"+selectCourse2.getNum()+"','"+selectCourse2.getCredit()+"')";
					    ISubjseleImpl.addEnglish(SQL2);
					    //	try {DbHelper.executeUpdate(SQL2);}
					//	catch (SQLException c) {c.printStackTrace();}
							// TODO Auto-generated catch block				
		 	      }
					
				}
			 });
		
		    ssp2.jbCancel.addActionListener(new ActionListener() {
		    	
		     public void actionPerformed(ActionEvent e) {
		        if(e.getSource()==ssp2.jbCancel)
			  {
			 	String SQL22="delete  from "+user.getCardNo()+" where �γ�����='"+selectCourse2.getName()+"'";
			 	 ISubjseleImpl.delEnglish(SQL22);
			//	try {DbHelper.executeUpdate(SQL22);}
			//	catch (SQLException cc) {cc.printStackTrace();}
					// TODO Auto-generated catch block	
			}
		   }
		    });
		}
		if(v2.isEmpty()){ssp2.jbElect.setEnabled(false);}
		
		 String sql3="select*from SubjInfo where �γ�����='����'";
		 Vector v3=ISubjseleImpl.getPE(sql3);
		 //  Vector v3=DbHelper.executeQuery(sql3);
			if(!v3.isEmpty())
			{	
				String s30=(String)((Vector) v3.get(0)).get(0);
			    String s31=(String)((Vector) v3.get(0)).get(1);
			    String s32=(String)((Vector) v3.get(0)).get(2);
			    String s33=(String)((Vector) v3.get(0)).get(3);
			    String s34=(String)((Vector) v3.get(0)).get(4);
			    String s35=(String)((Vector) v3.get(0)).get(5);
			    final Subject selectCourse3=new Subject(s30,s31,s32,s33,s34,s35);
			    ssp3.jlSubjName.setText("�γ����ƣ�" + selectCourse3.getName());
			    ssp3.jlSubjTeacher.setText("�ον�ʦ��" + selectCourse3.getTeacher());
			    ssp3.jlSubjId.setText("�γ̱�ţ�" + selectCourse3.getId());
			    ssp3.jlSubjNum.setText("��ʱ��" + selectCourse3.getNum());
			    ssp3.jlSubjCredit.setText("ѧ�֣�" + selectCourse3.getCredit());
			    
			    ssp3.jbElect.addActionListener(new ActionListener() {
					 
					public void actionPerformed(ActionEvent e) {
						//System.out.print(1);
						if(e.getSource()==ssp3.jbElect)			
						{	
							String SQL3;
						    SQL3="insert into "+ssv.user.getCardNo()+"(�γ�ID,�γ�����,�ο���ʦ ,��ʱ����,ѧ��) values('"+selectCourse3.getId()+"','"+selectCourse3.getName()+"','"+selectCourse3.getTeacher()+"','"+selectCourse3.getNum()+"','"+selectCourse3.getCredit()+"')";
						    ISubjseleImpl.addPE(SQL3);
						//  	try {DbHelper.executeUpdate(SQL3);}
						//	catch (SQLException c) {c.printStackTrace();}
								// TODO Auto-generated catch block				
			 	      }
						
					}
				 });
			   
			    ssp3.jbCancel.addActionListener(new ActionListener() {
			    	
			     public void actionPerformed(ActionEvent e) {
			        if(e.getSource()==ssp3.jbCancel)
				  {
				 	String SQL33="delete  from "+user.getCardNo()+" where �γ�����='"+selectCourse3.getName()+"'";
				 	ISubjseleImpl.delPE(SQL33);
				//	try {DbHelper.executeUpdate(SQL33);}
				//	catch (SQLException cc) {cc.printStackTrace();}
						// TODO Auto-generated catch block	
				}
			   }
			    });
			}
			
			if(v3.isEmpty()){ssp3.jbElect.setEnabled(false);}
			
			 String sql4="select*from SubjInfo where �γ�����='���������'";
			 Vector v4=ISubjseleImpl.getComputer(sql4);
			 // Vector v4=DbHelper.executeQuery(sql4);
				if(!v4.isEmpty())
				{	
					String s40=(String)((Vector) v4.get(0)).get(0);
				    String s41=(String)((Vector) v4.get(0)).get(1);
				    String s42=(String)((Vector) v4.get(0)).get(2);
				    String s43=(String)((Vector) v4.get(0)).get(3);
				    String s44=(String)((Vector) v4.get(0)).get(4);
				    String s45=(String)((Vector) v4.get(0)).get(5);
				    final Subject selectCourse4=new Subject(s40,s41,s42,s43,s44,s45);
				    ssp4.jlSubjName.setText("�γ����ƣ�" + selectCourse4.getName());
				    ssp4.jlSubjTeacher.setText("�ον�ʦ��" + selectCourse4.getTeacher());
				    ssp4.jlSubjId.setText("�γ̱�ţ�" + selectCourse4.getId());
				    ssp4.jlSubjNum.setText("��ʱ��" + selectCourse4.getNum());
				    ssp4.jlSubjCredit.setText("ѧ�֣�" + selectCourse4.getCredit());
				    
				    ssp4.jbElect.addActionListener(new ActionListener() {
						 
						public void actionPerformed(ActionEvent e) {
							//System.out.print(1);
							if(e.getSource()==ssp4.jbElect)			
							{	
								String SQL4;
							    SQL4="insert into "+user.getCardNo()+"(�γ�ID,�γ�����,�ο���ʦ ,��ʱ����,ѧ��) values('"+selectCourse4.getId()+"','"+selectCourse4.getName()+"','"+selectCourse4.getTeacher()+"','"+selectCourse4.getNum()+"','"+selectCourse4.getCredit()+"')";
							    ISubjseleImpl.addComputer(SQL4);
							//  	try {DbHelper.executeUpdate(SQL4);}
							//	catch (SQLException c) {c.printStackTrace();}
									// TODO Auto-generated catch block				
				 	      }
							
						}
					 });
				
				    ssp4.jbCancel.addActionListener(new ActionListener() {
				    	
				     public void actionPerformed(ActionEvent e) {
				        if(e.getSource()==ssp4.jbCancel)
					  {
					 	String SQL44="delete  from "+user.getCardNo()+" where �γ�����='"+selectCourse4.getName()+"'";
					 	 ISubjseleImpl.delComputer(SQL44);
						//try {DbHelper.executeUpdate(SQL44);}
						//catch (SQLException cc) {cc.printStackTrace();}
							// TODO Auto-generated catch block	
					}
				   }
				    });
				}	
				if(v4.isEmpty()){ssp4.jbElect.setEnabled(false);}
				
	    		 String sql5="select*from SubjInfo where �γ�����='����'";
	    		 Vector v5=ISubjseleImpl.getArt(sql5);
				//   Vector v5=DbHelper.executeQuery(sql5);
					if(!v5.isEmpty())
					{	
						String s50=(String)((Vector) v5.get(0)).get(0);
					    String s51=(String)((Vector) v5.get(0)).get(1);
					    String s52=(String)((Vector) v5.get(0)).get(2);
					    String s53=(String)((Vector) v5.get(0)).get(3);
					    String s54=(String)((Vector) v5.get(0)).get(4);
					    String s55=(String)((Vector) v5.get(0)).get(5);
					    final Subject selectCourse5=new Subject(s50,s51,s52,s53,s54,s55);
					    ssp5.jlSubjName.setText("�γ����ƣ�" + selectCourse5.getName());
					    ssp5.jlSubjTeacher.setText("�ον�ʦ��" + selectCourse5.getTeacher());
					    ssp5.jlSubjId.setText("�γ̱�ţ�" + selectCourse5.getId());
					    ssp5.jlSubjNum.setText("��ʱ��" + selectCourse5.getNum());
					    ssp5.jlSubjCredit.setText("ѧ�֣�" + selectCourse5.getCredit());
					    
					    ssp5.jbElect.addActionListener(new ActionListener() {
							 
							public void actionPerformed(ActionEvent e) {
								//System.out.print(1);
								if(e.getSource()==ssp5.jbElect)			
								{	
									String SQL5;
								    SQL5="insert into "+user.getCardNo()+"(�γ�ID,�γ�����,�ο���ʦ ,��ʱ����,ѧ��) values('"+selectCourse5.getId()+"','"+selectCourse5.getName()+"','"+selectCourse5.getTeacher()+"','"+selectCourse5.getNum()+"','"+selectCourse5.getCredit()+"')";
								    ISubjseleImpl.addArt(SQL5);
								 // 	try {DbHelper.executeUpdate(SQL5);}
								//	catch (SQLException c) {c.printStackTrace();}
										// TODO Auto-generated catch block				
					 	      }
							}
					    });
					    ssp5.jbCancel.addActionListener(new ActionListener() {
					    	
					     public void actionPerformed(ActionEvent e) {
					        if(e.getSource()==ssp5.jbCancel)
						  {
						 	String SQL55="delete  from "+user.getCardNo()+" where �γ�����='"+selectCourse5.getName()+"'";
						 	 ISubjseleImpl.delArt(SQL55);
							//try {DbHelper.executeUpdate(SQL55);}
							//catch (SQLException cc) {cc.printStackTrace();}
								// TODO Auto-generated catch block	
						}
					   }
					    });
					}
					
					if(v5.isEmpty()){ssp5.jbElect.setEnabled(false);}		
					
		  String sql6="select*from SubjInfo where �γ�����='����'";
			// Vector v6=DbHelper.executeQuery(sql6);
		   Vector v6=ISubjseleImpl.getEcnomics(sql6);
			if(!v6.isEmpty())
			{	
				String s60=(String)((Vector) v6.get(0)).get(0);
				String s61=(String)((Vector) v6.get(0)).get(1);
				String s62=(String)((Vector) v6.get(0)).get(2);
				String s63=(String)((Vector) v6.get(0)).get(3);
			    String s64=(String)((Vector) v6.get(0)).get(4);
			    String s65=(String)((Vector) v6.get(0)).get(5);
			    final Subject selectCourse6=new Subject(s60,s61,s62,s63,s64,s65);
			    ssp6.jlSubjName.setText("�γ����ƣ�" + selectCourse6.getName());
			    ssp6.jlSubjTeacher.setText("�ον�ʦ��" + selectCourse6.getTeacher());
			    ssp6.jlSubjId.setText("�γ̱�ţ�" + selectCourse6.getId());
			    ssp6.jlSubjNum.setText("��ʱ��" + selectCourse6.getNum());
				ssp6.jlSubjCredit.setText("ѧ�֣�" + selectCourse6.getCredit());
				
				ssp6.jbElect.addActionListener(new ActionListener() {
					 
					public void actionPerformed(ActionEvent e) {
						//System.out.print(1);
						if(e.getSource()==ssp6.jbElect)			
						{	
							String SQL6;
						    SQL6="insert into "+user.getCardNo()+"(�γ�ID,�γ�����,�ο���ʦ ,��ʱ����,ѧ��) values('"+selectCourse6.getId()+"','"+selectCourse6.getName()+"','"+selectCourse6.getTeacher()+"','"+selectCourse6.getNum()+"','"+selectCourse6.getCredit()+"')";
						    ISubjseleImpl.addEcnomics(SQL6);
						    // 	try {DbHelper.executeUpdate(SQL6);}
						//	catch (SQLException c) {c.printStackTrace();}
								// TODO Auto-generated catch block				
			 	      }
					}
			    });
			    ssp6.jbCancel.addActionListener(new ActionListener() {
			    	
			     public void actionPerformed(ActionEvent e) {
			        if(e.getSource()==ssp6.jbCancel)
				  {
				 	String SQL66="delete  from "+user.getCardNo()+" where �γ�����='"+selectCourse6.getName()+"'";
				 	 ISubjseleImpl.delEcnomics(SQL66);
				//	try {DbHelper.executeUpdate(SQL66);}
				//	catch (SQLException cc) {cc.printStackTrace();}
						// TODO Auto-generated catch block	
				}
			   }
			    });
			}
			
			if(v6.isEmpty()){ssp6.jbElect.setEnabled(false);}
			
			 String sql7="select*from SubjInfo where �γ�����='��Ȼ��ѧ'";
			 //  Vector v7=DbHelper.executeQuery(sql7);
			 Vector v7=ISubjseleImpl.getScience(sql7);
				if(!v7.isEmpty())
				{	
					String s70=(String)((Vector) v7.get(0)).get(0);
				    String s71=(String)((Vector) v7.get(0)).get(1);
				    String s72=(String)((Vector) v7.get(0)).get(2);
				    String s73=(String)((Vector) v7.get(0)).get(3);
				    String s74=(String)((Vector) v7.get(0)).get(4);
				    String s75=(String)((Vector) v7.get(0)).get(5);
				    final Subject selectCourse7=new Subject(s70,s71,s72,s73,s74,s75);
				    ssp7.jlSubjName.setText("�γ����ƣ�" + selectCourse7.getName());
				    ssp7.jlSubjTeacher.setText("�ον�ʦ��" + selectCourse7.getTeacher());
				    ssp7.jlSubjId.setText("�γ̱�ţ�" + selectCourse7.getId());
				    ssp7.jlSubjNum.setText("��ʱ��" + selectCourse7.getNum());
				    ssp7.jlSubjCredit.setText("ѧ�֣�" + selectCourse7.getCredit());
				    
				    ssp7.jbElect.addActionListener(new ActionListener() {
						 
						public void actionPerformed(ActionEvent e) {
							//System.out.print(1);
							if(e.getSource()==ssp7.jbElect)			
							{	
								String SQL7;
							    SQL7="insert into "+user.getCardNo()+"(�γ�ID,�γ�����,�ο���ʦ ,��ʱ����,ѧ��) values('"+selectCourse7.getId()+"','"+selectCourse7.getName()+"','"+selectCourse7.getTeacher()+"','"+selectCourse7.getNum()+"','"+selectCourse7.getCredit()+"')";
							    ISubjseleImpl.addScience(SQL7);
							    //try {DbHelper.executeUpdate(SQL7);}
								//catch (SQLException c) {c.printStackTrace();}
									// TODO Auto-generated catch block				
				 	      }
						}
				    });
				    ssp7.jbCancel.addActionListener(new ActionListener() {
				    	
				     public void actionPerformed(ActionEvent e) {
				        if(e.getSource()==ssp7.jbCancel)
					  {
					 	String SQL77="delete  from "+ssv.user.getCardNo()+" where �γ�����='"+selectCourse7.getName()+"'";
					 	ISubjseleImpl.delScience(SQL77);
						
					}
				   }
				    });
				    }
				if(v7.isEmpty()){ssp7.jbElect.setEnabled(false);}
				}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		if(e.getSource()==jbSelected){
			stuCurriculum sc=new stuCurriculum(user);
	}
		if(e.getSource()==jbAllcurriculum){
			allCurriculum aC=new allCurriculum();
	}
		if(e.getSource()==jbAllcredit){
			
			String sql="select * from " +user.getCardNo()+"";			
			Vector v=ISubjseleImpl.getStuCur(sql);
		    int  credit=0;
		    for(int i=0;i<v.size();i++)
	        {
		    	String str=(String) ((Vector)v.get(i)).get(4);
		    	int single=Integer.valueOf(str.trim()).intValue();
		    	credit=credit+ single;	
		    }
		 
		   JOptionPane.showMessageDialog(null, "��ѡ�γ�ѧ���ܼ�"+credit);
		}
		if(e.getSource()==jbReturn){
			ssv.dispose();
	}
	
		
//	public static void main(String[] args) {
	//	AllSubjPanel f1=new AllSubjPanel();}
	
	}
}

