/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ICollegeService
 * Author:   Administrator
 * Date:     2018/9/16 0016 15:33
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyums.service;



import com.yuan.xianyums.common.ServerResponse;
import com.yuan.xianyums.pojo.Category;
import com.yuan.xianyums.pojo.College;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/16 0016
 * @since 1.0.0
 */
public interface ICollegeService {
	Page<College> listAllCollege(Integer pageNum, Integer pageSize);

	College getCollegeById(Integer collegeId);

	ServerResponse updateCollege(College college);

	ServerResponse deleteCollege(Integer collegeId);
}
