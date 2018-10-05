/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: OrderServiceImpl
 * Author:   Administrator
 * Date:     2018/9/24 0024 13:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyums.service.impl;


import com.yuan.xianyums.pojo.Order;
import com.yuan.xianyums.repository.IOrderRepository;
import com.yuan.xianyums.repository.IProductRepository;
import com.yuan.xianyums.repository.IUserRepository;
import com.yuan.xianyums.service.IOrderService;
import com.yuan.xianyums.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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
 * @create 2018/9/24 0024
 * @since 1.0.0
 */
@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private IOrderRepository orderRepository;

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IProductRepository productRepository;

	@Override
	public Page<OrderVo> listAllOrder(Integer pageNum, Integer pageSize) {
		Page<Order> page = orderRepository.findAll(PageRequest.of(pageNum,pageSize));
		List<Order> orderList = page.getContent();
		List<OrderVo> orderVoList = new ArrayList<>();
		for (Order item: orderList
			 ) {
			OrderVo orderVo = new OrderVo();
			orderVo.setId(item.getId());
			orderVo.setBuyer(userRepository.getOne(item.getBuyer()).getUsername());
			orderVo.setSeller(userRepository.getOne(item.getSeller()).getUsername());
			orderVo.setProductName(productRepository.getOne(item.getProductId()).getName());
			orderVoList.add(orderVo);
		}
		return new PageImpl(orderVoList,PageRequest.of(pageNum,pageSize),orderVoList.size());
	}
}