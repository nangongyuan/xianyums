/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: DisplayController
 * Author:   Administrator
 * Date:     2018/9/16 0016 14:31
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyums.controller;

import com.yuan.xianyums.common.Const;
import com.yuan.xianyums.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/16 0016
 * @since 1.0.0
 */
@Controller
public class DisplayController {

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private IFileService fileService;

	@Autowired
	private IProductService productService;

	@Autowired
	private ICollegeService collegeService;

	@Autowired
	private ICollectService collectService;

	@Autowired
	private IUserService userService;

	@Autowired
	private ILeaveWordService leaveWordService;

	@Autowired
	private IOrderService orderService;

	@Autowired
	private IProvinceService provinceService;

	@GetMapping("/")
	public ModelAndView index(Model model, HttpSession httpSession,
							  @RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
							  @RequestParam(name = "pageSize", defaultValue = "20")Integer pageSize){
		model.addAttribute(Const.LOGIN_USER,httpSession.getAttribute(Const.LOGIN_USER));
		model.addAttribute("page",userService.listAllUser(pageNum, pageSize));
		return new ModelAndView("index","model",model);
	}

	@GetMapping("/login")
	public ModelAndView login(Model model, HttpSession httpSession){
		return new ModelAndView("login","model",model);
	}

	@GetMapping("/user_detail")
	public ModelAndView userDetail(Model model, HttpSession httpSession, Integer userId){
		model.addAttribute("user",userService.getUserById(userId));
		model.addAttribute(Const.LOGIN_USER,httpSession.getAttribute(Const.LOGIN_USER));
		return new ModelAndView("user_detail","model",model);
	}

	@GetMapping("/category")
	public ModelAndView listCategory(Model model, HttpSession httpSession, Integer parentId,
							  @RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
							  @RequestParam(name = "pageSize", defaultValue = "20")Integer pageSize){
		model.addAttribute(Const.LOGIN_USER,httpSession.getAttribute(Const.LOGIN_USER));
		model.addAttribute("parentId",parentId);
		model.addAttribute("page",categoryService.listCategoryByParentId(parentId,pageNum,pageSize));
		return new ModelAndView("category","model",model);
	}

	@GetMapping("/category_detail")
	public ModelAndView categoryDetail(Model model, HttpSession httpSession, Integer categoryId){
		model.addAttribute("category",categoryService.getCategoryById(categoryId));
		model.addAttribute("categoryList",categoryService.listAllCategory());
		model.addAttribute(Const.LOGIN_USER,httpSession.getAttribute(Const.LOGIN_USER));
		return new ModelAndView("category_detail","model",model);
	}

	@GetMapping("/category_add")
	public ModelAndView categoryAdd(Model model, HttpSession httpSession, Integer categoryId){
		model.addAttribute("categoryList",categoryService.listAllCategory());
		model.addAttribute(Const.LOGIN_USER,httpSession.getAttribute(Const.LOGIN_USER));
		return new ModelAndView("category_add","model",model);
	}


	@GetMapping("/product")
	public ModelAndView listProduct(Model model, HttpSession httpSession,
									 @RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
									 @RequestParam(name = "pageSize", defaultValue = "20")Integer pageSize){
		model.addAttribute(Const.LOGIN_USER,httpSession.getAttribute(Const.LOGIN_USER));
		model.addAttribute("page",productService.listAllProduct(pageNum,pageSize));
		return new ModelAndView("product","model",model);
	}

	@GetMapping("/product_detail")
	public ModelAndView productDetail(Model model, HttpSession httpSession, Integer productId){
		model.addAttribute("product",productService.getProductById(productId));
		model.addAttribute("categoryList",categoryService.listAllCategory());
		model.addAttribute(Const.LOGIN_USER,httpSession.getAttribute(Const.LOGIN_USER));
		return new ModelAndView("product_detail","model",model);
	}

	@GetMapping("/college")
	public ModelAndView listCollege(Model model, HttpSession httpSession,
									@RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
									@RequestParam(name = "pageSize", defaultValue = "20")Integer pageSize){
		model.addAttribute(Const.LOGIN_USER,httpSession.getAttribute(Const.LOGIN_USER));
		model.addAttribute("page",collegeService.listAllCollege(pageNum,pageSize));
		return new ModelAndView("college","model",model);
	}

	@GetMapping("/college_detail")
	public ModelAndView collegeDetail(Model model, HttpSession httpSession, Integer collegeId){
		model.addAttribute("college",collegeService.getCollegeById(collegeId));
		model.addAttribute("provinceList",provinceService.listAllProvince());
		model.addAttribute(Const.LOGIN_USER,httpSession.getAttribute(Const.LOGIN_USER));
		return new ModelAndView("college_detail","model",model);
	}

	@GetMapping("/leave_word")
	public ModelAndView listLeaveWord(Model model, HttpSession httpSession,
									@RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
									@RequestParam(name = "pageSize", defaultValue = "20")Integer pageSize){
		model.addAttribute(Const.LOGIN_USER,httpSession.getAttribute(Const.LOGIN_USER));
		model.addAttribute("page",leaveWordService.listAllLeaveWord(pageNum,pageSize));
		return new ModelAndView("leave_word","model",model);
	}

	@GetMapping("/product_order")
	public ModelAndView listProductOrder(Model model, HttpSession httpSession,
									  @RequestParam(name = "pageNum", defaultValue = "0") Integer pageNum,
									  @RequestParam(name = "pageSize", defaultValue = "20")Integer pageSize){
		model.addAttribute(Const.LOGIN_USER,httpSession.getAttribute(Const.LOGIN_USER));
		model.addAttribute("page",orderService.listAllOrder(pageNum,pageSize));
		return new ModelAndView("product_order","model",model);
	}

}