/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: IProvinceRepository
 * Author:   Administrator
 * Date:     2018/9/16 0016 11:52
 * Description: 省份
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyums.repository;

import com.yuan.xianyums.pojo.Province;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 〈省份〉
 *
 * @author Administrator
 * @create 2018/9/16 0016
 * @since 1.0.0
 */
public interface IProvinceRepository extends JpaRepository<Province,Integer> {

}
