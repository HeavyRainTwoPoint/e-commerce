package com.bigliang.e_commerce.po;

import java.util.List;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/10/5 21:04
 */

public class PageBean<T> {
    /**
     * 当前页
     */
    private int targetPage;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 条目总数
     */
    private int totalCount;
    /**
     * 每页显示数量, 默认是显示十条
     */
    private int limit = 10;
    /**
     * 条目列表
     */
    private List<T> entryList;

    public int getTargetPage() {
        return targetPage;
    }

    public void setTargetPage(int targetPage) {
        this.targetPage = targetPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<T> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<T> entryList) {
        this.entryList = entryList;
    }
}
