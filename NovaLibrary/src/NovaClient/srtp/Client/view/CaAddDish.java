package seu.Client.view;
/**
*添加菜品的界面类--by 张雅淋
*/
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.WindowConstants;

import seu.Client.bz.impl.CanteenInfoImpl;



/**
 * 食堂模块增加菜品的对话框界面
 * @author kidd
 *
 */
public class CaAddDish extends javax.swing.JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel dishName;
	private JLabel dishCate;
	private JComboBox<String> jcbIfTakeAway;
	private JButton jbCancel;
	private JButton jbAdd;
	private JLabel jLabel1;
	private JTextField jtPrice;
	private JComboBox<String> jcbCanteenNum;
	private JTextField jtDishCate;
	private JTextField jtDishName;
	private JLabel Price;
	private JLabel ifTakeAway;
	private JLabel canteenNum;
    CaDishSearch cdCaDishSearch ;

		
	public CaAddDish(CaDishSearch cds) {
		super();
		cdCaDishSearch = cds;
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setTitle("菜品添加");
			this.setVisible(true);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setFont(new java.awt.Font("幼圆",0,16));
			{
				dishName = new JLabel();
				getContentPane().add(dishName);
				dishName.setText("\u83dc\u540d：");
				dishName.setBounds(26, 41, 54, 34);
				dishName.setFont(new java.awt.Font("微软雅黑",0,16));
			}
			{
				dishCate = new JLabel();
				getContentPane().add(dishCate);
				dishCate.setText("\u83dc\u7cfb：");
				dishCate.setBounds(26, 92, 54, 34);
				dishCate.setFont(new java.awt.Font("微软雅黑",0,16));
			}
			{
				canteenNum = new JLabel();
				getContentPane().add(canteenNum);
				canteenNum.setText("\u98df\u5802：");
				canteenNum.setBounds(26, 144, 54, 34);
				canteenNum.setFont(new java.awt.Font("微软雅黑",0,16));
			}
			{
				ifTakeAway = new JLabel();
				getContentPane().add(ifTakeAway);
				ifTakeAway.setText("\u5916\u5356：");
				ifTakeAway.setBounds(26, 195, 54, 34);
				ifTakeAway.setFont(new java.awt.Font("微软雅黑",0,16));
			}
			{
				Price = new JLabel();
				getContentPane().add(Price);
				Price.setText("\u4ef7\u683c：");
				Price.setBounds(26, 247, 54, 34);
				Price.setFont(new java.awt.Font("微软雅黑",0,16));
			}
			{
				jtDishName = new JTextField();
				getContentPane().add(jtDishName);
				jtDishName.setBounds(92, 41, 180, 34);
			}
			{
				jtDishCate = new JTextField();
				getContentPane().add(jtDishCate);
				jtDishCate.setBounds(92, 92, 180, 34);
			}
			{
				ComboBoxModel<String> jcbCanteenNumModel = 
						new DefaultComboBoxModel<String>(
								new String[] { "梅园", "桃园" ,"橘园"});
				jcbCanteenNum = new JComboBox<String>();
				getContentPane().add(jcbCanteenNum);
				jcbCanteenNum.setModel(jcbCanteenNumModel);
				jcbCanteenNum.setBounds(92, 150, 180, 34);
				jcbCanteenNum.setBackground(new java.awt.Color(255,255,255));
				jcbCanteenNum.setFont(new java.awt.Font("幼圆",0,16));
			}
			{
				ComboBoxModel<String> jcbIfTakeAwayModel = 
						new DefaultComboBoxModel<String>(
								new String[] { "是", "否" });
				jcbIfTakeAway = new JComboBox<String>();
				getContentPane().add(jcbIfTakeAway);
				jcbIfTakeAway.setModel(jcbIfTakeAwayModel);
				jcbIfTakeAway.setBounds(92, 201, 180, 34);
				jcbIfTakeAway.setBackground(new java.awt.Color(255,255,255));
				jcbIfTakeAway.setFont(new java.awt.Font("幼圆",0,16));
			}
			{
				jtPrice = new JTextField();
				getContentPane().add(jtPrice);
				jtPrice.setBounds(92, 247, 180, 34);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u83dc\u7cfb：");
				jLabel1.setFont(new java.awt.Font("微软雅黑",0,16));
				jLabel1.setBounds(26, 92, 54, 34);
			}
			{
				jbAdd = new JButton();
				getContentPane().add(jbAdd);
				jbAdd.setText("\u6dfb\u52a0");
				jbAdd.setBounds(26, 314, 71, 41);
				jbAdd.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jbAddMouseClicked(evt);
					}
				});
			}
			{
				jbCancel = new JButton();
				getContentPane().add(jbCancel);
				jbCancel.setText("\u53d6\u6d88");
				jbCancel.setBounds(201, 314, 71, 41);
				jbCancel.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						jbCancelMouseClicked(evt);
					}
				});
			}
			pack();
			this.setSize(350, 420);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void jbAddMouseClicked(MouseEvent evt) {
		String dishNameString = jtDishName.getText().trim();
		String dishCateString = jtDishCate.getText().trim();
		String canteenNumString ;
		if(jcbCanteenNum.getSelectedIndex()==0){
			canteenNumString ="梅园";
		}
		else if(jcbCanteenNum.getSelectedIndex()==1){
			canteenNumString = "桃园";	
		}
		else {
			canteenNumString = "橘园";
		}
		String ifTakeAwayString ;
		if(jcbIfTakeAway.getSelectedIndex()==0){
			ifTakeAwayString ="是";
		}
		else {
			ifTakeAwayString ="否";
		}
		String priceString = jtPrice.getText().trim();
		if(dishNameString.isEmpty()||dishCateString.isEmpty()||priceString.isEmpty()){
			JOptionPane.showMessageDialog(this, "请输入必要的信息！","信息",JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		String sqlString = "insert into tblDishSearch  values('" + dishNameString +"','"+dishCateString + "','" + canteenNumString +"','"+ ifTakeAwayString +"','" + priceString + "')";
		CanteenInfoImpl.addDish(sqlString);
		
		JOptionPane.showMessageDialog(this, "添加菜品成功！","信息",JOptionPane.INFORMATION_MESSAGE);
		jtDishCate.setText("");
		jtDishName.setText("");
		jtPrice.setText("");
		jtDishName.requestFocus();
		cdCaDishSearch.paintTable("select * from tblDishSearch ");	
	}
	private void jbCancelMouseClicked(MouseEvent evt) {
		this.dispose();
	}
	
}
