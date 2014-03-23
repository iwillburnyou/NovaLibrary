/**
 * �޸Ŀγ̶Ի���
 */
package seu.Client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import seu.Client.bz.impl.ISubjseleImpl;


import k.MessageType;

/**
 * ѡ��ģ��༭һ�ſγ̵ĶԻ���
 * @author kidd
 *
 */
public class SubModifyCourseDialog extends JDialog implements ActionListener,
MessageType{



	JLabel jl1, jl2, jl3, jl4, jl5, jl6;
	JButton jb1, jb2;
	JTextField jtf1, jtf2, jtf3, jtf4, jtf5;
	JComboBox<String> jcb6;
	JPanel jp;
	private ImageIcon background;
	Font font = new Font("΢���ź�", Font.ROMAN_BASELINE, 18);
	// ���캯��
	public SubModifyCourseDialog() {
		//super(arg0, arg1, arg2);

		background = new ImageIcon(this.getClass().getResource("/image/ѡ�ζԻ���.jpg"));// ����ͼƬ
     	JLabel label = new JLabel(background);// �ѱ���ͼƬ��ʾ��һ����ǩ����
     	label.setBounds(0,0, background.getIconWidth(),background.getIconHeight());// �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������
     	// �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��
     	jp = (JPanel) this.getContentPane();
     	this.getLayeredPane().setLayout(null);
     	jp.setOpaque(false);
     	// ���ݴ���Ĭ�ϵĲ��ֹ�����ΪBorderLayout
     	jp.setLayout(null);
     	
		jl1 = new JLabel("�γ̱��:", JLabel.CENTER);
		jl1.setFont(font);
		jl1.setForeground(Color.white);
		jl1.setBounds(10, 30, 100, 25);
		jp.add(jl1);
		
		jl2 = new JLabel("�γ�����:", JLabel.CENTER);
		jl2.setFont(font);
		jl2.setForeground(Color.white);
		jl2.setBounds(10, 70, 100, 25);
		jp.add(jl2);
		
		jl3 = new JLabel("�ο���ʦ:", JLabel.CENTER);
		jl3.setFont(font);
		jl3.setForeground(Color.white);
		jl3.setBounds(10, 110, 100, 25);
		jp.add(jl3);
		
		jl4 = new JLabel("��ʱ:", JLabel.CENTER);
		jl4.setFont(font);
		jl4.setFont(font);
		jl4.setForeground(Color.white);
		jl4.setBounds(10, 150, 100, 25);
		jp.add(jl4);
		
		jl5 = new JLabel("ѧ��:", JLabel.CENTER);
		jl5.setFont(font);
		jl5.setForeground(Color.white);
		jl5.setBounds(10, 190, 100, 25);
		jp.add(jl5);
		
		jl6 = new JLabel("�γ�����:", JLabel.CENTER);
		jl6.setFont(font);
		jl6.setForeground(Color.white);
		jl6.setBounds(10, 230, 100, 25);
		jp.add(jl6);
		
		jtf1 = new JTextField();
		jtf1.setBounds(110, 30, 180, 25);
		jp.add(jtf1);
		jtf2 = new JTextField();
		jtf2.setBounds(110, 70, 180, 25);
		jp.add(jtf2);
		jtf3 = new JTextField();
		jtf3.setBounds(110, 110, 180, 25);
		jp.add(jtf3);
		jtf4 = new JTextField();
		jtf4.setBounds(110, 150, 180, 25);
		jp.add(jtf4);
		jtf5 = new JTextField();
		jtf5.setBounds(110, 190, 180, 25);
		jp.add(jtf5);

		String[] type = { "��ѧ", "����", "Ӣ��", "����", "���������", "����", "����",
				"��Ȼ��ѧ" };
		jcb6 = new JComboBox<String>(type);
		jcb6.setOpaque(false);
		jcb6.setBackground(Color.white);

		jcb6.setBounds(110, 230, 180, 25);
		jp.add(jcb6);

		jb1 = new JButton("ȷ���޸�");
		jb1.setFont(font);
		jb1.setForeground(Color.white);
		jb1.setBounds(30, 300, 120, 30);
		jb1.setBorderPainted(false);
		jb1.setContentAreaFilled(false);
		jb1.setOpaque(false);
		jb1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jp.add(jb1);
		jb1.addActionListener(this);
		
		jb2 = new JButton("ȡ���޸�");
		jb2.setFont(font);
		jb2.setForeground(Color.white);
		jb2.setBounds(150, 300, 120, 30);
		jb2.setBorderPainted(false);
		jb2.setContentAreaFilled(false);
		jb2.setOpaque(false);
		jb2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jp.add(jb2);
		jb2.addActionListener(this);

		 this.getLayeredPane().setLayout(null);
	    // �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����
	    this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
	   // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(background.getIconWidth(), background.getIconHeight());
	    this.setUndecorated(true);
	    this.setLocation(500, 200);
		this.setVisible(true);
		
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

	



	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1)	{
			String sql;
	    sql="update  SubjInfo set �γ���Ϣ='"+jtf2.getText()+"',�ο���ʦ='"+jtf3.getText()+"',��ʱ='"+jtf4.getText()+"',ѧ��='"+jtf5.getText()+"',�γ̱��='"+jtf1.getText()+"' where �γ�����='"+jcb6.getSelectedItem()+"'";
	    ISubjseleImpl.modSubj(sql);
	    JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
	    this.dispose();
		/*try {
			DbHelper.executeUpdate(sql);
		} catch (SQLException c) {
			// TODO Auto-generated catch block
			c.printStackTrace();
		}*/
		
	}
	if(e.getSource()==jb2){
		this.setVisible(false);
			}
	}

    public static void main(String[] args) {
   	 SubModifyCourseDialog f1=new SubModifyCourseDialog();}

}
