package br.edu.usj.ads.pw.calculadora;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



    @Controller
    @RequestMapping("/calculadora")
    public class Caculadora {

        @GetMapping   
        public ModelAndView calculadora() {
            return new ModelAndView("calculadora");
        }
    
    @PostMapping ("/resultado")
    public ModelAndView resultado(
        
        @RequestParam Double number1,@RequestParam Double number2, @RequestParam String option) {

        ModelAndView modelAndView =  new ModelAndView("resultado");
        modelAndView.addObject("resultado", getResultado (number1, number2, option));
        return modelAndView;
    }
    
    private Double getResultado (Double number1, Double number2, String option) {
        Double resultado;
        switch (option) {
            case "somar":
                resultado = number1 + number2;
                break;
            case "subtrair":
                resultado = number1 - number2;
                break;
            case "multiplicar":
                resultado = number1 * number2;
                break;
            case "divide":
                if (number2 != 0) {
                    resultado = number1 / number2;
                } else {
                    resultado = 0.0;
                }
                break;
            default:
                resultado = 0.0;
                break;
        }
        return resultado;
    }


}
