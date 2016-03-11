package com.maiquan.aladdin_product.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.maiquan.aladdin_comment.domain.Comment;
import com.maiquan.aladdin_comment.service.ICommentService;
import com.maiquan.aladdin_comment.service.ICommentVoService;
import com.maiquan.aladdin_comment.vo.CommentVo;
import com.maiquan.aladdin_product.domain.Product;
import com.maiquan.aladdin_product.domain.ProductSku;
import com.maiquan.aladdin_product.service.IProductService;
import com.maiquan.aladdin_product.service.IProductSkuService;
import com.maiquan.aladdin_product.service.IProductVoService;
import com.maiquan.aladdin_product.util.LogUtil;
import com.maiquan.aladdin_product.vo.ProductVo;

public class ProductVoServiceImpl implements IProductVoService{

	@Autowired
	private IProductService productService;
	
	@Autowired
	private IProductSkuService productSkuService;
	
	@Autowired
	private ICommentService commentService;
	
	@Autowired
	private ICommentVoService commentVoService;
	
	@Override
	public ProductVo getProductVo(Integer productID, String requestID) {

		LogUtil.logInput("商品Vo微服务", "getProductVo", requestID, productID);
		
		ProductVo productVo = null;
		Product p = productService.queryProduct(productID, UUID.randomUUID().toString());
		if(p!=null){
			
			productVo = new ProductVo();
			List<Comment> comments = commentService.getCommentNoDeletedList(productID, 0, 1, UUID.randomUUID().toString());
			
			productVo.setProduct(p);
			
			int commentCount = commentService.getCountNoDeletedByProductID(productID, UUID.randomUUID().toString());
			productVo.setCommentCount(commentCount);
			
			if(comments.size()>0){
				CommentVo commentVo = commentVoService.getCommentVo(comments.get(0).getID());
				productVo.setCommentVo(commentVo);
			}
			
			List<ProductSku> skus = productSkuService.getSkuByProductID(productID, UUID.randomUUID().toString());
			productVo.setSkus(skus);
			
			//设置好评率
			productVo.setGoodCommentRate(33);
			
		}
		
		LogUtil.logOutput("商品Vo微服务", "getProductVo", requestID, productVo);
		
		return productVo;
	}

}
