package student.view;

import java.awt.*;
import javax.swing.*;

import student.dao.StuDao;
import student.model.Student;

import java.util.*;
/**
 * 查询列表类
 *
 */
public class ListFrame extends JFrame {
	JButton buttonreturn = new JButton("返回");
	JTable jtable;
	JScrollPane jscrollpane = new JScrollPane();

	Vector columnNames = null;
	Vector rowData = null;

	public ListFrame() {
		ArrayList<Student> students = new StuDao().listStu();
		JPanel jpforbutton = new JPanel();

		columnNames = new Vector();
		columnNames.add("学号");
		columnNames.add("姓名");
		columnNames.add("性别");
		columnNames.add("出生日期");
		rowData = new Vector();
		jpforbutton.add(buttonreturn); 
		for (int i = 0; i < students.size(); i++) {
			Vector hang = new Vector();
			hang.add(students.get(i).getNumber());
			hang.add(students.get(i).getName());
			hang.add(students.get(i).getSex());
			hang.add(students.get(i).getBirthday());
			rowData.add(hang);
		}

		jtable = new JTable(rowData, columnNames);
		jscrollpane = new JScrollPane(jtable);

		this.setLayout(new FlowLayout());
		this.add(jscrollpane);
		this.add(jpforbutton);
		// 窗口标题
		this.setTitle("学生系统-学生列表");
		// 窗体大小
		this.setSize(500, 340);
		// 设置图标
		this.setIconImage((new ImageIcon("images/index.jpg")).getImage());
		// 设置可关闭进程
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// 获得屏幕宽度
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		// 获得屏幕高度
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		// 居中显示
		this.setLocation((width - 500) / 2, (height - 400) / 2);
		// 设置窗体可见
		this.setVisible(true);
		// 可改变窗体大小
		this.setResizable(false);

	}

}