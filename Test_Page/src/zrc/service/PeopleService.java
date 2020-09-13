package zrc.service;

import java.io.IOException;

import zrc.pojo.PageInfo;

public interface PeopleService {
	PageInfo show(int pageNumbr, int pageSize) throws IOException; 
}
