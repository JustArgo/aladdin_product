package com.maiquan.aladdin_product.domain;

import java.io.Serializable;
import java.util.Date;

public class ProductAttr implements Serializable{

	private static final long serialVersionUID = 6765949560256600767L;

	private Integer ID;

    private Integer productID;

    private String attrName;

    private Integer sortOrder;

    private Integer uid;

    private Date createTime;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName == null ? null : attrName.trim();
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	@Override
	public String toString() {
		return "ProductAttr [ID=" + ID + ", productID=" + productID
				+ ", attrName=" + attrName + ", sortOrder=" + sortOrder
				+ ", uid=" + uid + ", createTime=" + createTime + "]";
	}
    
    
    
}