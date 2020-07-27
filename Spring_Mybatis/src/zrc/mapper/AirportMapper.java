package zrc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import zrc.pojo.Airport;

public interface AirportMapper {
	@Select("select * from airport")
	List<Airport> selAll();
}
