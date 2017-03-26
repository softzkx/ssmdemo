package com.jeff.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jeff.mapper.BaseMapper;
import com.jeff.service.BaseService;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * author:  jeff.hezuxing@alibaba-inc.com
 *
 * date  :  2016/6/1
 */
public class BaseServiceImpl<T> implements BaseService<T> {

    /**
     * 创建Class的对象来获取泛型的class
     */
    public Class<?> clz = null;

    public Class<?> getClz() {
        if (this.clz == null) {
            // 获取泛型的Class对象
            this.clz = ((Class<?>) (((ParameterizedType) (this.getClass().getGenericSuperclass()))
                .getActualTypeArguments()[0]));
        }
        return this.clz;
    }

    public void initPage(Integer pageNum, Integer pageSize, String orderby) {
        try {
            if (pageNum == null) {
                pageNum = 1;
            }
            if (pageSize == null) {
                pageSize = 10;
            }
            if (orderby == null || orderby.trim().equals("")) {
                PageHelper.startPage(pageNum, pageSize);
            } else {
                PageHelper.startPage(pageNum, pageSize, orderby);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通用Mappper对象，需要在实际的xxxServiceImpl中通过setter方法注入
     */
    private BaseMapper<T> baseMapper;

    public BaseMapper<T> getBaseMapper() {
        return baseMapper;
    }

    public void setBaseMapper(BaseMapper<T> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public T selectByPrimaryKey(Object key) {
        return baseMapper.selectByPrimaryKey(key);
    }

    @Override
    public List<T> select(T record) {
        return baseMapper.select(record);
    }

    @Override
    public List selectAll() {
        return baseMapper.selectAll();
    }

    @Override
    public T selectOne(T record) {
        return baseMapper.selectOne(record);
    }

    @Override
    public int selectCount(T record) {
        return baseMapper.selectCount(record);
    }

    @Override
    public int insert(T record) {
        return baseMapper.insert(record);
    }

    @Override
    public int insertSelective(T record) {
        return insertSelective(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return baseMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        return baseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(T record) {
        return baseMapper.delete(record);
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        return baseMapper.deleteByPrimaryKey(key);
    }

    @Override
    public List<T> selectByCondition(T condition) {
        return baseMapper.selectByCondition(condition);
    }

    @Override
    public int selectCountByCondition(T condition) {
        return baseMapper.selectCountByCondition(condition);
    }

    @Override
    public Page<T> selectByPage(T condition, Integer pageNum, Integer pageSize, String orderby) {
        this.initPage(pageNum, pageSize, orderby);
        return (Page<T>) baseMapper.select(condition);
    }
}
