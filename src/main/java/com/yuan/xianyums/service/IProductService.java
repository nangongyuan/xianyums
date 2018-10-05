/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: IProductService
 * Author:   Administrator
 * Date:     2018/9/16 0016 12:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyums.service;


import com.yuan.xianyums.common.ServerResponse;
import com.yuan.xianyums.pojo.Category;
import com.yuan.xianyums.pojo.Product;
import org.springframework.data.domain.Page;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/16 0016
 * @since 1.0.0
 */
public interface IProductService {
	Page<Product> listAllProduct(Integer pageNum, Integer pageSize);

	Product getProductById(Integer productId);

	ServerResponse updateProduct(Product product);

	ServerResponse deleteProduct(Integer productId);
}
