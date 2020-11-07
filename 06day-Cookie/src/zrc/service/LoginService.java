package zrc.service;

import zrc.pojo.User;

public interface LoginService {
	User checkLoginService(String uname, String pwd);
	User CheckLoginservice(String uid);
}
