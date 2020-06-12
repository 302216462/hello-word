package student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import student.model.Student;
import student.utils.DbUtil;

/**
 * 此类是用来操作数据库的类
 */
public class StuDao {
	/**
	 * 添加学生信息 * 
	 * @param 入参是一个学生
	 * @return 成功是否
	 */
	public boolean addStu(Student student) {
		Connection connection = DbUtil.getConnection();// 获得数据库连接对象
		String sql = "INSERT INTO student(number,name,sex,birthday)values(?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, student.getNumber());
			ps.setString(2, student.getName());
			ps.setString(3, student.getSex());
			ps.setString(4, student.getBirthday());
			if (!ps.execute()) {
				DbUtil.close(connection, ps);// 关闭连接
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;// 失败
	}

	/**
	 * 刪除指定的学号学生信息
	 * 
	 * @param number
	 * @return 成功是否
	 */
	public boolean delStu(String number) {
		Connection connection = DbUtil.getConnection();
		String sql = "delete from student where number=?";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, number);
			if (!ps.execute()) {// 删除成功
				DbUtil.close(connection, ps);// 关闭连接
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 更新指定的学生信息
	 * 
	 * @param number
	 * @return 成功是否
	 */
	public boolean updateStu(Student student) {
		Connection connection = DbUtil.getConnection();// 获得数据库连接对象
		String sql = "update student set name=?,sex=?,birthday=? where number=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, student.getName());
			ps.setString(2, student.getSex());
			ps.setString(3, student.getBirthday());
			ps.setString(4, student.getNumber());
			if (!ps.execute()) {
				DbUtil.close(connection, ps);// 关闭连接
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;// 失败
	}

	/**
	 * 根据学号查询学生
	 * 
	 * @return 学生
	 */
	public Student findStu(String number) {
		Connection connection = DbUtil.getConnection();
		String sql = "SELECT number,name,sex,birthday FROM student where number=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, number);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {// 存在学生，封装返回
				Student student = new Student(rs.getString("number"), rs.getString("name"), rs.getString("sex"),
						rs.getString("birthday"));
				DbUtil.close(connection, ps);// 关闭连接
				return student;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;// 没有学生
	}

	/**
	 * 學生列表
	 * 
	 * @return ArrayList<Student>
	 */
	public ArrayList<Student> listStu() {
		ArrayList<Student> students = new ArrayList<Student>();// 用户存放学生的集合
		Connection connection = DbUtil.getConnection();// 获得数据库连接对象
		String sql = "SELECT number,name,sex,birthday FROM student";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {// 存在学生，封装返回
				Student student = new Student(rs.getString("number"), rs.getString("name"), rs.getString("sex"),
						rs.getString("birthday"));
				students.add(student);
			}
			DbUtil.close(connection, ps);// 关闭连接
			return students;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
