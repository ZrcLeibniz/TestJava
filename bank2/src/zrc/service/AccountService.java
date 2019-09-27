package zrc.service;

import java.io.IOException;

import zrc.pojo.Account;

public interface AccountService {
	int ACCOUNT_PASSWORD_NOT_MATCH = 1;
	int ACCOUNT_BALANCE_NOT_ENOUGH = 2;
	int ACCOUNT_NAME_NOT_MATCH = 3;
	int ERROR = 4;
	int SUCCESS = 5;
	int transfer(Account accIn, Account accOut) throws IOException;
}
