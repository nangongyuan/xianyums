/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserController
 * Author:   Administrator
 * Date:     2018/9/15 0015 19:23
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyums.controller;

import com.yuan.xianyums.common.Const;
import com.yuan.xianyums.common.ServerResponse;
import com.yuan.xianyums.enums.ResponseCode;
import com.yuan.xianyums.pojo.User;
import com.yuan.xianyums.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/15 0015
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping("/login")
	public ModelAndView login(User user, Model model, HttpSession httpSession, HttpServletResponse response) throws IOException {
		ServerResponse<User> result = userService.login(user);
		if (result.getStatus() == ResponseCode.SUCCESS.getCode()){
			httpSession.setAttribute(Const.LOGIN_USER,result.getData());
			response.sendRedirect("/");
		}else{
			model.addAttribute(Const.ERROR_MSG,result.getMsg());
		}
		return new ModelAndView("login","model",model);
	}

	@GetMapping("/logout")
	public void logout(Model model,HttpSession session, HttpServletResponse response) throws IOException {
		session.removeAttribute(Const.LOGIN_USER);
		response.sendRedirect("/login");
	}

	@RequestMapping("/delete")
	public void deleteUser(Integer userId){
		userService.deleteUser(userId);
	}

	@RequestMapping("/update")
	public void updateUser(User user){
		userService.updateUser(user);
	}

	@RequestMapping("/reset_password")
	public ServerResponse updateUser(Integer userId, String password){
		return userService.resetPassword(userId, password);
	}


}