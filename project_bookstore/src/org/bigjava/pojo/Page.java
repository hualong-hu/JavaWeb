package org.bigjava.pojo;
import	java.awt.print.Book;

import java.util.List;

/**
 * Page分页的对象模型
 * <T>是具体的模块的JavaBean类
 * @ProjectName: JavaWeb
 * @ClassName: Page
 * @Description: TODO
 * @Author: 洛笙
 * @Date: 2020-06-07 10:45
 * @Version v1.0
 */
public class Page<T> {

    public static final Integer PAGE_SIZE = 4;
    /**
     * 当前页码
     */
    private Integer pageNo;
    /**
     * 总页码
     */
    private Integer pageTotal;
    /**
     * 当前页显示数量
     */
    private Integer pageSize = PAGE_SIZE;
    /**
     *总记录数
     */
    private Integer pageTotalCount;
    /**
     * 当前页数据
     */
    private List<T> items;

    /**
     * 分页条的请求地址
     */
    private String url;

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {


        if (pageNo<1){
            pageNo = 1;
        }
        if (pageNo > pageTotal){
            pageNo = pageTotal;
        }
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
