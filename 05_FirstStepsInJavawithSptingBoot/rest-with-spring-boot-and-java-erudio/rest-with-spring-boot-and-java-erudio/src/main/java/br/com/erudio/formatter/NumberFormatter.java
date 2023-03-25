package br.com.erudio.formatter;

import java.text.DecimalFormat;

public class NumberFormatter {
    public static String replaceVirgula(String number) {
        return number.replace(",", ".");
    }

    public static String formatDouble(double resultado) {
        return new DecimalFormat("#,##0.00").format(resultado);
    }
}
