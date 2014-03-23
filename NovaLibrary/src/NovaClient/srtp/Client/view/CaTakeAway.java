/**
 * �����鿴������� by ������
 */
package seu.Client.view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import k.User;

import seu.Client.bz.impl.CanteenInfoImpl;

/**
 * ʳ��ģ�������������
 * @author kidd
 *
 */
public class CaTakeAway extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String sql;
	User user ;
	private JSplitPane jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true);//�������·ָ�
	
	JButton showAllButton = new JButton("��ʾȫ������");
	JButton showUnhandledButton = new JButton("��ʾδ���Ͷ���");
	JButton changeButton = new JButton("����Ϊ�ѷ���");
	JButton delButton = new JButton("ɾ����ѡ��");
	
	Vector<String> head = new Vector<String>();//��ѯ������ʾ�ı�
	{head.add("����");head.add("�۸�");head.add("������");head.add("����ʱ��");head.add("�Ƿ񷢻�");
	};
	Vector<Vector<String>> data = new Vector<Vector<String>>();
	DefaultTableModel dtm = new DefaultTableModel(data, head);//�������ģ��
	JTable jTable = new JTable(dtm);
	JScrollPane jspn=new JScrollPane(jTable);
	
	final ImageIcon background1= new ImageIcon(this.getClass().getResource("/image/��������1.png"));
	final ImageIcon background2 = new ImageIcon(this.getClass().getResource("/image/ʳ������.png"));
	
	public CaTakeAway(User us)
	{
		user = us;
	
		JPanel jtPanel= new JPanel(){
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (background1 != null){
					g.drawImage(background1.getImage(), 0, 0,this.getWidth(), this.getHeight(), this);
				}
			}
		
		};//�Ͻ����󲿷�
		JPanel jbPanel = new JPanel(){
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (background2!= null){
					g.drawImage(background2.getImage(), 0, 0,this.getWidth(), this.getHeight(), this);
				}
			}
		};//�Ͻ����Ҳ���
		this.setLayout(new GridLayout(1,1));
		jtPanel.setLayout(null);
		jbPanel.setLayout(null);
		
		showAllButton.setBounds(20, 20, 140, 30);
		//showAllButton.setBorderPainted(false);
		showAllButton.setContentAreaFilled(false);
		showUnhandledButton.setBounds(180, 20, 140, 30);
		//showUnhandledButton.setBorderPainted(false);
		showUnhandledButton.setContentAreaFilled(false);
		changeButton.setBounds(340, 20, 140, 30);
		//changeButton.setBorderPainted(false);
		changeButton.setContentAreaFilled(false);
		delButton.setBounds(500, 20, 140, 30);
		//delButton.setBorderPainted(false);
		delButton.setContentAreaFilled(false);
		
		showAllButton.setFont(new Font("��Բ", Font.PLAIN, 14));//�����
		showUnhandledButton.setFont(new Font("��Բ", Font.PLAIN, 14));
		changeButton.setFont(new Font("��Բ", Font.PLAIN, 14));
		delButton.setFont(new Font("��Բ", Font.PLAIN, 14));
		jTable.setFont(new Font("��Բ", Font.PLAIN, 16));
		jTable.getTableHeader().setFont(new Font("��Բ", Font.PLAIN, 16));
		
		showAllButton.addActionListener(this);
		showUnhandledButton.addActionListener(this);
		changeButton.addActionListener(this);
		delButton.addActionListener(this);
		changeButton.setEnabled(false);
		delButton.setEnabled(false);
		
		jtPanel.add(showAllButton);
		jtPanel.add(showUnhandledButton);
		jtPanel.add(changeButton);
		jtPanel.add(delButton);
		jbPanel.add(jspn);
		
		
		jspn.setBounds(0, 0, 880, 505);//���ñ���С
		
		jsp.setTopComponent(jtPanel);
		jsp.setBottomComponent(jbPanel);
		jsp.setDividerSize(4);
		jsp.setDividerLocation(100);
		
		jTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event){
				if(event.getButton()==MouseEvent.BUTTON1){
					changeButton.setEnabled(true);
					delButton.setEnabled(true);
				}
			}
		});
		this.add(jsp);
		this.setVisible(true);
		this.setBounds(0, 0, 800, 600);
		sql = "select * from tblDishBuy";
		painttable(sql);
	}
	
	private void setUndecorated(boolean b) {
		// TODO Auto-generated method stub
		
	}

	private void painttable(String sqlString) {
	
		Vector<Vector<String>> vtemp =CanteenInfoImpl.getDish(sqlString);//��ű�����ݵ�����
		dtm.setDataVector(vtemp, head);//����table
		jTable.updateUI();
		jTable.repaint();
		
	}
		
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==showAllButton){
			sql = "select * from tblDishBuy";
			painttable(sql);
		}
		else if (e.getSource()==showUnhandledButton){
			sql = "select * from tblDishBuy where ifSend = '��'";
			painttable(sql);
		}
		else if (e.getSource() == changeButton){
			int rowIndex = jTable.getSelectedRow();
			String dishname = (String)jTable.getValueAt(rowIndex ,0);
			String buyer = (String)jTable.getValueAt(rowIndex ,2);
			CanteenInfoImpl.changeIfSend("update tblDishBuy  set ifSend = '��' where DishName  = '"+dishname+"' and Buyer = '"+buyer+"'");
			painttable("select * from tblDishBuy");
		}
		else if (e.getSource()==delButton){
			int rowIndex = jTable.getSelectedRow();
			String dishname = (String)jTable.getValueAt(rowIndex ,0);
			String buyer = (String)jTable.getValueAt(rowIndex ,2);
			CanteenInfoImpl.delTakeAway("delete from tblDishBuy  where DishName  = '"+dishname+"' and Buyer = '"+buyer+"'");
			painttable("select * from tblDishBuy");
		}	
	}
	
}
