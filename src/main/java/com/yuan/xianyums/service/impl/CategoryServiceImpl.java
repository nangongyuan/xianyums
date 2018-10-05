/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: CategoryServiceImpl
 * Author:   Administrator
 * Date:     2018/9/16 0016 12:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyums.service.impl;


import com.yuan.xianyums.common.ServerResponse;
import com.yuan.xianyums.pojo.Category;
import com.yuan.xianyums.repository.ICategoryRepository;
import com.yuan.xianyums.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryRepository categoryRepository;

	@Override
	public Page<Category> listCategoryByParentId(Integer parentId, Integer pageNum, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNum,pageSize);
		return categoryRepository.findByParentId(parentId,pageable);
	}

	@Override
	public Category getCategoryById(Integer categoryId) {
		 return categoryRepository.getOne(categoryId);
	}

	@Override
	public List<Category> listAllCategory() {
		return categoryRepository.findAll();
	}

	@Override
	@Transactional
	public ServerResponse updateCategory(Category category) {
		if (categoryRepository.updateCategory(category.getName(),category.getStatus(),category.getOrdering(),category.getParentId(),category.getId())>0){
			return ServerResponse.createSuccess();
		}else{
			return ServerResponse.createError();
		}
	}

	@Override
	public ServerResponse deleteCategory(Integer categoryId) {
		Category category = new Category();
		category.setId(categoryId);
		categoryRepository.delete(category);
		return ServerResponse.createSuccess();
	}

	@Override
	public ServerResponse saveCategory(Category category) {
		if (categoryRepository.save(category)!=null){
			return ServerResponse.createSuccess();
		}
		return ServerResponse.createError();
	}
}