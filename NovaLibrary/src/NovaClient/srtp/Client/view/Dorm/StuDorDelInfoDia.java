package seu.Client.view.Dorm;



import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import seu.Client.bz.impl.StudentDorInfoImpl;

/**
 * ����ģ��ɾ����Ϣ�Ի���
 * @author kidd
 *
 */

public class StuDorDelInfoDia extends JDialog{
	
	JLabel jstuID,jrestuID;
	JTextField  jftstuID,jftrestuID;
	JButton jbOK,jbCancel;
	JPanel jp1, jp2;
	
	public StuDorDelInfoDia(Frame owner, String title, boolean modal){
		super(owner, title, modal);
		buildWidgets();
		setProperties();
		}
	private void buildWidgets() {
	
		jstuID=new JLabel("ѧ��");
		jrestuID=new JLabel("ȷ��ѧ��");
		
		jbOK=new JButton("ȷ��");
		jbOK.addActionListener(new Listener());
		jbCancel=new JButton("ȡ��");
		jbCancel.addActionListener(new Listener());
		
		jftstuID=new JTextField();
		jftrestuID=new JTextField();
		
	    jp1=new JPanel(new GridLayout(2, 2, 10, 10));
	    jp1.add(jstuID);
	    jp1.add(jftstuID);
	    jp1.add(jrestuID);
	    jp1.add(jftrestuID);
	    
	    jp2 = new JPanel();
		jp2.add(jbOK);
		jp2.add(jbCancel);

		this.add(jp1, "North");
		this.add(jp2, "South");
	    
		
	}
	
	private void setProperties() {
		this.setResizable(false);
		this.setLocationRelativeTo(null); // ����
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(200, 200);
		this.setVisible(true);
	}
	//
	private class Listener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==jbOK){
				doOK();
			}
			else{
				doCancel();
			}
		}
		
	}
	//
	public void doOK(){
		if(isQualified()){
		//	DormitoryINFO dormi = new DormitoryINFO();
		//    dormi.StuDel(jftstuID.getText());
			//System.out.println("sql");
			StudentDorInfoImpl.StuDel(jftstuID.getText());
			this.dispose();
		}
		else{
		JOptionPane.showMessageDialog(null,"���������ѧ�Ų�ͬ����ȷ�Ϻ���������");
		}
	}
	//
	public void doCancel(){
		this.dispose();
	}
	//
	
	private boolean isQualified(){
		if(jftstuID.getText().equals(jftrestuID.getText())){
			return true;
		}
		else{
			
			return false;
		}
	}
}

