package zrc.service;

import java.io.IOException;

import zrc.pojo.PageInfo;

public interface PeopleService {
	PageInfo showPage(int pageSize, int pageNumber) throws IOException;
}
