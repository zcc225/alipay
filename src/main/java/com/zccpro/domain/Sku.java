package com.zccpro.domain;

import java.util.Date;

public class Sku {
    private Long id;

    private Long productId;

    private Long colorId;
    
    private String colorname;

    private String size;

    private Float deliveFee;

    private Float price;

    private Integer stock;

    private Integer upperLimit;

    private String location;

    private String skuImg;

    private Integer skuSort;

    private String skuName;

    private Float marketPrice;

    private Date createTime;

    private Date updateTime;

    private String createUserId;

    private String updateUserId;

    private Boolean skuStatus;

    private Boolean skuType;

    private Long sales;

    
    public String getColorname() {
		return colorname;
	}

	public void setColorname(String colorname) {
		this.colorname = colorname;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getColorId() {
        return colorId;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public Float getDeliveFee() {
        return deliveFee;
    }

    public void setDeliveFee(Float deliveFee) {
        this.deliveFee = deliveFee;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(Integer upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getSkuImg() {
        return skuImg;
    }

    public void setSkuImg(String skuImg) {
        this.skuImg = skuImg == null ? null : skuImg.trim();
    }

    public Integer getSkuSort() {
        return skuSort;
    }

    public void setSkuSort(Integer skuSort) {
        this.skuSort = skuSort;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName == null ? null : skuName.trim();
    }

    public Float getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Float marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId == null ? null : updateUserId.trim();
    }

    public Boolean getSkuStatus() {
        return skuStatus;
    }

    public void setSkuStatus(Boolean skuStatus) {
        this.skuStatus = skuStatus;
    }

    public Boolean getSkuType() {
        return skuType;
    }

    public void setSkuType(Boolean skuType) {
        this.skuType = skuType;
    }

    public Long getSales() {
        return sales;
    }

    public void setSales(Long sales) {
        this.sales = sales;
    }

	@Override
	public String toString() {
		return "Sku [id=" + id + ", productId=" + productId + ", colorId=" + colorId + ", size=" + size + ", deliveFee="
				+ deliveFee + ", price=" + price + ", stock=" + stock + ", upperLimit=" + upperLimit + ", location="
				+ location + ", skuImg=" + skuImg + ", skuSort=" + skuSort + ", skuName=" + skuName + ", marketPrice="
				+ marketPrice + ", createTime=" + createTime + ", updateTime=" + updateTime + ", createUserId="
				+ createUserId + ", updateUserId=" + updateUserId + ", skuStatus=" + skuStatus + ", skuType=" + skuType
				+ ", sales=" + sales + "]";
	}
    
    
}