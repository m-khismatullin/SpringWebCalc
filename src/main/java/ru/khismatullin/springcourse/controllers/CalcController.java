package ru.khismatullin.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletRequest;

@Controller
public class CalcController {
    @GetMapping("/calc")
    public String calcPage(ServletRequest request,
                           Model model) {

        String calcResult, operation, operator;
        int operandOne, operandTwo, result;

        try {
            operation = request.getParameter("operation");
            operandOne = Integer.parseInt(request.getParameter("operandOne"));
            operandTwo = Integer.parseInt(request.getParameter("operandTwo"));
            switch (operation) {
                case ("a") : result = operandOne + operandTwo; operator = "+"; break;
                case ("s") : result = operandOne - operandTwo; operator = "-"; break;
                case ("m") : result = operandOne * operandTwo; operator = "*"; break;
                case ("d") : {
                    if (operandTwo == 0) throw new IllegalArgumentException();
                    result = operandOne / operandTwo;
                    operator = "/";
                    break;
                }
                default: throw new IllegalArgumentException();
            };
            calcResult = operandOne + " " + operator + " " + operandTwo + " = " + result;
        } catch (IllegalArgumentException e) {
            calcResult = "Enter valid operands or operator!";
        }

        model.addAttribute("calcResult", calcResult);

        return "calc";
    }
}
