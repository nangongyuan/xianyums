/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ICategoryRepository
 * Author:   Administrator
 * Date:     2018/9/16 0016 12:55
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyums.repository;



import com.yuan.xianyums.pojo.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/16 0016
 * @since 1.0.0
 */
public interface ICategoryRepository extends JpaRepository<Category,Integer> {
	Page<Category> findByParentId(Integer parentId, Pageable pageable);

	@Modifying
	@Query("update Category category set category.name=:name ,category.status=:status,category.ordering=:ordering,category.parentId=:parentId where category.id=:id")
	int updateCategory(@Param(value = "name")String name, @Param(value = "status")Integer status,
				   @Param(value = "ordering")Integer ordering, @Param(value = "parentId")Integer parentId, @Param(value = "id")Integer id);
}
