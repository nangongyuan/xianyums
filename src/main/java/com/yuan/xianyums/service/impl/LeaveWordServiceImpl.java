/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: LeaveWordServiceImpl
 * Author:   Administrator
 * Date:     2018/9/22 0022 10:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyums.service.impl;

import com.yuan.xianyums.pojo.LeaveWord;
import com.yuan.xianyums.repository.ILeaveWordRepository;
import com.yuan.xianyums.repository.IProductRepository;
import com.yuan.xianyums.service.ILeaveWordService;
import com.yuan.xianyums.vo.LeaveWordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/22 0022
 * @since 1.0.0
 */
@Service
public class LeaveWordServiceImpl implements ILeaveWordService {

	@Autowired
	private ILeaveWordRepository leaveWordRepository;

	@Autowired
	private IProductRepository productRepository;

	@Override
	public Page<LeaveWordVo> listAllLeaveWord(Integer pageNum, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNum,pageSize);
		Page<LeaveWord> page = leaveWordRepository.findAll(pageable);
		List<LeaveWordVo> leaveWordVoList = new ArrayList<>();
		for (LeaveWord item: page.getContent()
			 ) {
			LeaveWordVo leaveWordVo = new LeaveWordVo();
			leaveWordVo.setId(item.getId());
			leaveWordVo.setProductName(productRepository.getOne(item.getProductId()).getName());
			leaveWordVo.setContent(item.getContent());
			leaveWordVoList.add(leaveWordVo);
		}
		return new PageImpl(leaveWordVoList,pageable,leaveWordVoList.size());
	}
}