package com.test.demo.rest.advice;

import com.test.demo.exception.NullStudentsInCollectionException;
import com.test.demo.exception.StudentNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ResponseAdvice {

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public String studentNotFound(){
        return "Student Not Found";
    }

    @ExceptionHandler(NullStudentsInCollectionException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public String nullStudentsInCollection(){
        return "Collection havent student";
    }


}
