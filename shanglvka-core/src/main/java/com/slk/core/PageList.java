package com.slk.core;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * 包含“分页”信息的List
 * 
 * <p>要得到总页数请使用 toPaginator().getTotalPages();</p>
 * 
 * @author dingp
 * @since 2012-8-21
 */
public class PageList<E> implements Serializable {

    private static final long serialVersionUID = 1412759446332294208L;
    
    /** 分页大小 */
    private long               	pageSize;
    /** 页数  */
    private long               	page;
    /** 总记录数 */
    private long               	totalItems;
    
    private List<E> 				items;

    public PageList() {}
    
	public PageList(List<E> c) {
		this.items = c;
	}

	public PageList(long page, long pageSize, long totalItems) {
        this.page = page;
        this.pageSize = pageSize;
        this.totalItems = totalItems;
    }
	
	public PageList(List<E> c,long page, long pageSize, long totalItems) {
		this.items = c;
        this.page = page;
        this.pageSize = pageSize;
        this.totalItems = totalItems;
    }

    public PageList(Paginator p) {
        this.page = p.getPage();
        this.pageSize = p.getPageSize();
        this.totalItems = p.getTotalItems();
    }
    
    public PageList(List<E> c,Paginator p) {
    	this.items = c;
        this.page = p.getPage();
        this.pageSize = p.getPageSize();
        this.totalItems = p.getTotalItems();
    }
    
    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

	public long getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(long totalItems) {
		this.totalItems = totalItems;
	}
	
	public List<E> getItems() {
		return items;
	}

	public void setItems(List<E> items) {
		this.items = items;
	}

	/**
	 * 得到分页器，通过Paginator可以得到总页数等值
	 * @return
	 */
	public Paginator getPaginator() {
		return new Paginator(page,pageSize,totalItems);
	}
	
}
