package com.maiquan.aladdin_product.vo;

import java.io.Serializable;
import java.util.List;

import com.maiquan.aladdin_comment.domain.Comment;
import com.maiquan.aladdin_comment.vo.CommentVo;
import com.maiquan.aladdin_product.domain.Product;
import com.maiquan.aladdin_product.domain.ProductSku;

public class ProductVo implements Serializable{

	private static final long serialVersionUID = 2796643884761933555L;
	
	private Product product;
	private List<ProductSku> skus;
	private CommentVo commentVo;
	private Integer commentCount;
	private Integer goodCommentRate;
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
	public CommentVo getCommentVo() {
		return commentVo;
	}
	public void setCommentVo(CommentVo commentVo) {
		this.commentVo = commentVo;
	}
	public Integer getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	public Integer getGoodCommentRate() {
		return goodCommentRate;
	}
	public void setGoodCommentRate(Integer goodCommentRate) {
		this.goodCommentRate = goodCommentRate;
	}
	@Override
	public String toString() {
		return "ProductVo [product=" + product + ", skus=" + skus
				+ ", commentVo=" + commentVo + "]";
	}
	
	
	
	
}
