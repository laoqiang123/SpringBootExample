package com.example.test.example;

import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: ljx
 * @Date: 2019/7/2
 */
public class Test15 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2019,7,16);

        Calendar c1 = Calendar.getInstance();
        c1.set(2018,12,14);

        System.out.println(c.get(Calendar.DATE)-c1.get(Calendar.DATE));




    }


}
