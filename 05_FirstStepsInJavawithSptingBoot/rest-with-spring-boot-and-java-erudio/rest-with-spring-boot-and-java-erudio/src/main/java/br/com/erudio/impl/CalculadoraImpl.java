package br.com.erudio.impl;

import br.com.erudio.service.CalculadoraService;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraImpl implements CalculadoraService {
    @Override
    public Double somar(Double numberOne, Double numberTwo) {
        return Double.sum(numberOne, numberTwo);
    }

    @Override
    public Double subtrair(Double numberOne, Double numberTwo) {
        return Double.sum(numberOne, numberTwo * (-1));
    }

    @Override
    public Double dividir(Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }

    @Override
    public Double multiplicar(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }

    @Override
    public Double media(Double numberOne, Double numberTwo) {
        return (numberOne + numberTwo) / 2;
    }

    @Override
    public Double raizQuadrada(Double number) {
        return Math.sqrt(number);
    }

}
