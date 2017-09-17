package com.zccpro.domain.vo;

import com.zccpro.constants.Constants;
import com.zccpro.domain.Brand;

public class BrandQuery extends Brand{

	
    /**** 分页字段****/
    private Integer pageNo = 1;
    
    private Integer totalPage;
    
    private Integer pageSise = Constants.PAGESIZE;
    
    private Integer startRow = 0;
    
    private Integer totoalCount;
    
    


	public Integer getTotoalCount() {
		return totoalCount;
	}

	public void setTotoalCount(Integer totoalCount) {
		this.totoalCount = totoalCount;
	}

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
			this.pageNo = pageNo;
	}

	public Integer getTotalPage() {
		totalPage =this.totoalCount/this.pageSise;
		if(this.totoalCount%this.pageSise==0){
			return totalPage;
		}else{
			return totalPage+1;
		}
	}
	
	public void setTotalPage(Integer totalPage) {
		
			this.totalPage = totalPage;
	}

	public Integer getPageSise() {
		return pageSise;
	}

	public void setPageSise(Integer pageSise) {
		this.pageSise = pageSise;
	}

}
