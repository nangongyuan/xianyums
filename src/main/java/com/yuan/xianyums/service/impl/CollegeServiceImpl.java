/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: CollegeServiceImpl
 * Author:   Administrator
 * Date:     2018/9/16 0016 15:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyums.service.impl;


import com.yuan.xianyums.common.ServerResponse;
import com.yuan.xianyums.pojo.College;
import com.yuan.xianyums.repository.ICollegeRepository;
import com.yuan.xianyums.service.ICollegeService;
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
public class CollegeServiceImpl implements ICollegeService {

	@Autowired
	private ICollegeRepository collegeRepository;

	@Override
	public Page<College> listAllCollege(Integer pageNum, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNum,pageSize);
		return collegeRepository.findAll(pageable);
	}

	@Override
	public College getCollegeById(Integer collegeId) {
		return collegeRepository.getOne(collegeId);
	}

	@Override
	@Transactional
	public ServerResponse updateCollege(College college) {
		int ret = collegeRepository.updateCollege(college.getName(),college.getProvinceId(),college.getOrdering(),college.getId());
		if (ret>0){
			return ServerResponse.createSuccess();
		}
		return ServerResponse.createError();
	}

	@Override
	public ServerResponse deleteCollege(Integer collegeId) {
		College college = new College();
		college.setId(collegeId);
		collegeRepository.delete(college);
		return ServerResponse.createSuccess();
	}
}