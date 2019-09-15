package zrc.service.impl;
import java.util.List;

import zrc.dao.FlowerDao;
import zrc.dao.impl.FlowerDaoImpl;
import zrc.pojo.Flower;
import zrc.service.*;
public class FlowerServiceImpl implements FlowerService{
	private FlowerDao flowerDao = new FlowerDaoImpl(); 
	@Override
	public List<Flower> show() {
		// TODO Auto-generated method stub
		return flowerDao.selAll();
	}
	@Override
	public int add(Flower flower) {
		// TODO Auto-generated method stub
		return flowerDao.insFlower(flower);
	}

}
