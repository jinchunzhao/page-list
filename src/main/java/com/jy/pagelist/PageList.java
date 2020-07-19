package com.jy.pagelist;

import java.util.Collections;
import java.util.List;

/**
 * 集合分页
 *
 * @author JinChunZhao
 * @version 1.0
 * @date 2020-07-19 18:10
 */
public class PageList {

    /**
     * 查询数据列表
     */
    private List<?> records = Collections.emptyList();

    /**
     * 总数
     */
    private long total = 0;
    /**
     * 每页显示条数，默认 10
     */
    private long pageSize = 10;

    /**
     * 当前页
     */
    private long current = 1;

    public PageList() {
    }

    /**
     * 分页构造函数
     *
     * @param current 当前页
     * @param pageSize    每页显示条数
     */
    public PageList(long current, long pageSize) {
        this(current, pageSize, 0);
    }



    public PageList(long current, long pageSize, long total) {
        if (current > 1) {
            this.current = current;
        }else{
            this.current = 1;
        }
        this.pageSize = pageSize;
        this.total = total;
    }




    public List<?> getRecords() {
        return records;
    }

    public void setRecords(List<?> records) {
        this.records = records;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getCurrent() {
        return current;
    }

    public void setCurrent(long current) {
        this.current = current;
    }

    /**
     * 集合分页
     *
     * @param resourceList 要分页的集合
     * @return 分页后的集合
     */
    public List<?> getPageList(List<?> resourceList) {
        if (this.current < 1) {
            this.current = 1;
        }
        this.total = resourceList.size();
        int pageCount = (int) (this.total / this.pageSize);
        int fromIndex = (int) ((this.current - 1) * this.pageSize);
        int toIndex = (int) (fromIndex + this.pageSize);
        if (toIndex >= this.total) {
            toIndex = (int)this.total;
        }
        if (this.current > pageCount + 1) {
            fromIndex = 0;
            toIndex = 0;
        }
        this.records = resourceList.subList( fromIndex, toIndex );
        return this.records;
    }


}
