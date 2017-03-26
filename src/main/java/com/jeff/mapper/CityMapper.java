package com.jeff.mapper;

import com.jeff.po.City;
import com.jeff.qo.CityPageQuery;

import java.util.List;

public interface CityMapper extends BaseMapper<City> {

    List<City> selectByPage(CityPageQuery cityPageQuery);

    Integer getCount(City city);
}