package com.maiquan.aladdin.vo;

import java.util.List;

import com.maiquan.aladdin.domain.Comment;
import com.maiquan.aladdin.domain.Product;
import com.maiquan.aladdin.domain.ProductSku;

public class ProductVo {

	private Product product;
	private List<ProductSku> skus;
	private Comment comment;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<ProductSku> getSkus() {
		return skus;
	}
	public void setSkus(List<ProductSku> skus) {
		this.skus = skus;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "ProductVo [product=" + product + ", skus=" + skus
				+ ", comment=" + comment + "]";
	}
	
	
	
	
}
