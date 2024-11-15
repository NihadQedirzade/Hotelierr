package com.example.hoteliermvc.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView handleCustomException(NotFoundException ex, Model model) {
        model.addAttribute("errorMessage", "Not Found");
        return new ModelAndView("error");
}}
