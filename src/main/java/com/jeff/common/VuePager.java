package com.jeff.common;

import com.github.pagehelper.Page;

import java.util.List;

/**
 * 适应Vue-table插件的VuePager Vo
 * <p/>
 * Created by zuxing.hezuxing on 2016/6/2.
 */
public class VuePager {

    private int     currentPage;//当前页面
    private int     totalPage;  //总页数
    private int     pageSize;   //每页记录数
    private long    totalSize;  //总记录数
    private int     startRow;   //起始行号
    private int     endRow;     //结束行号

    private List<?> rows;       //数据集

    public VuePager() {
    }

    public VuePager(Page<?> page) {
        this.currentPage = page.getPageNum();
        this.totalPage = page.getPages();
        this.pageSize = page.getPageSize();
        this.totalSize = page.getTotal();
        this.startRow = page.getStartRow();
        //page.getEndRow()貌似有问题,及时当前查询到的记录数少于PageSize，依然返回startRow+PageSize！
        //this.endRow = page.getEndRow();
        this.endRow = page.getStartRow() + page.getResult().size();
        this.rows = page.getResult();
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

}
