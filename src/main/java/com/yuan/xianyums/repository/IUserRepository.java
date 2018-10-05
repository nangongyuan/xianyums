/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: IUserRepository
 * Author:   Administrator
 * Date:     2018/9/15 0015 19:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyums.repository;

import com.yuan.xianyums.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/15 0015
 * @since 1.0.0
 */
public interface IUserRepository extends JpaRepository<User,Integer> {

	User findByUsername(String username);

	@Modifying
	@Query("update User user set user.password=:password where user.id=:id")
	int updatePassword(@Param(value = "password")String password, @Param(value = "id")Integer id);

	@Modifying
	@Query("update User user set user.username=:username ,user.email=:email,user.phone=:phone,user.role=:role where user.id=:id")
	int updateUser(@Param(value = "username")String username, @Param(value = "email")String email,
				   @Param(value = "phone")String phone,@Param(value = "role")Integer role,@Param(value = "id")Integer id);
}
