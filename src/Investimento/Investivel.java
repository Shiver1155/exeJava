package Investimento;

import SistemaBancárioHeranca.SaldoInsuficienteException;

public interface Investivel {
    void investir(double valor) throws SaldoInsuficienteException;
}
