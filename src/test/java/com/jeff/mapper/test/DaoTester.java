package com.jeff.mapper.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jeff.mapper.CityMapper;
import com.jeff.po.City;
import com.jeff.qo.CityPageQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * author:  jeff.hezuxing@alibaba-inc.com
 *
 * date  :  2016/6/1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class DaoTester {

    @Autowired
    private CityMapper mapper;

    /**
     * 查询总记录数
     */
    @Test
    public void testGetCount() {
        int count = mapper.selectCount(null);
        System.out.println("通用Mapper：" + count);
    }

    /**
     * 测试通用Mapper性能（和自己写sql对比）
     */
    @Test
    public void testGetCount2() {
        int count = mapper.getCount(null);
        System.out.println("自己写sql：" + count);
    }

    /**
     * 条件查询
     */
    @Test
    public void testGetByCondition() {
        City condition = new City();
        condition.setName("Abha");
        City city = mapper.selectOne(condition);
        System.out.println("id:" + city.getId());
        System.out.println("name:" + city.getName());
    }

    /**
     * 测试分页插件
     */
    @Test
    public void testGetByPage() {
        PageHelper.startPage(2, 10, "id desc");
        List<City> cities = mapper.selectAll();
        int size = cities.size();
        System.out.println("返回记录数：" + size);
        System.out.println("起始id：" + cities.get(0).getId());
        System.out.println("结束id：" + cities.get(size - 1).getId());
        //强制转换成Page<T>类型，可以获取当前页相关的信息
        Page<City> cityPage = (Page<City>) cities;
        System.out.println("起始行数：" + cityPage.getStartRow());
        System.out.println("结束行数：" + cityPage.getEndRow());
        System.out.println("当前页记录数：" + cityPage.getPageSize());
        System.out.println("总记录数：" + cityPage.getTotal());
        //测试拦截器性能
        //CityPageQuery condition = new CityPageQuery();
        //List<City> cities2 = mapper.selectByPage(condition);
        //System.out.println(cities2.size());
    }

    /**
     * 测试拦截器性能（和自己写sql对比）
     */
    @Test
    public void testGetByPage2() {
        int count = mapper.selectCount(null);
        System.out.println(count);
        CityPageQuery condition = new CityPageQuery();
        condition.setPageNum(1);
        condition.setPageSize(10);
        List<City> cities = mapper.selectByPage(condition);
        System.out.println(cities.size());
    }

}
