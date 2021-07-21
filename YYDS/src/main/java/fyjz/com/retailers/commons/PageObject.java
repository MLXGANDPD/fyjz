package fyjz.com.retailers.commons;

import java.io.Serializable;

/*
 * 封装分页信息
 */
public class PageObject implements Serializable{
	//当前页数(默认当前页数为第一页)
	private Integer pageCurrent=1;
	
	//记录数
	private Integer rowCount;
	
	//每页显示的记录数
	private Integer pageSize=8;
	
	//总页数
	private Integer pageCount;
	
	//获取分页的起始页
	private Integer startIndex;
	
	/*//获取起始页的第一条数据的下标
	public Integer getStartIndex(){
		int start=(pageCount-1)*pageSize;
		return start;
	}*/
	
	//获取总页数
	public Integer getPageCount(){
		int pages=rowCount%pageSize==0?rowCount/pageSize:rowCount/pageSize+1;
		return pages;
	}

	public Integer getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(Integer pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public Integer getRowCount() {
		return rowCount;
	}

	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	/*public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}*/

	//获取起始页的第一条数据的下标
	public Integer getStartIndex() {
		int start=(pageCurrent-1)*pageSize;
		return start;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public PageObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageObject(Integer pageCurrent, Integer rowCount, Integer pageSize, Integer pageCount, Integer startIndex) {
		super();
		this.pageCurrent = pageCurrent;
		this.rowCount = rowCount;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.startIndex = startIndex;
	}

	@Override
	public String toString() {
		return "PageObject [pageCurrent=" + pageCurrent + ", rowCount=" + rowCount + ", pageSize=" + pageSize
				+ ", pageCount=" + pageCount + ", startIndex=" + startIndex + "]";
	}
	
	
	
}
