package ModelandoContaBancaria;

public class ContaBancaria {
    private String titular;
    private String conta;
    private double saldo;
    public ContaBancaria(String titular, String conta) {
        this.titular = titular;
        this.conta = conta;
        this.saldo = 0;
    }
    public String getTitular() {
        return titular;
    }
    public String getConta() {
        return conta;
    }
    public double getSaldo() {
        return saldo;
    }

    public boolean sacar(double valor) {
        if(valor <= 0) {
            System.out.println("O valor nao pode ser negativo");
            return false;
        }
        else if(valor > this.saldo) {
            System.out.println("saldo insuficiente");
            return false;
        }else {
            this.saldo -= valor;
            System.out.println("Saque realizado, no valor de R$ " + valor );
            return true;
        }
    }
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Valor de R$ " + valor + " foi depositado");
        }else {
            System.out.println("O valor nao pode ser negativo");
        }
    }
    public void transferir(ContaBancaria contaDestino, double valor) {
        boolean realizarSaque = this.sacar(valor);
        if(realizarSaque){
            contaDestino.depositar(valor);
            System.out.println("Transferencia para " + contaDestino.titular + " no valor de R$ " + valor);
        }else {
            System.out.println("Nao foi possivel fazer a transferencia ");
        }
    }
    public String toString(){
        return "Titulo " + titular +
                " \nConta " + conta +
                " \nSaldo " + saldo;
    }
}
