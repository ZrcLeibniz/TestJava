package zrc.Dao;

import zrc.pojo.User;

public interface LoginDao {
	User checkLoginDao(String uname, String pwd);
	User checkLoginDao(String uid);
}
