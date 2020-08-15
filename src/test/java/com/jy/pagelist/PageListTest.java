package com.jy.pagelist;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import java.util.Arrays;
import java.util.List;

/**
 * 集合分页工具类单元测试
 *
 * @author JinChunZhao
 * @version 1.0
 * @date 2020-08-08 18:51
 */
public class PageListTest {

    private PageList pagelist;

    private PageList pagelist2;

    @Before public void setUp() throws Exception {
        pagelist = new PageList(3, 10);
        PageList pagelist1 = new PageList();
        pagelist2 = new PageList(0, 2);
    }

    @After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void getRecords() {
        pagelist.setRecords(Arrays.asList(1,2,3));
        Assert.assertNotNull(pagelist.getRecords());
    }



    @org.junit.Test
    public void getTotal() {
        int total = 12;
        pagelist.setTotal(total);
        Assert.assertEquals(total,pagelist.getTotal());
    }

    @org.junit.Test
    public void getSize() {
        int size = 10;
        pagelist.setSize(size);
        Assert.assertEquals(size,pagelist.getSize());
    }


    @org.junit.Test
    public void getCurrent() {
        int current = 1;
        pagelist.setCurrent(current);
        Assert.assertEquals(current,pagelist.getCurrent());
    }



    @org.junit.Test
    public void getPageList() {
        List<String> list =
            Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15");
        int size = 10;
        for (int i = 1;i<4;i++){
            PageList page = new PageList(i, size);
            List<?> pageList = page.getPageList(list);
            Assert.assertNotNull(pageList);
        }

    }

    @org.junit.Test
    public void getPageList1() {
        List<String> list =
            Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15");
        List<?> pageList1 = pagelist2.getPageList(list);
        Assert.assertNotNull(pageList1);
    }
}