/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: IUserService
 * Author:   Administrator
 * Date:     2018/9/15 0015 19:22
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyums.service;


import com.yuan.xianyums.common.ServerResponse;
import com.yuan.xianyums.pojo.User;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/15 0015
 * @since 1.0.0
 */
public interface IUserService {

	ServerResponse<User> login(User user);

	Page<User> listAllUser(Integer pageNum, Integer pageSize);

	User getUserById(Integer userId);

	ServerResponse updateUser(User user);

	void deleteUser(Integer userId);

	ServerResponse resetPassword(Integer userId, String password);
}
