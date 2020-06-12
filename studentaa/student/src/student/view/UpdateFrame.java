package student.view;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import student.dao.StuDao;
import student.model.Student;

/**
 * 这个类是处理修改操作的界面类
 */
public class UpdateFrame extends JFrame {// 继承父窗体类
	// 定义要用到学号 姓名 性别 出生日期四个标签
	JLabel jlnumber;
	JLabel jlname;
	JLabel jlsex;
	JLabel jlbirthday;
	// 定义要用到学号 姓名 性别 出生日期四个文本框
	JTextField jtnumber;
	JTextField jtname;
	JTextField jtsex;
	JTextField jtbirthday;
	// 两个按钮
	JButton buttonupdate;
	JButton buttonreturn;
	// 定义要用到学号 姓名 性别 出生日期四个面板
	JPanel jpnumber;
	JPanel jpname;
	JPanel jpsex;
	JPanel jpbirthday;
	// 用于放置按钮的面板
	JPanel jpforbutton;

	/*
	 * 定义初始化变量以及窗体
	 */
	public UpdateFrame() {
		// 初始化要用到学号 姓名 性别 出生日期四个标签
		jlnumber = new JLabel("学号：");
		jlname = new JLabel("姓名：");
		jlsex = new JLabel("性别：");
		jlbirthday = new JLabel("出生日期：");
		// 初始化要用到学号 姓名 性别 出生日期四个文本框
		jtnumber = new JTextField("", 20);
		jtname = new JTextField("", 20);
		jtsex = new JTextField("", 20);
		jtbirthday = new JTextField("", 20);
		// 初始化两个按钮
		buttonupdate = new JButton("修改");
		buttonreturn = new JButton("返回");
		// 初始化要用到学号 姓名 性别 出生日期四个面板
		jpnumber = new JPanel();
		jpname = new JPanel();
		jpsex = new JPanel();
		jpbirthday = new JPanel();
		// 用于放置按钮的面板
		jpforbutton = new JPanel(new GridLayout(1, 1));
		// 学号面板修改学号标签和学号文本框
		jpnumber.add(jlnumber);
		jpnumber.add(jtnumber);
		// 姓名面板修改姓名标签和姓名文本框
		jpname.add(jlname);
		jpname.add(jtname);
		// 性别面板修改性别标签和性别文本框
		jpsex.add(jlsex);
		jpsex.add(jtsex);
		// 生日面板修改生日标签和生日文本框
		jpbirthday.add(jlbirthday);
		jpbirthday.add(jtbirthday);
		// 按钮面板修改两个按钮
		jpforbutton.add(buttonupdate);
		jpforbutton.add(buttonreturn);
		// 处理修改按钮点击事件
		// 处理返回按钮点击事件
		buttonupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = jtnumber.getText().trim().toString();
				String name = jtname.getText().trim().toString();
				String sex = jtsex.getText().trim().toString();
				String birthday = jtbirthday.getText().trim().toString();
				if (number.equals("")) {
					JOptionPane.showMessageDialog(UpdateFrame.this, "学号不能为空");
				} else {
					// 调用操作数据库
					StuDao stuDao = new StuDao();
					if (stuDao.findStu(number)== null) {
						JOptionPane.showMessageDialog(UpdateFrame.this, "输入正确的学生学号");
					} else {
						if (stuDao.updateStu(new Student(number, sex, name, birthday))) {
							JOptionPane.showMessageDialog(UpdateFrame.this, "学生修改成功");
						} else {
							JOptionPane.showMessageDialog(UpdateFrame.this, "修改异常  请填写正确表单");
						}
					}

				}
			}
		});
		// 处理返回按钮点击事件
		buttonreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 返回主窗体
				UpdateFrame.this.dispose();// 关闭当前窗口
				MainFrame window = new MainFrame();
			}
		});

		// 将五个面板使用网格布局方式修改到当前
		this.setLayout(new GridLayout(9, 1));
		this.add(jpnumber);
		this.add(jpname);
		this.add(jpsex);
		this.add(jpbirthday);
		this.add(jpforbutton);
		// 窗口标题
		this.setTitle("修改學生信息");
		// 窗体大小
		this.setSize(500, 340);
		// 设置图标
		this.setIconImage((new ImageIcon("images/index.jpg")).getImage());
		// 设置可关闭进程
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
