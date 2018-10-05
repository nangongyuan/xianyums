/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ProductController
 * Author:   Administrator
 * Date:     2018/10/5 0005 10:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyums.controller;

import com.yuan.xianyums.common.ServerResponse;
import com.yuan.xianyums.pojo.Category;
import com.yuan.xianyums.pojo.Product;
import com.yuan.xianyums.service.ICategoryService;
import com.yuan.xianyums.service.IProductService;
import com.yuan.xianyums.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/10/5 0005
 * @since 1.0.0
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService productService;

	@RequestMapping("/delete")
	public ServerResponse deleteProduct(Integer productId){
		return productService.deleteProduct(productId);
	}

	@RequestMapping("/update")
	public ServerResponse updateProduct(Product product){
		return productService.updateProduct(product);
	}
}