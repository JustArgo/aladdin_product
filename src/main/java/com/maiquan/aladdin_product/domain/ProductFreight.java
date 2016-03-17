package com.maiquan.aladdin_product.domain;

import java.io.Serializable;
import java.util.Date;

public class ProductFreight implements Serializable{
	
	private static final long serialVersionUID = -3649976615879806930L;

	private Integer ID;

    private Integer productID;

    private Integer freightTplID;

    private String status;

    private Integer uid;

    private Integer supplyID;

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

    public Integer getFreightTplID() {
        return freightTplID;
    }

    public void setFreightTplID(Integer freightTplID) {
        this.freightTplID = freightTplID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getSupplyID() {
        return supplyID;
    }

    public void setSupplyID(Integer supplyID) {
        this.supplyID = supplyID;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	@Override
	public String toString() {
		return "ProductFreight [ID=" + ID + ", productID=" + productID
				+ ", freightTplID=" + freightTplID + ", status=" + status
				+ ", uid=" + uid + ", supplyID=" + supplyID + ", createTime="
				+ createTime + "]";
	}
    
    
}