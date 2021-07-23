package com.xjf.springboot_test.bean;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Refrain_ouc
 * @create 2021-07-20 11:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @TableId(type= IdType.AUTO)  //根据数据库自增，不是很长的一串
    private Long id;
    private String name;
    private int age;
    private String email;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill=FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    private int version;
    @TableLogic
    private int deleted;




}
