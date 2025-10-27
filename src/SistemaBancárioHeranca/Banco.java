package SistemaBancárioHeranca;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Banco {
    private Map<String, Conta> contas;
    public Banco(){
        this.contas = new HashMap<>();
    }
    public void adicionarConta(Conta conta){
        String numeroDaConta = conta.getNumero();
        this.contas.put(numeroDaConta, conta);
        System.out.println("Contas " + numeroDaConta +
                " de " + conta.getTitular() + " adicionada ao banco");
    }
    public Conta buscarContas(String numeroDaConta){
        return this.contas.get(numeroDaConta);
    }
    public void listarContas(){
        System.out.println("\n--- LISTA DE CONTAS DO BANCO---");
        for(Conta conta : this.contas.values()){
            System.out.println("Titular: " + conta.getTitular() + " | Conta: " +
                    conta.getNumero() + " | Saldo: " + conta.getSaldo());
        }
        System.out.println("-".repeat(20));
    }
    public void aplicarTaxaMensalEmTodasAsContas(){
        System.out.println("\n--- Aplicando Taxa Mensal em Todas as Contas");

        this.contas.values().stream().forEach(conta ->
        {try {
            conta.cobrarTaxaMensal();
        }catch (Exception e){
            System.out.println("Falha ao cobrar taxa " + e.getMessage());
        }
        });
        System.out.println("=".repeat(20));
    }
    public List<Conta> getContasComSaldoNegativo(){
        List<Conta> contasNegativas = this.contas.values().stream()
                .filter(conta -> conta.getSaldo() < 0)
                .collect(Collectors.toList());
        return contasNegativas;
    }
    public List<String> getTitularesComSaldoAcimaDe(double valor){
        List<String> titulares = this.contas.values().stream()
                .filter(conta -> conta.getSaldo() > valor)
                .map(conta -> conta.getTitular())
                .collect(Collectors.toList());
        return titulares;
    }
}
