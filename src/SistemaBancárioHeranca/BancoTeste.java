package SistemaBancárioHeranca;


import Investimento.Cliente;
import Investimento.Investivel;

import java.util.ArrayList;

class BancoTeste{
    public static void main(String[] args) {
        ArrayList<Investivel> investivelLista = new ArrayList<>();
        ArrayList<Conta> listaBanco = new ArrayList<>();
        ContaCorrente cc = new ContaCorrente("123-4", "12345-6"
                , "Ana Rodriguez", 1000);
        ContaPoupanca cp = new ContaPoupanca("908-3", "23445-9",
                "Joao Silva",0.02);
        Cliente clienteAna = new Cliente("Ana Rodriguez", "111.222.333-44");

        investivelLista.add(cc);
        investivelLista.add(clienteAna);
        cc.depositar(5000);
        cp.depositar(1000);

        listaBanco.add(cc);
        listaBanco.add(cp);
        try {
            cc.sacar(1100);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro ao sacar: " + e.getMessage());
        }
        try{
            System.out.println("\n=== Teste de saque ===");
            cp.sacar(1100);
            System.out.println("Saque realizado com sucesso.");
        }catch (SaldoInsuficienteException e){
            System.out.println("Falha ao sacar da Poupanca " + e.getMessage());
        }

        for(Conta a : listaBanco){
            System.out.println("=".repeat(20));
            if(a instanceof ContaPoupanca){
                System.out.println("Conta Poupanca");
                ContaPoupanca contaPoupancaDaLista = (ContaPoupanca) a;
                contaPoupancaDaLista.renderJuros();
            }
            else if(a instanceof ContaCorrente) {
                System.out.println("Conta Corrente");
            }
            a.cobrarTaxaMensal();
            System.out.println("Agencia: " + a.agencia);
            System.out.println("Numero: " + a.numero);
            System.out.println("Titular: " + a.titular);
            System.out.println("Saldo: " + a.saldo);

        }
        System.out.println("=".repeat(20));
        for(Investivel a : investivelLista){
            try {
                a.investir(50000.00);
                System.out.println("Investimento realizado!");
            } catch (SaldoInsuficienteException e) {
                System.out.println("Falha ao investir: " + e.getMessage());
            }

        }
        System.out.println("\n Saldo final da conta " +
                cc.getTitular() + " R$" + cc.getSaldo());

    }
}