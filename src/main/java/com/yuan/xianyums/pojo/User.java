/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: User
 * Author:   Administrator
 * Date:     2018/9/15 0015 19:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyums.pojo;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 〈用户〉
 *
 * @author Administrator
 * @create 2018/9/15 0015
 * @since 1.0.0
 */
@Entity
@Data
@DynamicUpdate
@DynamicInsert
public class User {

	/** id */
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;

	/** 用户名*/
	private String username;

	/** 密码*/
	private String password;

	/** email*/
	private String email;

	/** 电话*/
	private String phone;

	/** 角色 0管理员 1普通用户*/
	private Integer role;

	/** 创建时间*/
	private Date createTime;

	/** 更新时间*/
	private Date updateTime;
}