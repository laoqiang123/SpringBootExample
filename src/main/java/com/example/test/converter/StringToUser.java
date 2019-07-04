package com.example.test.converter;

import com.example.test.pojo.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @Author: ljx
 * @Date: 2019/7/4
 */
@Component
public class StringToUser  implements Converter<String, User> {

    @Override
    public User convert(String s) {
        String[] ss = s.split("-");
        User user = new User();
        user.setUserName(ss[0]);
        user.setNote(ss[1]);
        return user;
    }
}
