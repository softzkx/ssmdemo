package com.jeff.qo;

import java.util.Date;

/**
 * Created by jeffhhe on 2016/12/22.
 */
public class CityPageQuery extends BasePageQuery {

    private Short cityId;
    private String city;
    private Short countryId;
    private Date lastUpdate;

    public Short getCityId() {
        return cityId;
    }

    public void setCityId(Short cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Short getCountryId() {
        return countryId;
    }

    public void setCountryId(Short countryId) {
        this.countryId = countryId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
