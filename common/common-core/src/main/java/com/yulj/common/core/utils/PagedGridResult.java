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

    private Integer code;

    private String msg;

    private Long count;

    private List<T> Data;

    public PagedGridResult(Page<T> page) {
        this.code = 0;
        this.msg = "";
        this.count = page.getTotalElements();
        this.Data = page.getContent();
    }

}
