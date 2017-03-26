package com.jeff.qo;

/**
 * Created by jeffhhe on 2016/12/22.
 */
public class BasePageQuery {

    private int pageNum = 1;
    private int pageSize = 10;
    private String orderBy;


    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
