package br.com.erudio.controller;

import br.com.erudio.exception.UnsuportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.Objects;

@RestController
public class MathController {


    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public String sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) {

        double resultado = convertToDouble(numberOne) - convertToDouble(numberTwo);
        return formatDouble(resultado);
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public String sub(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) {

        double resultado = convertToDouble(numberOne) - convertToDouble(numberTwo);
        return formatDouble(resultado);
    }

    private static String formatDouble(double resultado) {
        return new DecimalFormat("#,##0.00").format(resultado);
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public String multiplicar(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) {

        double resultado = convertToDouble(numberOne) * convertToDouble(numberTwo);
        return formatDouble(resultado);
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public String div(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) {
    if("0".equals(numberTwo)){
        throw new UnsuportedMathOperationException("Não é possível efetuar uma dividão por 0");
    }
        double resultado = convertToDouble(numberOne) / convertToDouble(numberTwo);
        return formatDouble(resultado);
    }

    @RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public String media(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) {

        double resultado = (convertToDouble(numberOne) + convertToDouble(numberTwo))/2;
        return formatDouble(resultado);
    }

    @RequestMapping(value = "/raiz/{numberOne}", method = RequestMethod.GET)
    public String raiz(@PathVariable(value = "numberOne") String numberOne) {

        double resultado = Math.sqrt(convertToDouble(numberOne));
        return formatDouble(resultado);
    }

    private Double convertToDouble(String number) {
        if (Objects.isNull(number)) {
            throw new NumberFormatException("O valor informado não é um número");
        }
        String valorFormatado = formatarNumero(number);
        isValidNumber(valorFormatado);
        return Double.parseDouble(valorFormatado);
    }


    private void isValidNumber(String... number) throws NumberFormatException {
        for (String numero : number) {
            if (!numero.matches("[-+]?[0-9]*\\.?[0-9]+")) {
                throw new UnsuportedMathOperationException("Por favor informe um número válido");
            }
        }
    }

    private static String formatarNumero(String number) {
        return number.replace(",", ".");
    }
}
