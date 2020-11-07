package zrc.service.impl;

import zrc.Dao.LoginDao;
import zrc.DaoImpl.LoginDaoImpl;
import zrc.pojo.User;
import zrc.service.LoginService;

public class LoginServiceImpl implements LoginService {
	// ����Dao�����
	LoginDao ld = new LoginDaoImpl();

	@Override
	public User checkLoginService(String uname, String pwd) {
		return ld.checkLoginDao(uname, pwd);
	}

	@Override
	public User CheckLoginservice(String uid) {
		return ld.checkLoginDao(uid);
	}

}
