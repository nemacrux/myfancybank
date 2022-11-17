package com.nemacrux.web;

import com.nemacrux.context.BadRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BadRequestDto handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        List<String> errorDetails = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + " " + fieldError.getDefaultMessage())
                .collect(Collectors.toList());

        return new BadRequestDto("The request body is not well formed", errorDetails);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public BadRequestDto handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        System.out.println(exception.getMessage());
        return new BadRequestDto("The request body is not well formed", List.of());
    }

}
