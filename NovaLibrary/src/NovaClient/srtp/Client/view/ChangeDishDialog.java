package seu.Client.view;
/**
 * 修改菜品信息的类  By 张雅淋
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
 * 食堂模块修改菜品信息界面
 * @author kidd
 *
 */
public class ChangeDishDialog extends JDialog implements ActionListener{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel []jlabelArray= new JLabel[]{
			new JLabel("菜名"),	new JLabel("菜系"),new JLabel("食堂"),new JLabel("外卖"),new JLabel("价格")
	};

	private JTextField []jtxtArray = new JTextField[]{
			new JTextField(),new JTextField(),new JTextField(),new JTextField(),new JTextField()
	};
	private JButton okButton = new JButton("确定");
	private JButton canButton = new JButton("取消");
	CaDishSearch cdCaDishSearch ;
	String sql;
	String []str = new String[5];
	public ChangeDishDialog(CaDishSearch cds,String []string){
		this.str= string;
		this.cdCaDishSearch = cds; 
		this.setTitle("菜品信息修改");
		this.setVisible(true);
		this.setBounds(0, 0, 300, 300);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setFont(new java.awt.Font("幼圆",0,16));
		for (int i =0; i<5; i++){
			jtxtArray[i].setText(str[i]);
			jlabelArray[i].setBounds(20,20+i*40,100,30);
			jtxtArray[i].setBounds(150, 20+i*40, 100, 30);
			jtxtArray[i].setFont(new Font("幼圆",Font.PLAIN,16));
			jlabelArray[i].setFont(new Font("幼圆",Font.PLAIN,16));
			this.getContentPane().add(jlabelArray[i]);
			this.getContentPane().add(jtxtArray[i]);
		}
		okButton.setBounds(20, 230, 100, 30);
		canButton.setBounds(150	, 230, 100, 30);
		okButton.setFont(new Font("幼圆",Font.PLAIN,16));
		canButton.setFont(new Font("幼圆",Font.PLAIN,16));
		
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
