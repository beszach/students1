package com.test.demo;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Test1 {

    @BeforeAll
    public static void testz(){
        System.out.println("beforeall");
    }

    @AfterAll
    public static void testv(){
        System.out.println("afterall");
    }

    @BeforeEach
    public void test0(){
        System.out.println("BeforeEach");
    }

    @Test
    public void test1(){
        System.out.println("Test1");
        Assertions.assertEquals(2, 2);
    }

    @Test
    public void test2(){
        Assertions.assertThrows(ArithmeticException.class, () -> {
            int a = 5;
            a = 5/0;
        });
    }

    @Test
    public void test3(){
        Assertions.assertNotEquals(2, 3, "here");
    }

    @Test
    public void test4(){
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        Assertions.assertArrayEquals(a, b);
    }

    @Test
    public void test5(){
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list2.add("1");
        list2.add("2");
        Assertions.assertIterableEquals(list1, list2);
    }

    @Test
    public void test6(){
        String a = null;
        Assertions.assertNull(a);
    }

    @Test
    public void test7(){
        Assertions.assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(50);
            return "result";
        });
    }

}
