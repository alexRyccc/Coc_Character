package com.coc.character.pojo;

import lombok.Data;

/**
 * @author ran_ych
 * @create 2020-04-22  15:05
 * @desc
 */
@Data
public class SysLogBO {

    private String className;

    private String methodName;

    private String params;

    private Long exeuTime;

    private String remark;

    private String createDate;
}