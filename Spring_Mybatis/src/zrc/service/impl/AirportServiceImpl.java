package zrc.service.impl;

import java.util.List;

import zrc.mapper.AirportMapper;
import zrc.pojo.Airport;
import zrc.service.AirportService;

public class AirportServiceImpl implements AirportService{
	private AirportMapper airportMapper;
	
	public AirportMapper getAirportMapper() {
		return airportMapper;
	}
	
	public void setAirportMapper(AirportMapper airportMapper) {
		this.airportMapper = airportMapper;
	}

	@Override
	public List<Airport> show() {
		// TODO Auto-generated method stub
		return airportMapper.selAll();
	}
	
}
