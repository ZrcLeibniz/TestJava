package zrc.service;

import zrc.pojo.PageInfo;

public interface StudentService {
	PageInfo showPage(String sname, String tname, String pageSize, String pageNumber);
}
