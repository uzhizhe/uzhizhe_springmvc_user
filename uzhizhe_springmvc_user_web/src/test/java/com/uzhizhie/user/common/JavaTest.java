package com.uzhizhie.user.common;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Desc
 * @Author qingjiang.li
 * @Email qingjiang.li@ninebot.com
 * @Date 2019-08-02
 */
public class JavaTest {


    @Test
    public void test13() throws Exception {
        Map<String, Integer> map = new HashMap<>();
        map.put("123", 123);
    }

    @Test
    public void test24() throws Exception {
        for (int i = 0; i < 100; i++) {
            int size = tableSizeFor(i);
            System.out.println(i + " : " + size);
        }

    }

    private int tableSizeFor(int cap) {
        int MAXIMUM_CAPACITY = 1 << 30;
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    @Test
    public void test44() throws Exception {
        int i = new Random().nextInt(2);
        System.out.println(i);
        i = new Random().nextInt(2);
        System.out.println(i);
        i = new Random().nextInt(2);
        System.out.println(i);
        i = new Random().nextInt(2);
        System.out.println(i);
        i = new Random().nextInt(2);
        System.out.println(i);

    }



}
