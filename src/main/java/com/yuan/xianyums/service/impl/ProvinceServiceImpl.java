/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ProvinceServiceImpl
 * Author:   Administrator
 * Date:     2018/9/16 0016 14:53
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyums.service.impl;


import com.yuan.xianyums.pojo.Province;
import com.yuan.xianyums.repository.IProvinceRepository;
import com.yuan.xianyums.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/16 0016
 * @since 1.0.0
 */
@Service
public class ProvinceServiceImpl implements IProvinceService {

	@Autowired
	private IProvinceRepository provinceRepository;

	@Override
	public List<Province> listAllProvince() {
		return provinceRepository.findAll();
	}
}