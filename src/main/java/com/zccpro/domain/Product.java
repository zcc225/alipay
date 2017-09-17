package com.zccpro.domain;

import java.util.Date;

public class Product {
    private Long id;

    private Long typeId;

    private Long brandId;

    private String name;

    private Float weight;

    private Boolean isNew;

    private Boolean isHot;

    private Boolean isCommend;

    private Boolean isShow;

    private Boolean isDel;

    private Integer sales;

    private String features;

    private String colors;

    private String sizes;

    private Date createTime;

    private Date checkTime;

    private String createUserId;

    private String checkUserId;

    private String description;

    private String packageList;
    
    private float price;
    /**
     * 附加属性
     * @return
     */
    private Img img;
    
    /**
     * 附加商品回显图片字段
     * @return
     */
    private String webSite;
    
    private String nameExHtml;
    

	public Img getImg() {
		return img;
	}

	public void setImg(Img img) {
		this.img = img;
	}

	public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPackageList() {
        return packageList;
    }

    public void setPackageList(String packageList) {
        this.packageList = packageList == null ? null : packageList.trim();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public Boolean getIsHot() {
        return isHot;
    }

    public void setIsHot(Boolean isHot) {
        this.isHot = isHot;
    }

    public Boolean getIsCommend() {
        return isCommend;
    }

    public void setIsCommend(Boolean isCommend) {
        this.isCommend = isCommend;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features == null ? null : features.trim();
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors == null ? null : colors.trim();
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes == null ? null : sizes.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public String getCheckUserId() {
        return checkUserId;
    }

    public void setCheckUserId(String checkUserId) {
        this.checkUserId = checkUserId == null ? null : checkUserId.trim();
    }

	@Override
	public String toString() {
		return "Product [id=" + id + ", typeId=" + typeId + ", brandId=" + brandId + ", name=" + name + ", weight="
				+ weight + ", isNew=" + isNew + ", isHot=" + isHot + ", isCommend=" + isCommend + ", isShow=" + isShow
				+ ", isDel=" + isDel + ", sales=" + sales + ", features=" + features + ", colors=" + colors + ", sizes="
				+ sizes + ", createTime=" + createTime + ", checkTime=" + checkTime + ", createUserId=" + createUserId
				+ ", checkUserId=" + checkUserId + ", description=" + description + ", packageList=" + packageList
				+ ", img=" + img + "]";
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getNameExHtml() {
		return nameExHtml;
	}

	public void setNameExHtml(String nameExHtml) {
		this.nameExHtml = nameExHtml;
	}


    
    
}