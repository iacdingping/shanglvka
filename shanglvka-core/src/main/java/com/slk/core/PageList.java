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
    
    private String funcName = "page"; 
    
    private int length = 8;// 显示页面长度
	private int slider = 1;// 前后显示页面长度
	private int first;
	private int last;

    public PageList() {}
    
	public PageList(List<E> c) {
		this.items = c;
	}

	public PageList(long page, long pageSize, long totalItems) {
        this.page = page;
        this.pageSize = pageSize;
        this.totalItems = totalItems;
    }
	
	public void init() {
		//1
		this.first = 1;
		
		this.last = (int)(totalItems / (this.pageSize < 1 ? 20 : this.pageSize) + first - 1);
		
		if (this.totalItems % this.pageSize != 0 || this.last == 0) {
			this.last++;
		}

		if (this.last < this.first) {
			this.last = this.first;
		}
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
	
	/**
	 * 默认输出当前分页标签 
	 * <div class="page">${page}</div>
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		init();
		Paginator p = getPaginator();
		int pageNo = (int)p.getPage();
		int prev = (int)p.getPrePage();
		int next = (int)p.getNextPage();
		long count = p.getTotalItems();
		
		if (pageNo == first) {// 如果是首页
			sb.append("<li class=\"disabled\"><a href=\"javascript:\">&#171; 上一页</a></li>\n");
		} else {
			sb.append("<li><a href=\"javascript:\" onclick=\""+funcName+"("+prev+","+pageSize+");\">&#171; 上一页</a></li>\n");
		}

		int begin = pageNo - (length / 2);

		if (begin < first) {
			begin = first;
		}

		int end = begin + length - 1;

		if (end >= last) {
			end = last;
			begin = end - length + 1;
			if (begin < first) {
				begin = first;
			}
		}

		if (begin > first) {
			int i = 0;
			for (i = first; i < first + slider && i < begin; i++) {
				sb.append("<li><a href=\"javascript:\" onclick=\""+funcName+"("+i+","+pageSize+");\">"
						+ (i + 1 - first) + "</a></li>\n");
			}
			if (i < begin) {
				sb.append("<li class=\"disabled\"><a href=\"javascript:\">...</a></li>\n");
			}
		}

		for (int i = begin; i <= end; i++) {
			if (i == pageNo) {
				sb.append("<li class=\"active\"><a href=\"javascript:\">" + (i + 1 - first)
						+ "</a></li>\n");
			} else {
				sb.append("<li><a href=\"javascript:\" onclick=\""+funcName+"("+i+","+pageSize+");\">"
						+ (i + 1 - first) + "</a></li>\n");
			}
		}

		if (last - end > slider) {
			sb.append("<li class=\"disabled\"><a href=\"javascript:\">...</a></li>\n");
			end = last - slider;
		}

		for (int i = end + 1; i <= last; i++) {
			sb.append("<li><a href=\"javascript:\" onclick=\""+funcName+"("+i+","+pageSize+");\">"
					+ (i + 1 - first) + "</a></li>\n");
		}

		if (pageNo == last) {
			sb.append("<li class=\"disabled\"><a href=\"javascript:\">下一页 &#187;</a></li>\n");
		} else {
			sb.append("<li><a href=\"javascript:\" onclick=\""+funcName+"("+next+","+pageSize+");\">"
					+ "下一页 &#187;</a></li>\n");
		}

		sb.append("<li class=\"disabled controls\"><a href=\"javascript:\">当前 ");
		sb.append("<input type=\"text\" value=\""+pageNo+"\" onkeypress=\"var e=window.event||this;var c=e.keyCode||e.which;if(c==13)");
		sb.append(funcName+"(this.value,"+pageSize+");\" onclick=\"this.select();\"/> / ");
		sb.append("<input type=\"text\" value=\""+pageSize+"\" onkeypress=\"var e=window.event||this;var c=e.keyCode||e.which;if(c==13)");
		sb.append(funcName+"("+pageNo+",this.value);\" onclick=\"this.select();\"/> 条，");
		sb.append("共 " + count + " 条</a><li>\n");

		sb.insert(0,"<ul>\n").append("</ul>\n");
		
		sb.append("<div style=\"clear:both;\"></div>");

//		sb.insert(0,"<div class=\"page\">\n").append("</div>\n");
		
		return sb.toString();
	}
}
