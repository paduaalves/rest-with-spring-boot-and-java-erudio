package br.com.erudio.converter;

import br.com.erudio.exception.UnsuportedMathOperationException;
import br.com.erudio.formatter.NumberFormatter;

import java.util.Objects;

public class DoubleConverter {

    public static Double convertToDouble(String number) {
        if (Objects.isNull(number)) {
            throw new NumberFormatException("O valor informado não é um número");
        }
        String valorFormatado = NumberFormatter.replaceVirgula(number);
        isValidNumber(valorFormatado);
        return Double.parseDouble(valorFormatado);
    }

    private static void isValidNumber(String... number) throws NumberFormatException {
        for (String numero : number) {
            if (!numero.matches("[-+]?[0-9]*\\.?[0-9]+")) {
                throw new UnsuportedMathOperationException("Por favor informe um número válido");
            }
        }
    }
}
