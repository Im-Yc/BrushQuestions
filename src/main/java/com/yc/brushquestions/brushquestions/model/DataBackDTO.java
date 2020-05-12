package com.yc.brushquestions.brushquestions.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author liuxin@worken.cn
 * @Date 2020-05-12 19:32:21
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataBackDTO {

    //阅读量
    private int readNum;

    /**
     * 文章发布时间(yyyy-MM-dd)
     */
    private String time;
}
