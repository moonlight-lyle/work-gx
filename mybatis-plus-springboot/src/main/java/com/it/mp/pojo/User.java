package com.it.mp.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 生成set、get方法
@NoArgsConstructor // 生成无参构造方法
@AllArgsConstructor // 生成全参构造方法
@TableName("tb_user") // 标记与该实体类对应的数据表名称
public class User {

    @TableId(type = IdType.AUTO) // 可以设置id自增策略
    private Long id;
    @TableField(value = "user_name") // 可以和数据库的字段做映射
    private String userName;
    private String password;
    private String name;
    private Integer age;
    private String email;
}
