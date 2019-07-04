package com.example.test.form;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import sun.awt.SunHints;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @Author: ljx
 * @Date: 2019/7/4
 */
public class UserForm {
    @NotNull(message = "id 不能为空")
    private Long id;

    //@Past 从今天之前
    @Future(message = "时间只能是今天向后")
    @DateTimeFormat(pattern = "yyyy-MM-dd")//规定日期格式，必须是这种，否则报错
    private Date date;

    @DecimalMin(value = "0.1")
    @DecimalMax(value = "99.9")//
    private Double doubleValue;

    @Max(value = 9, message = "最大值为99")
    @Min(value = 1, message = "最小值为1")//这种事用于整数
    private Integer intValue;

    @Range(min = 1,max = 13,message = "不能超范围")
    private Integer age;

    @Email(message = "邮箱错误")
    private String email;

    @Size(min = 20,max = 30,message = "用户名长度不够")
    private String userName;




}
