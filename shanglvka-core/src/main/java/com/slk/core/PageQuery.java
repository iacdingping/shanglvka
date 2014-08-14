package com.slk.core;

/**
 * 分页查询对象
 * @author dingp
 * @since 2012-8-21
 */
public class PageQuery {

	public static final long DEFAULT_PAGE_SIZE = 10;
	/** 页数  */
	private long page = 1;
	/** 分页大小 */
	private long pageSize = DEFAULT_PAGE_SIZE;
	
	public String sortColumns;

	public PageQuery() {
	}

	public PageQuery(long pageSize) {
		this.pageSize = pageSize;
	}

	public PageQuery(PageQuery query) {
		this.page = query.page;
		this.pageSize = query.pageSize;
	}

	public PageQuery(long page, long pageSize) {
		this.page = page;
		this.pageSize = pageSize;
	}

	public long getPage() {
		return page;
	}

	public void setPage(long page) {
		this.page = page;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public String getSortColumns() {
		return sortColumns;
	}

	public void setSortColumns(String sortColumns) {
		this.sortColumns = sortColumns;
	}

	/**
	 * 开始行，可以用于oracle分页使用 (1-based)。
	 **/
	public long getStartRow() {
		if(getPageSize() <= 0) return 0;
		return page > 0 ? (page - 1) * getPageSize() + 1 : 0;
	}
	
	/**
     * 结束行，可以用于oracle分页使用 (1-based)。
     **/
	public long getEndRow() {
	    return page > 0 ? pageSize * page : 0; 
	}
	
    /**
     * offset，计数从0开始，可以用于mysql分页使用(0-based)
     **/	
	public long getOffset() {
		return page > 0 ? (page - 1) * getPageSize() : 0;
	}
	
	/**
     * limit，可以用于mysql分页使用(0-based)
     **/
    public long getLimit() {
        if (page > 0) {
            return pageSize * page - (pageSize * (page - 1));
        } else {
            return 0;
        }
    }
	
	public String toString() {
		return "page:" + page + ",pageSize:" + pageSize + ",sortColumns:" + sortColumns;
	}

}
