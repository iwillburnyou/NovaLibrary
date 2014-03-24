package seu.Client.view;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.TableRowSorter;

import seu.Client.bz.impl.CommonImpl;
import seu.Client.util.GBLAdd;
import sun.nio.cs.HistoricallyNamedCharset;
import sun.security.x509.IPAddressName;

import k.MessageType;


//import view.admin.lib.LibAdminView;
/**
 * ѡ��ģ�����Ա����
 * @author kidd
 *
 */
public class AdminView extends JFrame implements ActionListener,MessageType {

	// �������
	private JPanel jp = new JPanel();
	ImageIcon icon = new ImageIcon(this.getClass().getResource("/image/����.png"));
	
	private JButton jbReturn = new JButton(icon);
	private JButton jbSeeAllSubject = new JButton("���пγ�");
	
	private JButton jbAddSubject = new JButton("��ӿγ�");
	private JButton jbModifySubject = new JButton("�޸Ŀγ�");
	private JButton jbDelSubject = new JButton("ɾ���γ�");
	private ImageIcon background;
	
//	private JPanel imagePanel;
	Font font = new Font("΢���ź�", Font.ROMAN_BASELINE, 15);




	public AdminView() {

		
		
     	background = new ImageIcon(this.getClass().getResource("/image/ѡ��ϵͳ����Ա.jpg"));// ����ͼƬ
     	JLabel label = new JLabel(background);// �ѱ���ͼƬ��ʾ��һ����ǩ����
     	label.setBounds(0,0, background.getIconWidth(),background.getIconHeight());// �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
     	// �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��
     	jp = (JPanel) this.getContentPane();
     	this.getLayeredPane().setLayout(null);
     	jp.setOpaque(false);
     	// ���ݴ���Ĭ�ϵĲ��ֹ�����ΪBorderLayout
     	jp.setLayout(null);
     	
 
     	
     	jbReturn.setBounds(450, 10, 30, 30);

     	jbReturn.setBorder(null);
     	jbReturn.setContentAreaFilled(false);
        jp.add(jbReturn);
     	
     	
     	jbAddSubject.setBounds(150, 190, 80, 30);
     	jbAddSubject.setFont(font);
     	jbAddSubject.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
     	jbAddSubject.setBorder(null);
     	jbAddSubject.setContentAreaFilled(false);
     	jbAddSubject.setBorder(BorderFactory.createRaisedBevelBorder());
        jp.add(jbAddSubject);
        
     	jbModifySubject.setBounds(250, 190, 80, 30);
     	jbModifySubject.setFont(font);
     	jbModifySubject.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
     	jbModifySubject.setBorder(null);
     	jbModifySubject.setContentAreaFilled(false);
     	jbModifySubject.setBorder(BorderFactory.createRaisedBevelBorder());
     	jp.add(jbModifySubject);
     	
     	jbDelSubject.setBounds(150, 230, 80, 30);
     	jbDelSubject.setFont(font);
     	jbDelSubject.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
     	jbDelSubject.setBorder(null);
     	jbDelSubject.setContentAreaFilled(false);
     	jbDelSubject.setBorder(BorderFactory.createRaisedBevelBorder());
     	jp.add(jbDelSubject );
     	
     	jbSeeAllSubject.setBounds(250, 230, 80, 30);
     	jbSeeAllSubject.setFont(font);
     	jbSeeAllSubject.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
     	jbSeeAllSubject.setBorder(null);
     	jbSeeAllSubject.setContentAreaFilled(false);
     	jbSeeAllSubject.setBorder(BorderFactory.createRaisedBevelBorder());
     	jp.add(jbSeeAllSubject);
     	
     	 this.getLayeredPane().setLayout(null);
     	// �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
     	 this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
     	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	 this.setLocation(400, 200);
     	 this.setSize(background.getIconWidth(), background.getIconHeight());
     	 this.setResizable(false);
     	
     	 this.setUndecorated(true); 
     	 this.setVisible(true);
     	 
     	  jbSeeAllSubject.addActionListener(this);
		  jbAddSubject.addActionListener(this);
		  jbModifySubject.addActionListener(this);
		  jbDelSubject.addActionListener(this);
		  jbReturn.addActionListener(this);
	
	

		
			
			
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
	}
	/**
	 *ѡ��ģ�����Ա������ְ�ť��Ӧ����
	 * @author kidd
	 *
	 */

	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==jbSeeAllSubject)
		{allCurriculum aC=new allCurriculum();}
		if(e.getSource()==jbAddSubject)
		{SubjAddCourseDialog sacd = new SubjAddCourseDialog();}
		if(e.getSource()==jbModifySubject)
		{SubModifyCourseDialog smcd= new SubModifyCourseDialog();}
		if(e.getSource()==jbDelSubject)
		{SubjDeleCourseDialog sdcd=new SubjDeleCourseDialog();}
		if(e.getSource()==jbReturn)
	    {this.dispose();}
	}
	public static void main(String[] args) {
		AdminView f1=new AdminView();}
}