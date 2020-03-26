package com.itshidu.blog.vo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;

/**
 * 分页支持类,代表一页数据，页码从1开始
 * 
 * @author 夏增明
 * @version 1.0 create date 2013-10-5
 * @version 1.1 create data 2015-08-27
 * @version 2.0 create data 2016-03-16
 * @version 3.0 create data 2018-10-13
 */
@SuppressWarnings("serial")
public class Paging<T> implements Serializable {

	private int prev;		//上一页
	private int curr;		//当前页
	private int next;		//下一页
	private int size;	//每页记录数
	private int totalPage;	//总页数
	private long totalCount;//总记录数
	private List<T> list;	//数据集合
	private boolean first;//是否第一页
	private boolean last;	//是否最后页
	
	/**
	 * @param curr 当前页
	 * @param count 总数据条数
	 * @param list 数据集合
	 * @param pageSize 每页显示数据数
	 */
	public Paging(List<T> list, int curr, long count, int pageSize) {
		this.list = list;
		this.curr = curr;
		this.totalCount = count;
		this.size = pageSize;
		this.totalPage = (int) ((count + pageSize - 1) / pageSize);
		this.prev = curr>1? curr-1:1;
		this.next = curr>=totalPage? totalPage: curr + 1;
		this.first = curr==1;
		this.last = curr==totalPage;
	}
	
	/**
	 * 上一页的页码
	 * @return
	 */
	public int getPrev() {
		return prev;
	}
	/**
	 * 当前页的页码
	 * @return
	 */
	public int getCurr() {
		return curr;
	}
	/**
	 * 下一页的页码
	 * @return
	 */
	public int getNext() {
		return next;
	}
	/**
	 * 当前是否第一页
	 * @return
	 */
	public boolean isFirst() {
		return first;
	}
	/**
	 * 当前是否最后一页
	 * @return
	 */
	public boolean isLast() {
		return last;
	}
	/**
	 * 总页数
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}
	/**
	 * 数据集合
	 * @return the list
	 */
	public List<T> getList() {
		return list;
	}
	/**
	 * 总记录数
	 * @return
	 */
	public long getTotalCount() {
		return totalCount;
	}
	/**
	 * 每页记录数
	 * @return
	 */
	public int getPageSize() {
		return size;
	}
	/**
	 * 分页中的第一个对象
	 * @return
	 */
	public T getFirstElement() {
		return (list!=null&&list.size()>0)? list.get(0):null;
	}
	
	public boolean hasNext() {
		return curr>=totalPage;
	}
	public boolean hasPrevious() {
		return curr>1;
	}
	
	
}
