package zrc.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import zrc.pojo.Account;
import zrc.pojo.Log;
import zrc.service.AccountService;

public class AccountServiceImpl implements AccountService {

	@Override
	public int transfer(Account accIn, Account accOut) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		Account accOutSelect = session.selectOne("zrc.mapper.AccountMapper.selByAccnoPwd", accOut);
		if (accOutSelect != null) {
			if (accOutSelect.getBalance() >= accOut.getBalance()) {
				Account accInSelect = session.selectOne("zrc.mapper.AccountMapper.selByAccnoName", accIn);
				if (accInSelect != null) {
					accIn.setBalance(accOut.getBalance());
					accOut.setBalance(-accOut.getBalance());
					int index = session.update("zrc.mapper.AccountMapper.upBalanceByAccno", accOut);
					index += session.update("zrc.mapper.AccountMapper.upBalanceByAccno", accIn);
					if (index == 2) {
						Log log = new Log();
						log.setAccout(accOut.getAccno());
						log.setAccin(accIn.getAccno());
						log.setMoney(accIn.getBalance());
						session.insert("zrc.mapper.LogMapper.insLog", log);
						Logger logger = Logger.getLogger(AccountServiceImpl.class);
						logger.info(log.getAccout()+"给"+log.getAccin()+"在"+new Date().toLocaleString()+"转了"+log.getAccin());
						session.commit();
						session.close();
						return SUCCESS;
					} else {
						session.rollback();
						session.close();
						return ERROR;
					}
				} else {
					return ACCOUNT_NAME_NOT_MATCH;
				}
			} else {
				return ACCOUNT_BALANCE_NOT_ENOUGH;
			}
		} else {
			return ACCOUNT_PASSWORD_NOT_MATCH;
		}
	}
}
