package com.maiquan.aladdin.domain;

import java.io.Serializable;
import java.util.Date;

public class ProductSku implements Serializable{

	private static final long serialVersionUID = -3558768887358933655L;

	private Integer ID;

    private Integer uid;

    private Integer productID;

    private Long skuPrice;

    private Long applyPrice;

    private String skuImg;

    private Integer skuStock;

    private Date createTime;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Long getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(Long skuPrice) {
        this.skuPrice = skuPrice;
    }

    public Long getApplyPrice() {
        return applyPrice;
    }

    public void setApplyPrice(Long applyPrice) {
        this.applyPrice = applyPrice;
    }

    public String getSkuImg() {
        return skuImg;
    }

    public void setSkuImg(String skuImg) {
        this.skuImg = skuImg == null ? null : skuImg.trim();
    }

    public Integer getSkuStock() {
        return skuStock;
    }

    public void setSkuStock(Integer skuStock) {
        this.skuStock = skuStock;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
	@Override
	public String toString() {
		return "ProductSku [ID=" + ID + ", uid=" + uid + ", productID="
				+ productID + ", skuPrice=" + skuPrice + ", applyPrice="
				+ applyPrice + ", skuImg=" + skuImg + ", skuStock=" + skuStock
				+ ", createTime=" + createTime + "]";
	}
    
}