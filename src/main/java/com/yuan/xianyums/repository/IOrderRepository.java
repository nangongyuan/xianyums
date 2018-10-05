/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: IOrderRepository
 * Author:   Administrator
 * Date:     2018/9/24 0024 13:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyums.repository;


import com.yuan.xianyums.pojo.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/24 0024
 * @since 1.0.0
 */
public interface IOrderRepository extends JpaRepository<Order, Integer> {

}
