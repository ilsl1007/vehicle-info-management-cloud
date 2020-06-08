package com.yulj.common.core.utils;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Classname PagedGridResult
 * @Description <h1>分页Grid的数据格式</h1>
 * @Author yulj
 * @Date: 2020/6/9 00:17
 */
@Data
@ApiModel(value = "分页Grid数据对象")
public final class PagedGridResult<T> {

    private Long total;

    private List<T> rows;

    public PagedGridResult(Page<T> page) {
        this.total = page.getTotalElements();
        this.rows = page.getContent();
    }

}
