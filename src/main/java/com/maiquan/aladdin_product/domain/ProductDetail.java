package com.maiquan.aladdin_product.domain;

import java.io.Serializable;
import java.util.Date;

public class ProductDetail implements Serializable{

	private static final long serialVersionUID = 5202459648883514546L;

	private Integer ID;

    private Integer productID;

    private Integer uid;

    private Date createTime;

    private String productDesc;

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

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc == null ? null : productDesc.trim();
    }

	@Override
	public String toString() {
		return "ProductDetail [ID=" + ID + ", productID=" + productID
				+ ", uid=" + uid + ", createTime=" + createTime
				+ ", productDesc=" + productDesc + "]";
	}
}