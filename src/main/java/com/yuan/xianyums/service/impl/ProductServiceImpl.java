/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ProductServiceImpl
 * Author:   Administrator
 * Date:     2018/9/16 0016 12:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyums.service.impl;

import com.yuan.xianyums.common.ServerResponse;
import com.yuan.xianyums.pojo.Product;
import com.yuan.xianyums.repository.IProductRepository;
import com.yuan.xianyums.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/16 0016
 * @since 1.0.0
 */
@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository productRepository;

	@Override
	public Page<Product> listAllProduct(Integer pageNum, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNum, pageSize);
		return productRepository.findAll(pageable);
	}

	@Override
	public Product getProductById(Integer productId) {
		return productRepository.getOne(productId);
	}

	@Override
	@Transactional
	public ServerResponse updateProduct(Product product) {
		int ret = productRepository.updateProduct(product.getUserId(),product.getCategoryId(),product.getName(),product.getCollegeId(),product.getQuality(),product.getPrice(),
				product.getStatus(),product.getId());
		if (ret>0){
			return ServerResponse.createSuccess();
		}
		return ServerResponse.createError();
	}

	@Override
	public ServerResponse deleteProduct(Integer productId) {
		Product product = new Product();
		product.setId(productId);
		productRepository.delete(product);
		return ServerResponse.createSuccess();
	}
}