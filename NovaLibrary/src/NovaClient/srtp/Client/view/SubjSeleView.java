package seu.Client.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.TableRowSorter;

import seu.Client.bz.impl.CommonImpl;
import seu.Client.bz.impl.ISubjseleImpl;
import seu.Client.util.ScoreAttribution;
import seu.Client.util.SubjectAttribution;

import k.MessageType;
import k.User;

public class SubjSeleView extends JFrame implements ActionListener, MessageType {

	public static void main(String[] args) {
		try {
			CommonImpl.initSocket();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SubjSeleView seleView  = new SubjSeleView(new User());
		CommonImpl.closeSocket();
	}
	private static final long serialVersionUID = 1L;
	SubjectAttribution cm = null;
	ScoreAttribution sm = null;
	ISubjseleImpl isub;
	TableRowSorter<?> trs;

	CardLayout cardLayout = new CardLayout();
	public JPanel jp = new JPanel();
	public User user = new User();

	public SubjSeleView(User user1) {
		this.user = user1;
		String sql = "Create table "
				+ user.getCardNo()
				+ " (课程ID char(15),课程名称  char(15),任课老师  char(15),课时安排  char(15),学分   char(15))";
		ISubjseleImpl.stuCur(sql);
		setProperties();
		AllSubjPanel jpm = new AllSubjPanel(this, this.user);
		// setManinPanel();
		this.setLayout(new BorderLayout());
		this.add(jpm, BorderLayout.CENTER);

	}

	private void setProperties() {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null); // 居中
		//this.setVisible(true);
	}

	private void setManinPanel() {

		// jp.setLayout(cardLayout());
		// jp.add(jpm);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}