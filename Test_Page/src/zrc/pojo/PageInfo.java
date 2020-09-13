package zrc.pojo;

import java.util.List;

public class PageInfo {
	private int pageNumber;
	private int pageSize;
	private long total;
	private List<?> PeopleList;
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		pageSize = pageSize;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getPeopleList() {
		return PeopleList;
	}
	public void setPeopleList(List<?> peopleList) {
		PeopleList = peopleList;
	}
}
