package zrc.service;

import java.io.IOException;
import java.util.List;

import zrc.pojo.Log;

public interface LogService {
	List<Log> show() throws IOException;
	List<Log> showP(String accIn, String accOut) throws IOException;
}
