package seu.Client.view.ShopView;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import seu.Client.bz.impl.*;


/**
 * 改变商品信息对话框的视类
 * @author kidd
 *
 */
public class ChangeProInfoJDialog extends javax.swing.JDialog implements ActionListener{
	private JButton jButton1;
	private JTextField jTextField1;
	private JTextField jTextField2;
	private JLabel jLabel1;
	private JComboBox jComboBox1;
	private JButton jButton2;

	/**
	* Auto-generated main method to display this JDialog
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				ChangeProInfoJDialog inst = new ChangeProInfoJDialog(frame);
				inst.setVisible(true);
			}
		});
	}
	
	public ChangeProInfoJDialog(JFrame frame) {
		super(frame);
		initGUI();
	}
	/**
	 * 初始化界面的函数
	 */
	private void initGUI() {
		try {
			setSize(400, 300);
			this.setTitle("修改商品信息");
			this.setVisible(true);
			getContentPane().setLayout(null);
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("\u786e\u5b9a");
				jButton1.setBounds(67, 190, 63, 35);
				jButton1.addActionListener(this);
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("\u53d6\u6d88");
				jButton2.setBounds(201, 190, 64, 35);
				jButton2.addActionListener(this);
			}
			{
				ComboBoxModel jComboBox1Model = 
						new DefaultComboBoxModel(
								new String[] { "增加库存为", "修改价格为" });
				jComboBox1 = new JComboBox();
				getContentPane().add(jComboBox1);
				jComboBox1.setModel(jComboBox1Model);
				jComboBox1.setBounds(38, 107, 151, 45);
				jComboBox1.setFont(new java.awt.Font("微软雅黑",0,14));
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u8bf7\u8f93\u5165\u5546\u54c1\u540d\u79f0");
				jLabel1.setBounds(43, 35, 127, 51);
				jLabel1.setFont(new java.awt.Font("微软雅黑",0,14));
			}
			{
				jTextField2 = new JTextField();
				getContentPane().add(jTextField2);
				jTextField2.setText(" ");
				jTextField2.setBounds(234, 47, 78, 31);
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(234, 113, 78, 36);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
	
		if (e.getSource()==jButton1){
			//进行修改数据库操作 修改库存
			try {
				if(new ShopImpl().IsExist(jTextField2.getText().trim())==true)  {
					if(jComboBox1.getSelectedIndex()==0){
					try {
						new ShopImpl().ChangeCount(jTextField2.getText().trim(),jTextField1.getText().trim());
						JOptionPane.showMessageDialog(this, "修改库存成功！");
					} catch (NumberFormatException e1) {	
						e1.printStackTrace();
					}
				}
				//修改价格
				else  if(jComboBox1.getSelectedIndex()==1){
				try {
					new ShopImpl().ChangePrice(jTextField2.getText().trim(),jTextField1.getText().trim());
					JOptionPane.showMessageDialog(this, "修改价格成功！");
				} catch (NumberFormatException e1) {	
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				}
					this.dispose();
				}
				else {
					JOptionPane.showMessageDialog(this, "该商品不存在", "修改商品信息", JOptionPane.WARNING_MESSAGE);
				}
					
			
			} catch (HeadlessException e1) {
		
				e1.printStackTrace();
			} catch (UnknownHostException e1) {
		
				e1.printStackTrace();
			} catch (IOException e1) {
		
				e1.printStackTrace();
			}
		}		
	
		else if (e.getSource() == jButton2){
			this.dispose();
	}
}
}
