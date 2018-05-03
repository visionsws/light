package com.vicente.light.configura;

import com.vicente.light.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shiweisen
 * @since 2018-03-30
 */
public class Test {

    public static void main(String[] args) {
       String aa = "0009";
       int bb = Integer.parseInt(aa);
        System.out.println(bb);
    }

    public static void pass(User pass){
        System.out.println("333 "+pass);
        pass = new User();
        System.out.println("444 "+pass);
    }
}
