package com.maiquan.aladdin_product.domain;

import java.io.Serializable;
import java.util.Date;

public class ProductAttrValue implements Serializable{

	private static final long serialVersionUID = 6545974705692308175L;

	private Integer ID;

    private Integer attrID;

    private String attrValue;

    private String attrValueImg;

    private Integer uid;

    private Integer sortOrder;

    private Date createTime;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getAttrID() {
        return attrID;
    }

    public void setAttrID(Integer attrID) {
        this.attrID = attrID;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue == null ? null : attrValue.trim();
    }

    public String getAttrValueImg() {
        return attrValueImg;
    }

    public void setAttrValueImg(String attrValueImg) {
        this.attrValueImg = attrValueImg == null ? null : attrValueImg.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	@Override
	public String toString() {
		return "ProductAttrValue [ID=" + ID + ", attrID=" + attrID
				+ ", attrValue=" + attrValue + ", attrValueImg=" + attrValueImg
				+ ", uid=" + uid + ", sortOrder=" + sortOrder + ", createTime="
				+ createTime + "]";
	}
    
}