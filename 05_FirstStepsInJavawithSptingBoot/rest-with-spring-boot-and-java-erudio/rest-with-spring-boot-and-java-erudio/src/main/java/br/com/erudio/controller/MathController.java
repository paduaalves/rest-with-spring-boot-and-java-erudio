package br.com.erudio.controller;

import br.com.erudio.exception.UnsuportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class MathController {


    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private Double convertToDouble(String number) throws Exception {
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
