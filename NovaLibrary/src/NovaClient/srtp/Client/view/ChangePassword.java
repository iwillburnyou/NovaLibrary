package seu.Client.view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import seu.Client.bz.impl.LoginImpl;
/**
 * ��½�����޸�����Ի���
 * @author kidd
 *
 */
public class ChangePassword extends JDialog {
	protected static final AbstractButton nameinput = null;
	private ImageIcon background;
	static Statement stmt = null;
	static Connection con = null;
	static ResultSet rs = null;

	
public ChangePassword()  {
	
	//this(new Frame(),"ע���û�",false);
	this.setUndecorated(true);
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//�ر�
	this.jbInit();
	this.setTitle("�޸�����");
	this.setSize(336,464);
	this.setLocation(440, 110);
	this.setVisible(true);

}
private void jbInit() {
	JPanel panel1=new JPanel();

	ImageIcon background = new ImageIcon(this.getClass().getResource("/image/�޸�1.png")); 
    JLabel label = new JLabel(background); 
    //label.setBounds(-30,-100, this.getWidth(), this.getHeight()); 
	panel1.setOpaque(false);
	
	final JTextField jtextfield1=new JTextField ("");
	final JPasswordField jPassword1=new JPasswordField ("");
	final JPasswordField jPassword2=new JPasswordField ("");
	final JPasswordField jPassword3=new JPasswordField ("");

	JLabel jlabel1=new JLabel(" һ  ��  ͨ");
	Font font1 = new Font("��Բ",Font.LAYOUT_RIGHT_TO_LEFT,12);
	jlabel1.setFont(font1);
	JLabel jlabel2=new JLabel(" ԭʼ����");
	Font font2 = new Font("��Բ",Font.LAYOUT_RIGHT_TO_LEFT,12);
	jlabel2.setFont(font2);
	JLabel jlabel3=new JLabel(" ��  ��  ��");
	Font font3 = new Font("��Բ",Font.LAYOUT_RIGHT_TO_LEFT,12);
	jlabel3.setFont(font3);
	JLabel jlabel4=new JLabel(" ȷ��������");
	Font font4 = new Font("��Բ",Font.LAYOUT_RIGHT_TO_LEFT,12);
	jlabel4.setFont(font4);
	JLabel close = new JLabel("X");
	jlabel1.setBounds(60,110,150,15);
	jlabel2.setBounds(60,170,150,15);
	jlabel3.setBounds(60,230,150,15);
	jlabel4.setBounds(60,300,150,15);
	close.setBounds(300, 15, 50, 50);
	label.setBounds(-50,-150,110,110);
	
	JButton jbutton1=new JButton();
	Icon generl1=new ImageIcon (this.getClass().getResource("/image/ccc1.png"));
	Icon press1=new ImageIcon(this.getClass().getResource("/image/ccc2.png"));
	Icon rollover1=new ImageIcon(this.getClass().getResource("/image/ccc3.png"));
	jbutton1.setRolloverEnabled(true);
	jbutton1.setIcon(generl1);
	jbutton1.setRolloverIcon(rollover1);
	jbutton1.setPressedIcon(press1);
	jbutton1.setContentAreaFilled(false);
	jbutton1.setBorderPainted(false);
	jbutton1.setBounds(130,380,120,30);
	jbutton1.setText("ȷ���޸�");
	this.add(close);
	this.add(jlabel4);
	this.add(jlabel3);
	this.add(jlabel2);
	this.add(jlabel1);
	this.add(jbutton1);
	
    panel1.setLayout(null);
    jtextfield1.setBounds(150,110,150,20);
    jPassword1.setBounds(150,170,150,20);
    jPassword2.setBounds(150,230,150,20);
    jPassword3.setBounds(150,300,150,20);	
    
   
    this.add(jPassword3);
	this.add(jPassword2);
	this.add(jPassword1);
	this.add(jtextfield1);
	this.add(panel1);
	 this.add(label);
   
jbutton1.addActionListener(new ActionListener()
{
	 public void actionPerformed(ActionEvent Event)
	{
		 //���ݿ����
		
		String stuCard=jtextfield1.getText();
        String password=jPassword1.getText();
        String Newpassword=jPassword2.getText();
        String NewpasswordAgain=jPassword3.getText();
        if(stuCard.equals(""))
        {  
        	JOptionPane.showMessageDialog(null, "����дһ��ͨ�ţ�", "������!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        else if(!Newpassword.equals(NewpasswordAgain)){
        	JOptionPane.showMessageDialog(null, "���������벻һ�£�", "������!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        else{
        	String sql = "select * from tblUserManager where cardNo ='"+stuCard+"'";
			if(LoginImpl.getMessage(sql).getPsd().equals(password))
			{
				String sql1 = "update tblUserManager set psd = '"+Newpassword+"' where cardNo = '"+stuCard+"'";
				LoginImpl.changePsd(sql1);
                JOptionPane.showMessageDialog(null, "�����޸ĳɹ���", "��ϲ!", JOptionPane.INFORMATION_MESSAGE);
                dispose();
			}
			else{
				JOptionPane.showMessageDialog(null, "����ԭ��������", "������!", JOptionPane.INFORMATION_MESSAGE);
	            return;
				
			}
        }
	}
});
close.addMouseListener(new MouseAdapter() {
	public void mouseClicked(MouseEvent event){
		dispose();
		}
	 });
}
//public void paintComponent(Graphics g) { 
	//g.drawImage(background.getImage(), 0, 0,this);   
	//super.paintComponents(g);
}

//}

	
        















