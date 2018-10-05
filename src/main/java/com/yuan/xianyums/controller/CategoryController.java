/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: CategoryController
 * Author:   Administrator
 * Date:     2018/9/29 0029 10:52
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyums.controller;

import com.yuan.xianyums.common.ServerResponse;
import com.yuan.xianyums.pojo.Category;
import com.yuan.xianyums.pojo.User;
import com.yuan.xianyums.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/29 0029
 * @since 1.0.0
 */
@RequestMapping("/category")
@RestController
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	@RequestMapping("/delete")
	public ServerResponse deleteProduct(Integer categoryId){
		return categoryService.deleteCategory(categoryId);
	}

	@RequestMapping("/update")
	public ServerResponse updateProduct(Category category){
		return categoryService.updateCategory(category);
	}

	@RequestMapping("/save")
	public ServerResponse saveProduct(Category category){
		return categoryService.saveCategory(category);
	}
}