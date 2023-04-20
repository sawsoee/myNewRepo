package com.sawsoer.calcullator.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sawsoer.calcullator.service.CalculateImpl;

@Controller
public class controller {

    public Double result = null;
    public Double percentResult = null;
    public CalculateImpl calculateImpl;

    public controller(CalculateImpl calculateImpl) {
        this.calculateImpl = calculateImpl;
    }

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("result", result);
        return "index";
    }

    @GetMapping("/percent")
    public String getPercent(Model model) {
        model.addAttribute("percentResult", percentResult);
        return "percent";
    }

    @PostMapping("/handelSubmit")
    public String handelSubmit(@RequestParam(required = false) Double num1,
            @RequestParam(required = false) Double num2,
            @RequestParam(required = false) String operator) {

        if (num1 == null || num2 == null) {
            return "redirect:/";
        }

        result = calculateImpl.calculate(num1, num2, operator);
        System.out.println(result);
        return "redirect:/";
    }

    @PostMapping("/handelPercent")
    public String handelPercent(@RequestParam(required = false) Double sum,
            @RequestParam(required = false) Double percent) {
            percentResult = calculateImpl.percent(sum, percent);
            System.out.println(percentResult);
        return "redirect:/percent";
    }

}
