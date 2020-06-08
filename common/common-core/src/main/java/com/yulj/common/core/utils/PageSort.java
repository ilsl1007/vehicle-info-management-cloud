package com.yulj.common.core.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * @Classname PageSort
 * @Description <h1>分页排序数据</h1>
 * @Author yulj
 * @Date: 2020/6/8 22:04
 */
public class PageSort {

    private static final Integer PAGE_SIZE_DEFAULT = 10;
    private static final String ORDER_BY_COLUMN_DEFAULT = "createTime";
    private static final Sort.Direction SORT_DIRECTION = Sort.Direction.DESC;

    /**
     * 创建分页排序对象
     */
    public static PageRequest pageRequest() {
        return pageRequest(PAGE_SIZE_DEFAULT, ORDER_BY_COLUMN_DEFAULT, SORT_DIRECTION);
    }

    /**
     * 创建分页排序对象
     *
     * @param sortDirection 排序方式默认值
     */
    public static PageRequest pageRequest(Sort.Direction sortDirection) {
        return pageRequest(PAGE_SIZE_DEFAULT, ORDER_BY_COLUMN_DEFAULT, sortDirection);
    }

    /**
     * 创建分页排序对象
     *
     * @param orderByColumnDef 排序字段名称默认值
     * @param sortDirection    排序方式默认值
     */
    public static PageRequest pageRequest(String orderByColumnDef, Sort.Direction sortDirection) {
        return pageRequest(PAGE_SIZE_DEFAULT, orderByColumnDef, sortDirection);
    }

    /**
     * 创建分页排序对象
     *
     * @param pageSizeDef      分页数据数量默认值
     * @param orderByColumnDef 排序字段名称默认值
     * @param sortDirection    排序方式默认值
     */
    public static PageRequest pageRequest(Integer pageSizeDef, String orderByColumnDef, Sort.Direction sortDirection) {
        Integer pageIndex = HttpServletUtil.getParameterInt("page", 1);
        Integer pageSize = HttpServletUtil.getParameterInt("size", pageSizeDef);
        String orderByColumn = HttpServletUtil.getParameter("orderByColumn", orderByColumnDef);
        String direction = HttpServletUtil.getParameter("isAsc", sortDirection.toString());
        Sort sort = Sort.by(Sort.Direction.fromString(direction), orderByColumn);
        return PageRequest.of(pageIndex - 1, pageSize, sort);
    }

}
