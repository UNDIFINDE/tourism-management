package com.yq.travelmanagement.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 夜倾
 * @version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer Code;// 请求状态
    private String msg;  // 请求反馈信息
    private Object data; // 请求得到的数据

}
