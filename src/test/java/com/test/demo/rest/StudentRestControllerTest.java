package com.test.demo.rest;

import com.test.demo.dto.StudentDto;
import com.test.demo.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
public class StudentRestControllerTest {

    @Mock
    private StudentService studentService;

    @Spy
    private List<String> list = new ArrayList<>(16);

    @Spy
    private Map<Integer, String> map = new HashMap<>();

    @InjectMocks
    private StudentRestController studentRestController;


    @Test
    public void test1(){
        StudentDto studentDto = StudentDto.builder()
                .id(5L)
                .name("Alex")
                .description("test")
                .courseNumber(2L)
                .build();

        Mockito.when(studentService.getById(5L)).thenReturn(studentDto);
        StudentDto studentDto1 = studentRestController.getById(5L);
        System.out.println(studentDto1);
        assertEquals(studentDto1.getDescription(), studentDto.getDescription());
    }

//    @Test
//    public void test2(){
//        list.add("1");
//        list.add("2");
//        Mockito.doReturn(5).when(list).size();
//
//        System.out.println(list.size());
//
//        List<String> list2 = new ArrayList<>();
//        list2.add("1");
//        list2.add("2");
//
//    }
//
//    @Test
//    public void test3(){
//        Mockito.doReturn("here").when(list).get(1);
//        System.out.println(list.get(1));
//    }
//
//    @Test
//    public void testSpyMapPutDefaultBehavior() {
//        //when
//        map.put(1, "test");
//
//        //then
//        assertEquals(map.get(1), "test");
//    }
//
//    @Test
//    public void testSpyMapKeySetDefaultBehavior() {
//        //when
//        map.put(1, "test1");
//        map.put(2, "test2");
//
//        List<Integer> l = new ArrayList<>();
//        l.add(1);
//        l.add(2);
//
//        //then
//        Assertions.assertIterableEquals(map.keySet(), l);
//    }
//
//    @Test
//    public void testSpyMapValuesWithDefinedBehavior() {
//        Collection<String> stub = Arrays.asList("test1", "test2", "test3");
//        Mockito.when(map.values()).thenReturn(stub);
//
//        //when
//        map.put(1, "test");
//
//        System.out.println(map.get(1));
//
//        System.out.println(map.values());
//    }


}
