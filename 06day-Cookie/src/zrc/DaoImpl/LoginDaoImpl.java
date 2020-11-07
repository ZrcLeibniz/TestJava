package zrc.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import zrc.Dao.LoginDao;
import zrc.pojo.User;

public class LoginDaoImpl implements LoginDao {

	@Override
	public User checkLoginDao(String uname, String pwd) {
		// 声明JDBC对象
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 声明数据存储对象
		User u = null;
		// 加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 获取链接对象
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sjk", "root", "00000000");
			// 创建SQL命令
			String sql = "select * from t_user where uname=? and pwd=?";
			// 创建SQL命令对象
			ps = conn.prepareStatement(sql);
			// 给占位符赋值
			ps.setString(1, uname);
			ps.setString(2, pwd);
			// 执行
			rs = ps.executeQuery();
			// 遍历执行结果
			while (rs.next()) {
				u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
			}
			// 关闭连接池
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return u;
	}

	@Override
	public User checkLoginDao(String uid) {
		// 声明JDBC对象
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				// 声明数据存储对象
				User u = null;
				// 加载驱动
				try {
					Class.forName("com.mysql.jdbc.Driver");
					// 获取链接对象
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sjk", "root", "00000000");
					// 创建SQL命令
					String sql = "select * from t_user where uid = ?";
					// 创建SQL命令对象
					ps = conn.prepareStatement(sql);
					// 给占位符赋值
					ps.setString(1, uid);
					// 执行
					rs = ps.executeQuery();
					// 遍历执行结果
					while (rs.next()) {
						u = new User();
						u.setUid(rs.getInt("uid"));
						u.setUname(rs.getString("uname"));
						u.setPwd(rs.getString("pwd"));
					}
					// 关闭连接池
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return u;
	}

}
