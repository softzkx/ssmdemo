package com.jeff.service;

import com.github.pagehelper.Page;

import java.util.List;

/**
 * author:  jeff.hezuxing@alibaba-inc.com
 *
 * date  :  2016/6/1
 */
public interface BaseService<T> {

    /**
     * 根据主键查询
     *
     * @param key
     * @return null or entity
     */
    T selectByPrimaryKey(Object key);

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     *
     * @param record
     * @return
     */
    List<T> select(T record);

    /**
     * 查询全部结果，select(null)方法能达到同样的效果
     *
     * @return
     */
    List<T> selectAll();

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     *
     * @param record
     * @return
     */
    T selectOne(T record);

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     *
     * @param record
     * @return
     */
    int selectCount(T record);

    /**
     * 插入数据
     *
     * @param record
     * @return success:1  fail:0
     */
    int insert(T record);

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     *
     * @param record
     * @return
     */
    int insertSelective(T record);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(T record);

    /**
     * 根据主键更新属性不为null的值
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     *
     * @param record
     * @return
     */
    int delete(T record);

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     *
     * @param key
     * @return
     */
    int deleteByPrimaryKey(Object key);

    /**
     * 根据Condition条件进行查询
     *
     * @param condition
     * @return
     */
    List<T> selectByCondition(T condition);

    /**
     * 根据Condition条件进行查询总数
     *
     * @param condition
     * @return
     */
    int selectCountByCondition(T condition);

    /**
     * 按po属性分页查询分页查询
     * @param condition
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<T> selectByPage(T condition, Integer pageNum, Integer pageSize, String orderby);
}
