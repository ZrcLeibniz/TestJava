package zrc.service;

import java.util.List;

import zrc.pojo.Flower;

public interface FlowerService {
	List<Flower> show();
	int add(Flower flower);
}
