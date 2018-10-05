/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: CollegeController
 * Author:   Administrator
 * Date:     2018/10/5 0005 12:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyums.controller;

import com.yuan.xianyums.common.ServerResponse;
import com.yuan.xianyums.pojo.Category;
import com.yuan.xianyums.pojo.College;
import com.yuan.xianyums.service.ICategoryService;
import com.yuan.xianyums.service.ICollegeService;
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
@RequestMapping("/college")
@RestController
public class CollegeController {

	@Autowired
	private ICollegeService collegeService;

	@RequestMapping("/delete")
	public ServerResponse deleteProduct(Integer collegeId){
		return collegeService.deleteCollege(collegeId);
	}

	@RequestMapping("/update")
	public ServerResponse updateProduct(College college){
		return collegeService.updateCollege(college);
	}

}