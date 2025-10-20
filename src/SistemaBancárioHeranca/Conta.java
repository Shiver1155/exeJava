package SistemaBancárioHeranca;

public abstract class Conta{
    protected String agencia;
    protected String numero;
    protected String titular;
    protected double saldo;
    public Conta(String agencia, String numero, String titulo){
        this.agencia = agencia;
        this.numero = numero;
        this.titular = titulo;
        this.saldo = 0;
    }
    public String getAgencia() {
        return agencia;
    }
    public String getNumero() {
        return numero;
    }
    public String getTitular() {
        return titular;
    }
    public double getSaldo() {
        return saldo;
    }
    public void depositar(double valor) {
        if(valor > 0){
            this.saldo += valor;
            System.out.println("Valor de R$" + valor + " foi depositado");
        }else {
            System.out.println("Valor nao pode ser negativo ");
        }
    }public boolean sacar(double valor){
        if(valor <= 0){
            System.out.println("Valor nao pode ser negativo");
            return false;
        }else if(this.saldo < valor){
            System.out.println("Saldo insuficiente");
            return false;
        }
        else {
            this.saldo -= valor;
            System.out.println("Valor de R$" + valor + " foi sacado");
            return true;
        }
    }
    public abstract void cobrarTaxaMensal();
}