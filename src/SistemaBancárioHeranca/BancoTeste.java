package SistemaBancárioHeranca;


import Investimento.Cliente;
import Investimento.Investivel;

import java.util.ArrayList;
import java.util.List;

class BancoTeste{
    public static void main(String[] args) throws SaldoInsuficienteException {

        Banco meuBanco = new Banco();
        ContaCorrente cc = new ContaCorrente("123-4", "12345-6"
                , "Ana Rodriguez", 1000);
        ContaPoupanca cp = new ContaPoupanca("908-3", "23445-9",
                "Joao Silva", 0.02);
        Cliente clienteAna = new Cliente("Ana Rodriguez", "111.222.333-44");


        cc.depositar(5000);
        cp.depositar(11000);
        cc.sacar(5000.00);

        meuBanco.adicionarConta(cc);
        meuBanco.adicionarConta(cp);

        meuBanco.listarContas();

        System.out.println("\n--- Operacao de Teste (Busca por map) ---");
        String contaParaBuscar = "12345-6";
        Conta contaAna = meuBanco.buscarContas(contaParaBuscar);
        if (contaAna != null) {
            System.out.println("Conta encontrada! Titular: " + contaAna.getTitular());

            contaAna.depositar(500);
            try {
                contaAna.sacar(200.00);
            } catch (SaldoInsuficienteException e) {
                System.out.println("ERRO: " + e.getMessage());
            }
        } else {
            System.out.println("Conta " + contaParaBuscar + " nao encontrada");
        }
        Conta contaFantasma = meuBanco.buscarContas("999-9");
        System.out.println("Conta fantasma encontrada?" +
                " " + (contaFantasma == null ? "NAO" : "SIM"));

        try {
            cc.sacar(1100);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro ao sacar: " + e.getMessage());
        }
        try {
            System.out.println("\n=== Teste de saque ===");
            cp.sacar(1100);
            System.out.println("Saque realizado com sucesso.");
        } catch (SaldoInsuficienteException e) {
            System.out.println("Falha ao sacar da Poupanca " + e.getMessage());
        }

        meuBanco.aplicarTaxaMensalEmTodasAsContas();
        System.out.println("\n--- Contas com Saldo Negativos ---");
        List<Conta> contasDevedoras = meuBanco.getContasComSaldoNegativo();

        contasDevedoras.stream().forEach(conta -> {
            System.out.println("Devedor: " + conta.getTitular() +
                    " Saldo: " + conta.getSaldo());
        });

        System.out.println("\n--- Clientes com mais de 1000 Reais");
        List<String> nomesRicos = meuBanco.getTitularesComSaldoAcimaDe(1000.00);

        nomesRicos.stream().forEach(nome -> System.out.println("Clientes VIP " + nome));

        System.out.println("\n--- Saldo Final (Apos Taxas");
        meuBanco.listarContas();
    }
}