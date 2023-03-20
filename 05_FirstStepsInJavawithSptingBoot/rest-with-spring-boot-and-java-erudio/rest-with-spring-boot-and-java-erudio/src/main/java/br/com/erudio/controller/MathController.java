package br.com.erudio.controller;

import br.com.erudio.converter.DoubleConverter;
import br.com.erudio.exception.UnsuportedMathOperationException;
import br.com.erudio.formatter.NumberFormatter;
import br.com.erudio.service.CalculadoraService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    private final CalculadoraService calculadora;

    public MathController(CalculadoraService calculadora) {
        this.calculadora = calculadora;
    }

    @RequestMapping(value = "/somar/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public String somar(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) {

        Double numberOneConvertido = DoubleConverter.convertToDouble(numberOne);
        Double numberTwoConvertido = DoubleConverter.convertToDouble(numberTwo);
        double resultado = calculadora.somar(numberOneConvertido, numberTwoConvertido);
        return NumberFormatter.formatDouble(resultado);
    }

    @RequestMapping(value = "/subtrair/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public String subtrair(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) {

        Double numberOneConvertido = DoubleConverter.convertToDouble(numberOne);
        Double numberTwoConvertido = DoubleConverter.convertToDouble(numberTwo);
        double resultado = calculadora.subtrair(numberOneConvertido, numberTwoConvertido);
        return NumberFormatter.formatDouble(resultado);
    }

    @RequestMapping(value = "/multiplicar/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public String multiplicar(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) {

        Double numberOneConvertido = DoubleConverter.convertToDouble(numberOne);
        Double numberTwoConvertido = DoubleConverter.convertToDouble(numberTwo);
        double resultado = calculadora.multiplicar(numberOneConvertido, numberTwoConvertido);
        return NumberFormatter.formatDouble(resultado);
    }

    @RequestMapping(value = "/dividir/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public String dividir(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) {
    if("0".equals(numberTwo)){
        throw new UnsuportedMathOperationException("Não é possível efetuar uma dividão por 0");
    }
        Double numberOneConvertido = DoubleConverter.convertToDouble(numberOne);
        Double numberTwoConvertido = DoubleConverter.convertToDouble(numberTwo);
        double resultado = calculadora.dividir(numberOneConvertido, numberTwoConvertido);
        return NumberFormatter.formatDouble(resultado);
    }

    @RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public String media(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) {

        Double numberOneConvertido = DoubleConverter.convertToDouble(numberOne);
        Double numberTwoConvertido = DoubleConverter.convertToDouble(numberTwo);

        double resultado = calculadora.media(numberOneConvertido, numberTwoConvertido);
        return NumberFormatter.formatDouble(resultado);
    }

    @RequestMapping(value = "/raizquadrada/{numberOne}", method = RequestMethod.GET)
    public String raiz(@PathVariable(value = "numberOne") String numberOne) {
        Double numberConvertido = DoubleConverter.convertToDouble(numberOne);
        double resultado = calculadora.raizQuadrada(numberConvertido);
        return NumberFormatter.formatDouble(resultado);
    }

}
