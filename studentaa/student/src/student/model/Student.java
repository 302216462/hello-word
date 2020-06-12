package student.model;
/**
 * 此类是学生对象类
 */
public class Student {
	private String number;//学号
	private String name;//姓名
	private String sex;//性别
	private String birthday;//生日
	//空參构造
	public Student() {
	}
	//全参构造
	public Student(String number, String name, String sex, String birthday) {
		super();
		this.number = number;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
}
