package seu.Client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import seu.Client.util.GBLAdd;
/**
 * ѡ��ģ�鵥���γ̵�������
 * @author kidd
 *
 */
public class SingleSubjPanel extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame parent;
	// ��Ϣ���
	private JPanel jpInfo = new JPanel();
	String SubjectSort;// �������ڰ��б�����

	public JLabel jlSubjName = new JLabel("�γ����ƣ�");
	public JLabel jlSubjTeacher = new JLabel("�ον�ʦ��");
	public JLabel jlSubjId = new JLabel("�γ̱�ţ�");
	public JLabel jlSubjNum = new JLabel("��ʱ��");
	public JLabel jlSubjCredit = new JLabel("ѧ�֣�");
	// �ٿ����
	private JPanel jpComp = new JPanel();
	public JButton jbElect = new JButton("ѡ��γ�");
	public JButton jbCancel = new JButton("��ѡ�γ�");
	private Border border;
	//public JTable jt = new JTable();
	
	
	public SingleSubjPanel(String subjectSort, JFrame jf) {
		SubjectSort = subjectSort;
		parent = jf;
		jbElect.addActionListener(this);
		jbCancel.addActionListener(this);
		setInfoPanel();
		setControlPanel();
		setSingleSubjPanel();
	
	}






	private void setInfoPanel() {
		jpInfo.setLayout(new GridBagLayout());
		jpInfo.setBackground(Color.white);
		GridBagConstraints gbConstraints = new GridBagConstraints(); // Create
																		// an
																		// GridBagConstraints
																		// object
		gbConstraints.fill = GridBagConstraints.BOTH;
		gbConstraints.anchor = GridBagConstraints.CENTER;
		gbConstraints.insets = new Insets(10, 100, 15, 115);

		// add label to the panel
		GBLAdd.addComp(jlSubjName, jpInfo, gbConstraints, 0, 0, 1, 1, 0, 0);
		GBLAdd.addComp(jlSubjTeacher, jpInfo, gbConstraints, 1, 0, 1, 1, 0, 0);
		GBLAdd.addComp(jlSubjId, jpInfo, gbConstraints, 0, 1, 1, 1, 0, 0);
	    GBLAdd.addComp(jlSubjNum, jpInfo, gbConstraints, 1, 1, 1, 1, 0, 0);
	    GBLAdd.addComp(jlSubjCredit, jpInfo, gbConstraints, 2, 1, 1, 1, 0, 0);
	}

	private void setSingleSubjPanel() {
		this.setLayout(new BorderLayout());
		JPanel jpSort = new JPanel();
		jpSort.setBackground(Color.white);
		jpSort.add(new JLabel(SubjectSort));
		jpSort.setPreferredSize(new Dimension(64, 64));
        jpComp.setBackground(Color.white);
        
		this.add(jpSort, BorderLayout.WEST);
		this.add(jpInfo, BorderLayout.CENTER);// , BorderLayout.WEST
		this.add(jpComp, BorderLayout.EAST); // , BorderLayout.EAST

		border = new EtchedBorder(1, Color.ORANGE, Color.BLACK);
		this.setBorder(border);
	}

	

	// ���òٿ����
	private void setControlPanel() {
		// �ġ���ѡ�γ̰�ťĬ�ϲ��ɵ��
		jbCancel.setEnabled(false);

		jpComp.setLayout(new GridBagLayout());
		GridBagConstraints gbConstraints = new GridBagConstraints(); // Create
																		// an
																		// GridBagConstraints
																		// object
		gbConstraints.fill = GridBagConstraints.BOTH;
		gbConstraints.anchor = GridBagConstraints.CENTER;
		gbConstraints.insets = new Insets(10, 10, 10, 10);

		GBLAdd.addComp(jbElect, jpComp, gbConstraints, 0, 0, 1, 1, 0, 0);
		GBLAdd.addComp(jbCancel, jpComp, gbConstraints, 0, 1, 1, 1, 0, 0);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jbElect)
		{
			jbCancel.setEnabled(true);
		    JOptionPane.showMessageDialog(null, "ѡ�γɹ���");
		    jbElect.setEnabled(false);
		}
		if (e.getSource()==jbCancel) {
			JOptionPane.showMessageDialog(null, "��ѡ�ɹ���");
			jbElect.setEnabled(true);
			jbCancel.setEnabled(false);
		
		} 
		
	}
}	

