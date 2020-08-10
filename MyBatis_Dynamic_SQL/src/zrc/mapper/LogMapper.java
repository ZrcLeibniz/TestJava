package zrc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import zrc.pojo.Log;

public interface LogMapper {
	List<Log> selByAccInAccOut(@Param("accin") String accin, @Param("accout") String accout);
	int upd(Log log);
	List<Log> selByLog(Log log);
	List<Log> selIn(List<Integer> list);
	int ins(List<Integer> list);
}
