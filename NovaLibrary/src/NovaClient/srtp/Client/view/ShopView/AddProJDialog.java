package seu.Client.view.ShopView;
import java.awt.HeadlessException;
import java.awt.SystemTray;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import seu.Client.bz.impl.*;


/**
 * 增加一个商品对话框的视类
 * @author 张梦微
 *
 */
public class AddProJDialog extends javax.swing.JDialog implements ActionListener {
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JButton jButton1;
	private JTextField jTextField4;
	private JButton jButton2;
	private JTextField jTextField3;
	private JTextField jTextField2;
	private JTextField jTextField1;

	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				AddProJDialog inst = new AddProJDialog(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public AddProJDialog(JFrame frame) {
		super(frame);
		initGUI();
	}
	/**
	 * 初始化界面的函数
	 */
	private void initGUI() {
		try {
			{
				getContentPane().setLayout(null);
				getContentPane().setBackground(new java.awt.Color(255,255,255));
			}
			this.setSize(548, 355);
			this.setTitle("新品上架");
			this.setVisible(true);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u5546\u54c1\u7c7b\u522b");
				jLabel1.setBounds(47, 21, 73, 24);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("\u5546\u54c1\u540d\u79f0");
				jLabel2.setBounds(47, 64, 79, 29);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("\u5546\u54c1\u4ef7\u683c");
				jLabel3.setBounds(47, 105, 73, 29);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("\u5546\u54c1\u5e93\u5b58");
				jLabel4.setBounds(47, 143, 73, 27);
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				////jTextField1.setText(null);
				jTextField1.setBounds(193, 55, 108, 32);
			}
			{
				jTextField2 = new JTextField();
				getContentPane().add(jTextField2);
				//jTextField2.setText(null);
				jTextField2.setBounds(193, 97, 104, 34);
			}
			{
				jTextField3 = new JTextField();
				getContentPane().add(jTextField3);
				//jTextField3.setText(null);
				jTextField3.setBounds(193, 141, 103, 29);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("\u786e\u5b9a");
				jButton1.setBounds(106, 225, 66, 36);
				jButton1.addActionListener(this);
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("\u53d6\u6d88");
				jButton2.setBounds(244, 225, 67, 36);
				jButton2.addActionListener(this);
			}
			{
				jTextField4 = new JTextField();
				getContentPane().add(jTextField4);
				//jTextField4.setText(null);
				jTextField4.setBounds(193, 12, 108, 32);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==jButton1){
			if(jTextField4.getText().trim().equals("")||jTextField2.getText().trim().equals("")
					||jTextField1.getText().trim().equals("")||jTextField3.getText().trim().equals("")){
				JOptionPane.showMessageDialog(this, "请完成未填写完整的信息！", "新品上市", JOptionPane.ERROR_MESSAGE);
				return;
			}
			//将新品信息入表
			
			// 增设一个label显示添加成功
				else  {
					//由商品名称判断是否存在相同商品 存在弹出对话框 “存在该商品” 不存在则入表
					
					try {
						if(new ShopImpl().IsExist(jTextField1.getText().trim())==true) new JOptionPane().showMessageDialog(this,"此商品已经存在", "新品上架",JOptionPane.WARNING_MESSAGE);
						else {
							try {new ShopImpl().AddPro(jTextField4.getText().trim(),jTextField1.getText().trim(),
									Double.parseDouble(jTextField2.getText().trim()),Integer.parseInt(jTextField3.getText().trim()));
							JOptionPane.showMessageDialog(this, "商品添加成功！");
							} catch (NumberFormatException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							
							
							
							this.setVisible(false);
						}
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (UnknownHostException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
		}
		else if(e.getSource()==jButton2){
			this.setVisible(false);
		}
	}

}
