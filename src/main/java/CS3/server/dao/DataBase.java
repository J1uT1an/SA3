package CS3.server.dao;


import CS3.server.model.ContactPerson;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: DataBase
 * @author: Lu Xintong
 * @Version 1.0
 **/
public class DataBase {
	
	// 数据库连接字符串
	private final String conStr = "jdbc:mysql://localhost:3306/software_architecture?Timezone=UTC&Unicode=true&characterEnconding=utf-8";//最新版本的mysql驱动
	// 数据库连接用户名
	private final String dbUserName = "root";
	// 数据库连接密码
	private final String dbPassword = "123456";
	// 数据库连接对象
	private static Connection con = null;
	
	public DataBase() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(conStr, dbUserName, dbPassword);
			System.out.println("[数据库连接成功]");
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static Connection getCon() {
		return con;
	}
	
	
	/**
	 * 查询user信息数据
	 *
	 * @return
	 */
	public static List<ContactPerson> queryUserInfo() {
		String sql = "select * from contacts";
		List<ContactPerson> list = new ArrayList<ContactPerson>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ContactPerson contactPerson = new ContactPerson();
				contactPerson.setId(rs.getInt(1));
				contactPerson.setName(rs.getString(2));
				contactPerson.setPhone(rs.getString(3));
				contactPerson.setAddress(rs.getString(4));
				list.add(contactPerson);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 删除user信息
	 *
	 * @param id
	 * @return
	 */
	public static boolean deleteUserInfo(int id) {
		String sql = "delete from contacts where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int rs = ps.executeUpdate();
			ps.close();
			return rs != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 添加user信息
	 *
	 * @return
	 */
	public static boolean addUserInfo(ContactPerson contactPerson) {
		String sql = "insert into contacts(name,phone,address) values (?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, contactPerson.getName());
			ps.setString(2, contactPerson.getPhone());
			ps.setString(3, contactPerson.getAddress());
			int rs = ps.executeUpdate();
			ps.close();
			return rs != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 修改user信息
	 *
	 * @return
	 */
	public static boolean modifyUserInfo(ContactPerson contactPerson) {
		String sql = "update contacts set name=?,phone=?,address=? where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, contactPerson.getName());
			ps.setString(2, contactPerson.getPhone());
			ps.setString(3, contactPerson.getAddress());
			ps.setInt(4, contactPerson.getId());
			int rs = ps.executeUpdate();
			ps.close();
			return rs != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
