package org.zihao.SMRShop.util;

public class Paging 
{
	private int thisPage;	//当前页数
	private int maxPage;	//最大页数
	private int pageSize;	//每页显示多少个元素
	private int maxItem;	//元素总数
	
	public Paging(String _thisPage,int _pageSize,int _maxItem)
	{
		pageSize = _pageSize;
		maxItem = _maxItem;
		
		if(_maxItem % _pageSize == 0)
		{
			maxPage = _maxItem / _pageSize;
		}
		else
		{
			maxPage = _maxItem / _pageSize + 1;
		}
		
		if(_thisPage!=null)
		{
			int pageNum = Integer.valueOf(_thisPage);
			
			if(pageNum>0 && pageNum<=maxPage)
			{
				thisPage = pageNum;
			}
			else if(pageNum<=0)
			{
				thisPage = 1;
			}
			else if(pageNum>maxPage)
			{
				thisPage = maxPage;
			}
			else
			{
				thisPage = 1;
			}
		}
		else
		{
			thisPage = 1;
		}
	}
	
	public int startNum()
	{
		return (thisPage-1) * pageSize;
	}
	
	public int endNum()
	{
		int endItem = thisPage * pageSize - 1;
		
		if(endItem>=maxItem)
		{
			return maxItem - 1;
		}
		else
		{
			return endItem;
		}
	}
	
	public int getThisPage() {
		return thisPage;
	}
	public void setThisPage(int thisPage) {
		this.thisPage = thisPage;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getMaxItem() {
		return maxItem;
	}
	public void setMaxItem(int maxItem) {
		this.maxItem = maxItem;
	}
}
