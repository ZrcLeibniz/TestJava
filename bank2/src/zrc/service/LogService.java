package zrc.service;

import java.io.IOException;

import zrc.pojo.PageInfo;

public interface LogService {
	PageInfo showPage(int pageSize,int pageNumber) throws IOException;
}
