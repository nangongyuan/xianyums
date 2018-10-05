/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ILeaveWordService
 * Author:   Administrator
 * Date:     2018/9/22 0022 10:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.yuan.xianyums.service;


import com.yuan.xianyums.pojo.LeaveWord;
import com.yuan.xianyums.vo.LeaveWordVo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 〈〉
 *
 * @author Administrator
 * @create 2018/9/22 0022
 * @since 1.0.0
 */
public interface ILeaveWordService {
	Page<LeaveWordVo> listAllLeaveWord(Integer pageNum, Integer pageSize);
}
