package seu.Client.view;
/**
 * �޸Ĳ�Ʒ��Ϣ����  By ������
 */
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import seu.Client.bz.impl.CanteenInfoImpl;


/**
 * ʳ��ģ���޸Ĳ�Ʒ��Ϣ����
 * @author kidd
 *
 */
public class ChangeDishDialog extends JDialog implements ActionListener{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel []jlabelArray= new JLabel[]{
			new JLabel("����"),	new JLabel("��ϵ"),new JLabel("ʳ��"),new JLabel("����"),new JLabel("�۸�")
	};

	private JTextField []jtxtArray = new JTextField[]{
			new JTextField(),new JTextField(),new JTextField(),new JTextField(),new JTextField()
	};
	private JButton okButton = new JButton("ȷ��");
	private JButton canButton = new JButton("ȡ��");
	CaDishSearch cdCaDishSearch ;
	String sql;
	String []str = new String[5];
	public ChangeDishDialog(CaDishSearch cds,String []string){
		this.str= string;
		this.cdCaDishSearch = cds; 
		this.setTitle("��Ʒ��Ϣ�޸�");
		this.setVisible(true);
		this.setBounds(0, 0, 300, 300);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setFont(new java.awt.Font("��Բ",0,16));
		for (int i =0; i<5; i++){
			jtxtArray[i].setText(str[i]);
			jlabelArray[i].setBounds(20,20+i*40,100,30);
			jtxtArray[i].setBounds(150, 20+i*40, 100, 30);
			jtxtArray[i].setFont(new Font("��Բ",Font.PLAIN,16));
			jlabelArray[i].setFont(new Font("��Բ",Font.PLAIN,16));
			this.getContentPane().add(jlabelArray[i]);
			this.getContentPane().add(jtxtArray[i]);
		}
		okButton.setBounds(20, 230, 100, 30);
		canButton.setBounds(150	, 230, 100, 30);
		okButton.setFont(new Font("��Բ",Font.PLAIN,16));
		canButton.setFont(new Font("��Բ",Font.PLAIN,16));
		
		okButton.addActionListener(this);
		canButton.addActionListener(this);
		this.getContentPane().add(okButton);
		this.getContentPane().add(canButton);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==okButton){
			for (int i =0;i<5;i++)
			{
				str[i] = jtxtArray[i].getText().trim();
			}
			sql= "update tblDishSearch set DishCate = '"+str[1]+"',CanteenNum = '"+str[2]+"', TakeAway='"+str[3]+"' , Price = '"+str[4]+"' where DishName = '"+str[0]+"'";
		
			CanteenInfoImpl.changeDish(sql);
			this.dispose();
			cdCaDishSearch.paintTable("select * from tblDishSearch ");
		}
		else if(e.getSource()==canButton){
			this.dispose();
		}
		
	}
}
