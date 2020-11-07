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
		// ����JDBC����
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// �������ݴ洢����
		User u = null;
		// ��������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// ��ȡ���Ӷ���
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sjk", "root", "00000000");
			// ����SQL����
			String sql = "select * from t_user where uname=? and pwd=?";
			// ����SQL�������
			ps = conn.prepareStatement(sql);
			// ��ռλ����ֵ
			ps.setString(1, uname);
			ps.setString(2, pwd);
			// ִ��
			rs = ps.executeQuery();
			// ����ִ�н��
			while (rs.next()) {
				u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
			}
			// �ر����ӳ�
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
		// ����JDBC����
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				// �������ݴ洢����
				User u = null;
				// ��������
				try {
					Class.forName("com.mysql.jdbc.Driver");
					// ��ȡ���Ӷ���
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sjk", "root", "00000000");
					// ����SQL����
					String sql = "select * from t_user where uid = ?";
					// ����SQL�������
					ps = conn.prepareStatement(sql);
					// ��ռλ����ֵ
					ps.setString(1, uid);
					// ִ��
					rs = ps.executeQuery();
					// ����ִ�н��
					while (rs.next()) {
						u = new User();
						u.setUid(rs.getInt("uid"));
						u.setUname(rs.getString("uname"));
						u.setPwd(rs.getString("pwd"));
					}
					// �ر����ӳ�
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
