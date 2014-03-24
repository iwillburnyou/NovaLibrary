package seu.Client.view;
/**
 * ����Ա��Ʒ�������  --By������
 */
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import k.User;

import seu.Client.bz.impl.CanteenInfoImpl;
import seu.Client.bz.impl.CommonImpl;

/**
 * ʳ��ģ��������Ʒ�ĶԻ������
 * @author kidd
 *
 */
public class CaDishSearch extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int flag;//�������λ
	String sql;

	User user;
	//�������ֿؼ�
	private JSplitPane jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT,true); //�ָ�����·ָ�
	
	private String []str ={"����","��ϵ","ʳ��","ȫ��"};
	private JComboBox<String> jcb = new JComboBox<String>(str);
	private String []str2 ={"³��","����","�ղ�","���","����","���","�ղ�","����"};
	private JComboBox<String> jcb2 = new JComboBox<String>(str2);
	private String []str3 ={"÷԰","��԰","��԰"};
	private JComboBox<String> jcb3 = new JComboBox<String>(str3);
	
	private JButton jb = new JButton("��ѯ");
	private JButton jbAdd = new JButton("����²�Ʒ");
	private JButton jbDel = new JButton("ɾ����ѡ��");
	private JButton jbChange = new JButton("�޸���ѡ��");
	private JLabel []jlArray= new JLabel[]{
			new JLabel("   ��   ��"),new JLabel("   ��   ϵ"),new JLabel("   ʳ   ��")
	};
	private JTextField []jtxtArray = new JTextField[]{
			new JTextField(),new JTextField(),new JTextField(),new JTextField()
	};
	private JRadioButton []jrbArray = new JRadioButton[]{
			new JRadioButton("�򵥲�ѯ", true),new JRadioButton("�߼���ѯ")
	};
	private ButtonGroup bg = new ButtonGroup();
	Vector<String> head = new Vector<String>();
	{head.add("����");head.add("��ϵ");head.add("ʳ��");head.add("����");head.add("�۸�");
	};
	Vector<Vector<String>> data = new Vector<Vector<String>>();
	DefaultTableModel dtm = new DefaultTableModel(data, head);//�������ģ��
	JTable jt = new JTable(dtm);
	JScrollPane jspn=new JScrollPane(jt);
	final ImageIcon backgroundtop = new ImageIcon(this.getClass().getResource("/image/��������1.png"));
	final ImageIcon backgroundbottom = new ImageIcon(this.getClass().getResource("/image/ʳ������.png"));
	public CaDishSearch(User us){
		user =us;
		
		JPanel jpt = new JPanel(){
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (backgroundtop != null){
					g.drawImage(backgroundtop.getImage(), 0, 0,this.getWidth(), this.getHeight(), this);
				}
			}
		};
		 JPanel jpb = new JPanel(){
				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					if (backgroundbottom != null){
						g.drawImage(backgroundbottom.getImage(), 0, 0,this.getWidth(), this.getHeight(), this);
					}
				}	
		};
		
		this.setLayout(new GridLayout(1,1));
		jpt.setLayout(null);
		jpb.setLayout(null);
		jpt.add(jcb);
		jcb.setBounds(160, 20, 80, 20);
		jcb.setFont(new Font("��Բ", Font.PLAIN, 16));
		jcb.addActionListener(this);
		
		jpt.add(jb);
		jpt.add(jbDel);
		jpt.add(jbAdd);
		jpt.add(jbChange);
		jpb.add(jspn);
		
		
		jspn.setBounds(0, 0, 880, 454);//���ñ���С
	
		jb.setBounds(390, 20, 180, 20);//��ѯ��ť��Сλ��
		jb.setContentAreaFilled(false);
		//jb.setBorderPainted(false);
		jbAdd.setBounds(390, 50, 180, 20);
		jbAdd.setContentAreaFilled(false);
		//jbAdd.setBorderPainted(false);
		jbDel.setBounds(390, 80, 180, 20);
		jbDel.setContentAreaFilled(false);
		//jbDel.setBorderPainted(false);
		jbChange.setBounds(390, 110, 180, 20);
		jbChange.setContentAreaFilled(false);
		//jbChange.setBorderPainted(false);
		
		jb.setFont(new Font("��Բ", Font.PLAIN, 16));
		jbAdd.setFont(new Font("��Բ", Font.PLAIN, 16));
		jbChange.setFont(new Font("��Բ", Font.PLAIN, 16));
		jbDel.setFont(new Font("��Բ", Font.PLAIN, 16));
		
		jb.addActionListener(this);
		jbDel.addActionListener(this);
		jbAdd.addActionListener(this);
		jbChange.addActionListener(this);
		jbDel.setEnabled(false);
		jbChange.setEnabled(false);
		
		for(int i =0;i<2;i++){
			jrbArray[i].setBounds(20, 20+i*40, 100, 20);
			jrbArray[i].setFont(new Font("��Բ", Font.PLAIN, 16));
			jpt.add(jrbArray[i]);
			jrbArray[i].addActionListener(this);
			bg.add(jrbArray[i]);
		}
		for(int i =0;i<3;i++){
			jlArray[i].setBounds(160,50+i*30, 80, 20);
			jlArray[i].setFont(new Font("��Բ", Font.PLAIN, 16));
			jpt.add(jlArray[i]);
		}
		
		jtxtArray[0].setBounds(270, 50, 80, 20);
		jtxtArray[0].setFont(new Font("��Բ", Font.PLAIN, 16));
		jpt.add(jtxtArray[0]);
		jtxtArray[0].setEditable(false);
		
		jtxtArray[3].setBounds(270, 20, 80, 20);
		jtxtArray[3].setFont(new Font("��Բ", Font.PLAIN, 16));
		jpt.add(jtxtArray[3]);
		
		jcb2.setBounds(270, 80, 80, 20);
		jcb2.setFont(new Font("��Բ", Font.PLAIN, 14));
		jpt.add(jcb2);
		jcb2.setEnabled(false);
		jcb2.setEditable(false);
		jcb3.setBounds(270, 110, 80, 20);
		jcb3.setFont(new Font("��Բ", Font.PLAIN, 14));
		jpt.add(jcb3);
		jcb3.setEnabled(false);
		jcb3.setEditable(false);
		
		jt.setFont(new Font("��Բ", Font.PLAIN, 16));
		jt.getTableHeader().setFont(new Font("��Բ", Font.PLAIN, 16));
		
		jsp.setTopComponent(jpt);
		jsp.setBottomComponent(jpb);
		jsp.setDividerSize(4);
		jsp.setDividerLocation(150);
		
		jt.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event){
				if(event.getButton()==MouseEvent.BUTTON1){
					jbDel.setEnabled(true);
					jbChange.setEnabled(true);
				}
			}
		});
		
		this.add(jsp);
		this.setBounds(3, 10, 700, 400);
		this.setVisible(true);
	
		sql =  "select * from tblDishSearch ";
		paintTable(sql);
	}


	public void actionPerformed(ActionEvent e) {
		/**
		 * �򵥲�ѯ����
		 */
		if(jrbArray[0].isSelected()){//ѡ�м򵥲�ѯ��ť
			jtxtArray[3].setEditable(true);
			for(int i =0;i<jtxtArray.length-1;i++){
				jtxtArray[i].setEditable(false);
			}
			jcb2.setEnabled(false);
			jcb3.setEnabled(false);
			if (jcb.getSelectedIndex()>=0 && jcb.getSelectedIndex()<4) {//��������0-2֮��
				jtxtArray[3].requestFocus();
				if(e.getSource()==jb && jcb.getSelectedIndex()<3){
					String str = jtxtArray[3].getText().trim();//�õ���ѯ����
					if(str.equals("")){
						JOptionPane.showMessageDialog(this, "�������ѯ��Ϣ��","��Ϣ",JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					if(jcb.getSelectedIndex()==0){//��������ѯ
						sql = "select * from tblDishSearch where DishName='"+str+"'";
						jtxtArray[3].setText("");
					}
					else if(jcb.getSelectedIndex()==1){//����ϵ��ѯ
						sql = "select * from tblDishSearch where DishCate='"+str+"'";
						jtxtArray[3].setText("");
					}
					else if(jcb.getSelectedIndex()==2){//��ʳ�ò�ѯ
						sql = "select * from tblDishSearch where CanteenNum='"+str+"'";
						jtxtArray[3].setText("");
					}
					
					paintTable(sql);

				}
				else if(e.getSource()==jb&&jcb.getSelectedIndex()==3){
					sql = "select *from tblDishSearch";
					paintTable(sql);
				}
			}
		}
		/**
		 * �߼���ѯ����
		 */
		if(jrbArray[1].isSelected()){//ѡ�и߼���ѯ��ť��
			jtxtArray[0].requestFocus();
			jtxtArray[3].setEditable(false);
			for(int i=0;i<jtxtArray.length-1;i++){//�����·�������ť�ɱ༭
				jtxtArray[i].setEditable(true);
			}
			jcb.setEnabled(false);
			jcb2.setEnabled(true);
			jcb3.setEnabled(true);
			if(e.getSource()==jb){//��������ѯ����ť
				int bz=this.seniorSearch();
				if(bz!=0){return;}	
				paintTable(sql);
			}
		}
		/**
		 * ɾ������
		 */
		if(e.getSource()==jbDel){//���ɾ����Ʒ��ť�Ĳ���,���ڵ�һ��ɾ��������Ч��������޸�
			int rowIndex = jt.getSelectedRow();
			String dishNameString = (String)jt.getValueAt(rowIndex ,0);
			sql= "delete * from tblDishSearch where DishName='"+dishNameString+"'";
			CanteenInfoImpl.delDish(sql);	
			sql =  "select * from tblDishSearch";
			paintTable(sql);
			jbDel.setEnabled(false);
			jbChange.setEnabled(false);
		}
		if(e.getSource()==jbChange){
			int rowIndex = jt.getSelectedRow();
			String strArray[] = new String[5]; 
			strArray[0]= (String)jt.getValueAt(rowIndex ,0);
			strArray[1] = (String)jt.getValueAt(rowIndex, 1);
			strArray[2] = (String)jt.getValueAt(rowIndex, 2);
			strArray[3] = (String)jt.getValueAt(rowIndex, 3);
			strArray[4] = (String)jt.getValueAt(rowIndex, 4);
			new ChangeDishDialog(this,strArray);
			jbChange.setEnabled(false);
			jbDel.setEnabled(false);
		}
        if(e.getSource()==jbAdd){//�����Ӱ�ť�Ĳ���
			new CaAddDish(this);
			
		}
	    
		
	}
	private int seniorSearch() { //�߼���ѯ������жϲ��� �趨
		int flag = 0;
		String str0 = jtxtArray[0].getText().trim();//�������������
		String str1 = jtxtArray[1].getText().trim();
		String str2 = jtxtArray[2].getText().trim();
		if(str0.equals("")&&str1.equals("")&&str2.equals("")){
			JOptionPane.showMessageDialog(this, "�������Ҫ����Ϣ","��Ϣ",JOptionPane.INFORMATION_MESSAGE);
			flag = 1;
		}
		else if(((!str0.equals(""))&&(str1.equals(""))&&(str2.equals("")))||((str0.equals(""))&&(!str1.equals(""))&&(str2.equals("")))||((str0.equals(""))&&(str1.equals(""))&&(!str2.equals("")))){
			JOptionPane.showMessageDialog(this, "��ʹ�ü�����","��Ϣ",JOptionPane.INFORMATION_MESSAGE);
			flag = 1;
		}
		else if((!str0.equals(""))&&(!str1.equals(""))&&(str2.equals(""))){//�����Ͳ�ϵ���
			sql = "select * from tblDishSearch where DishName='"+str0+"' and DishCate='"+str1+"'";
			for(int i=0;i<3;i++){
				jtxtArray[i].setText("");
			}
		}
		else if((!str0.equals(""))&&(str1.equals(""))&&(!str2.equals(""))){//������ʳ�����
			sql = "select * from tblDishSearch where DishName='"+str0+"' and CanteenNum='"+str2+"'";
			for(int i=0;i<3;i++){
				jtxtArray[i].setText("");
			}
		}
		else if((str0.equals(""))&&(!str1.equals(""))&&(!str2.equals(""))){//ʳ�úͲ�ϵ���
			sql = "select * from tblDishSearch where DishCate='"+str1+"' and CanteenNum='"+str2+"' ";
			for(int i=0;i<3;i++){
				jtxtArray[i].setText("");
			}
		}
		else if((!str0.equals(""))&&(!str1.equals(""))&&(!str2.equals(""))){//�������
			sql = "select * from tblDishSearch where DishName='"+str0+"' and DishCate='"+str1+"' and CanteenNum='"+str2+"' ";
			for(int i=0;i<3;i++){
			
				jtxtArray[i].setText("");
			}
		}
		return flag;
	}
	
	/**
	 * ���Ʋ�Ʒ���ĺ���
	 * @param sqlString
	 */
	void paintTable(String sqlString) {

		Vector<Vector<String>> vtemp =CanteenInfoImpl.getDish(sqlString);//��ű�����ݵ�����
		dtm.setDataVector(vtemp, head);//����table
		jt.updateUI();
		jt.repaint();	
	}

}
