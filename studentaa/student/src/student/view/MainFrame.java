package student.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 这个类是学生管理系统主窗体
 */
public class MainFrame extends JFrame {// 继承父窗体类
	// 定义要用到的按钮
	JButton addBtn;// 添加
	JButton updateBtn;// 更新
	JButton findBtn;// 查询
	JButton delBtn;// 删除
	JButton listBtn;// 浏览

	/**
	 * 使用构造方法对主窗体窗口初始化
	 */
	public MainFrame() {
		// 窗口标题
		this.setTitle("学生信息管理系统");
		// 窗体大小
		this.setSize(300, 240);
		// 设置图标
		this.setIconImage((new ImageIcon("images/index.jpg")).getImage());
		// 设置可关闭进程
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 获得屏幕宽度
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		// 获得屏幕高度
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		// 居中显示
		this.setLocation((width - 300) / 2, (height - 240) / 2);
		// 设置窗体可见
		this.setVisible(true);
		// 可改变窗体大小
		this.setResizable(false);

	/**
	 * 对窗体上面的组件初始化
	 */

		// 对操作按钮初始化
		addBtn = new JButton("添加学生");
		updateBtn = new JButton("修改学生");
		findBtn = new JButton("查询学生");
		delBtn = new JButton("删除学生");
		listBtn = new JButton("学生列表");
		// 创建一个放按钮的面板
		JPanel panel = new JPanel();
		panel.add(addBtn);
		panel.add(updateBtn);
		panel.add(findBtn);
		panel.add(delBtn);
		panel.add(listBtn);
		//将面板放到窗体
		this.add(panel);
		//监听按钮的点击
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//主窗体消失
				MainFrame.this.dispose();
				AddFrame add = new AddFrame();

			}
		});

		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//主窗体消失
				MainFrame.this.dispose();
				UpdateFrame uf = new UpdateFrame();
			}
		});

		findBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//主窗体消失
				MainFrame.this.dispose();
				FindFrame fd = new FindFrame();
			}
		});

		delBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//主窗体消失
				MainFrame.this.dispose();
				DelFrame df = new DelFrame();
			}
		});

		listBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//主窗体消失
				ListFrame lf = new ListFrame();
			}
		});

	}
}