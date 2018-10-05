/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserServiceImpl
 * Author:   Administrator
 * Date:     2018/9/15 0015 19:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyums.service.impl;

import com.yuan.xianyums.common.ServerResponse;
import com.yuan.xianyums.pojo.User;
import com.yuan.xianyums.repository.IUserRepository;
import com.yuan.xianyums.service.IUserService;
import com.yuan.xianyums.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/15 0015
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepository;

	@Override
	public ServerResponse<User> login(User user) {
		User result = userRepository.findByUsername(user.getUsername());
		if (result == null){
			return ServerResponse.createErrorByMessage("用户名不存在");
		}
		user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
		if (!user.getPassword().equals(result.getPassword())){
			return ServerResponse.createErrorByMessage("密码错误");
		}
		return ServerResponse.createSuccessByData(result);
	}

	@Override
	public Page<User> listAllUser(Integer pageNum, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNum, pageSize);
		return userRepository.findAll(pageable);
	}

	@Override
	public User getUserById(Integer userId) {
		return userRepository.getOne(userId);
	}

	@Override
	@Transactional
	public ServerResponse updateUser(User user) {
		int result = userRepository.updateUser(user.getUsername(),user.getEmail(),user.getPhone(),user.getRole(),user.getId());
		if (result <=0){
			return ServerResponse.createError();
		}
		return ServerResponse.createSuccess();
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = new User();
		user.setId(userId);
		userRepository.delete(user);
	}

	@Override
	@Transactional
	public ServerResponse resetPassword(Integer userId, String password) {
		String newPassword=MD5Util.MD5EncodeUtf8(password);
		int result = userRepository.updatePassword(newPassword,userId);
		if (result>0){
			return ServerResponse.createSuccess();
		}
		return ServerResponse.createError();
	}
}