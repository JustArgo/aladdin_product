package com.maiquan.aladdin.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.maiquan.aladdin.domain.Comment;
import com.maiquan.aladdin.domain.Product;
import com.maiquan.aladdin.domain.ProductSku;
import com.maiquan.aladdin.service.ICommentService;
import com.maiquan.aladdin.service.IProductService;
import com.maiquan.aladdin.service.IProductSkuService;
import com.maiquan.aladdin.service.IProductVoService;
import com.maiquan.aladdin.vo.ProductVo;

public class ProductVoServiceImpl implements IProductVoService{

	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private IProductSkuService productSkuService;
	
	@Autowired
	private ICommentService commentService;
	
	@Override
	public ProductVo getProductVo(Integer ID) {

		ProductVo productVo = new ProductVo();
		Product p = productService.queryProduct(ID);
		if(p!=null){
			List<Comment> comments = commentService.getCommentNoDeletedList(ID, 0, 1, UUID.randomUUID().toString());
			
			productVo.setProduct(p);
			if(comments.size()>0){
				productVo.setComment(comments.get(0));
			}
			List<ProductSku> skus = productSkuService.getSkuByProductID(ID);
			productVo.setSkus(skus);
			return productVo;
		}
		return null;
	}

}
