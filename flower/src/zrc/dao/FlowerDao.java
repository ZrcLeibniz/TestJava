package zrc.dao;

import java.util.List;

import zrc.pojo.Flower;

public interface FlowerDao {
	List<Flower> selAll();
	int insFlower(Flower flower);
}
