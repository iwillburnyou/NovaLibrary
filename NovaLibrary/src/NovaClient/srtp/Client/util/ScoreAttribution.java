package seu.Client.util;

import k.MessageType;






public class ScoreAttribution extends Model implements MessageType {

	private static final long serialVersionUID = 1L;

	public ScoreAttribution(int type, String key) {
		super(type, key);
		setCol();
	}

	public ScoreAttribution(int type, String key1, String key2) {
		super(type, key1, key2);
		setCol();
	}

	private void setCol() {
		columnNames.add("学生学号");
		columnNames.add("学生姓名");
		columnNames.add("课程编号");
		columnNames.add("课程名称");
		columnNames.add("成绩");

	}

}