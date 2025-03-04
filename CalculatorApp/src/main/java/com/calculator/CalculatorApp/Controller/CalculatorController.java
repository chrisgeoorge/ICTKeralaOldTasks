package com.calculator.CalculatorApp.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CalculatorController {

    @PostMapping("/add")
    public Map<String, Object> add(@RequestBody Map<String, Double> request) {
        double num1 = request.get("num1");
        double num2 = request.get("num2");
        double result = num1 + num2;
        System.out.println("Addition result: " + result);
        return Map.of("operation", "addition", "num1", num1, "num2", num2, "result", result);
    }

    @PostMapping("/subtract")
    public Map<String, Object> subtract(@RequestBody Map<String, Double> request) {
        double num1 = request.get("num1");
        double num2 = request.get("num2");
        double result = num1 - num2;
        System.out.println("Subtraction result: " + result);
        return Map.of("operation", "subtraction", "num1", num1, "num2", num2, "result", result);
    }

    @PostMapping("/multiply")
    public Map<String, Object> multiply(@RequestBody Map<String, Double> request) {
        double num1 = request.get("num1");
        double num2 = request.get("num2");
        double result = num1 * num2;
        System.out.println("Multiplication result: " + result);
        return Map.of("operation", "multiplication", "num1", num1, "num2", num2, "result", result);
    }

    @PostMapping("/divide")
    public Map<String, Object> divide(@RequestBody Map<String, Double> request) {
        double num1 = request.get("num1");
        double num2 = request.get("num2");
        if (num2 == 0) {
            System.out.println("Division by zero attempt.");
            return Map.of("operation", "division", "error", "Division by zero is not allowed.");
        }
        double result = num1 / num2;
        System.out.println("Division result: " + result);
        return Map.of("operation", "division", "num1", num1, "num2", num2, "result", result);
    }
}
