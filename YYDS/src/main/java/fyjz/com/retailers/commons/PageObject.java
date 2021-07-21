package fyjz.com.retailers.commons;

import java.io.Serializable;

/*
 * ��װ��ҳ��Ϣ
 */
public class PageObject implements Serializable{
	//��ǰҳ��(Ĭ�ϵ�ǰҳ��Ϊ��һҳ)
	private Integer pageCurrent=1;
	
	//��¼��
	private Integer rowCount;
	
	//ÿҳ��ʾ�ļ�¼��
	private Integer pageSize=8;
	
	//��ҳ��
	private Integer pageCount;
	
	//��ȡ��ҳ����ʼҳ
	private Integer startIndex;
	
	/*//��ȡ��ʼҳ�ĵ�һ�����ݵ��±�
	public Integer getStartIndex(){
		int start=(pageCount-1)*pageSize;
		return start;
	}*/
	
	//��ȡ��ҳ��
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

	//��ȡ��ʼҳ�ĵ�һ�����ݵ��±�
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
