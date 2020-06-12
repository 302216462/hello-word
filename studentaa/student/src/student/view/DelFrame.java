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
 * 这个类是处理删除操作的界面类
 */
public class DelFrame extends JFrame {// 继承父窗体类
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
	JButton buttondel;
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
	public DelFrame() {
		// 初始化要用到学号
		jlnumber = new JLabel("学号：");
	
		// 初始化要用到学号 文本框
		jtnumber = new JTextField("", 20);
		
		// 初始化两个按钮
		buttondel = new JButton("删除");
		buttonreturn = new JButton("返回");
		// 初始化要用到学号面板
		jpnumber = new JPanel();
		// 用于放置按钮的面板
		jpforbutton = new JPanel(new GridLayout(1, 1));
		// 学号面板添加学号标签和学号文本框
		jpnumber.add(jlnumber);
		jpnumber.add(jtnumber);
		// 按钮面板添加两个按钮
		jpforbutton.add(buttondel);
		jpforbutton.add(buttonreturn);
		// 处理刪除按钮点击事件
		buttondel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = jtnumber.getText().trim().toString();
				if (number.equals("")) {
					JOptionPane.showMessageDialog(DelFrame.this, "学号不能为空");
				} else {
					// 调用操作数据库
					StuDao stuDao = new StuDao();
					if (stuDao.findStu(number)== null) {
						JOptionPane.showMessageDialog(DelFrame.this, "学号不存在");
					} else {
						if (stuDao.delStu(number)) {
							JOptionPane.showMessageDialog(DelFrame.this, "学生删除成功");
						} else {
							JOptionPane.showMessageDialog(DelFrame.this, "删除异常  请填写正确表单");
						}
					}

				}
			}
		});
		// 处理返回按钮点击事件
		buttonreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 返回主窗体
				DelFrame.this.dispose();
				MainFrame window = new MainFrame();
			}
		});

		// 将五个面板使用网格布局方式添加到当前
		this.setLayout(new GridLayout(9, 1));
		this.add(jpnumber);
		this.add(jpforbutton);
		// 窗口标题
		this.setTitle("刪除學生信息");
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
