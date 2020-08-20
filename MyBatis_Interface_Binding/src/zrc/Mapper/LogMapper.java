package zrc.Mapper;

import java.util.List;

import zrc.pojo.Log;

public interface LogMapper {
	List<Log> selAll();
	List<Log> selByAccInAccOut(String accin, String accout);
}
