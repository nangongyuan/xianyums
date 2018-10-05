/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ICategoryService
 * Author:   Administrator
 * Date:     2018/9/16 0016 12:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyums.service;



import com.yuan.xianyums.common.ServerResponse;
import com.yuan.xianyums.pojo.Category;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/16 0016
 * @since 1.0.0
 */
public interface ICategoryService {
	Page<Category> listCategoryByParentId(Integer parentId, Integer pageNum, Integer pageSize);

	Category getCategoryById(Integer categoryId);

	List<Category> listAllCategory();

	ServerResponse updateCategory(Category category);

	ServerResponse deleteCategory(Integer categoryId);

	ServerResponse saveCategory(Category category);
}
