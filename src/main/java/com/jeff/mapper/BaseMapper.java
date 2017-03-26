package com.jeff.mapper;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * author:  jeff.hezuxing@alibaba-inc.com
 *
 * date  :  2016/6/1
 */
public interface BaseMapper<T> extends Mapper<T>, ConditionMapper<T>, MySqlMapper<T> {

}
