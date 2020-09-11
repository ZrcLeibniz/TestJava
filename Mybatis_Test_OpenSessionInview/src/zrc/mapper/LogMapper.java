package zrc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import zrc.pojo.Log;

public interface LogMapper {
	List<Log> selAll();
	List<Log> selLog(@Param("accIn")String accIn, @Param("accOut")String accOut);
}
