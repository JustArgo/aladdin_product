package com.maiquan.aladdin_product.domain;

import java.io.Serializable;
import java.util.Date;

public class FreightTplExcept implements Serializable{

	private static final long serialVersionUID = 1489267188968242479L;

	private Integer ID;

    private Integer freightTplID;

    private Integer countryID;

    private Integer provinceID;

    private Integer cityID;

    private Integer districtID;

    private String address;

    private Long firstFreight;

    private Long secFreight;

    private String status;

    private Long fullSum;

    private String fullStatus;

    private Integer uid;

    private Integer supplyID;

    private Integer sortOrder;

    private Date createTime;

    private Date updateTime;

    private Date delTime;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getFreightTplID() {
        return freightTplID;
    }

    public void setFreightTplID(Integer freightTplID) {
        this.freightTplID = freightTplID;
    }

    public Integer getCountryID() {
        return countryID;
    }

    public void setCountryID(Integer countryID) {
        this.countryID = countryID;
    }

    public Integer getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(Integer provinceID) {
        this.provinceID = provinceID;
    }

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public Integer getDistrictID() {
        return districtID;
    }

    public void setDistrictID(Integer districtID) {
        this.districtID = districtID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Long getFirstFreight() {
        return firstFreight;
    }

    public void setFirstFreight(Long firstFreight) {
        this.firstFreight = firstFreight;
    }

    public Long getSecFreight() {
        return secFreight;
    }

    public void setSecFreight(Long secFreight) {
        this.secFreight = secFreight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Long getFullSum() {
        return fullSum;
    }

    public void setFullSum(Long fullSum) {
        this.fullSum = fullSum;
    }

    public String getFullStatus() {
        return fullStatus;
    }

    public void setFullStatus(String fullStatus) {
        this.fullStatus = fullStatus == null ? null : fullStatus.trim();
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getDelTime() {
        return delTime;
    }

    public void setDelTime(Date delTime) {
        this.delTime = delTime;
    }

	@Override
	public String toString() {
		return "FreightTplExcept [ID=" + ID + ", freightTplID=" + freightTplID
				+ ", countryID=" + countryID + ", provinceID=" + provinceID
				+ ", cityID=" + cityID + ", districtID=" + districtID
				+ ", address=" + address + ", firstFreight=" + firstFreight
				+ ", secFreight=" + secFreight + ", status=" + status
				+ ", fullSum=" + fullSum + ", fullStatus=" + fullStatus
				+ ", uid=" + uid + ", supplyID=" + supplyID + ", sortOrder="
				+ sortOrder + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", delTime=" + delTime + "]";
	}

    
    
}