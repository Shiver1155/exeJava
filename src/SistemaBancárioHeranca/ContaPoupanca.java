package SistemaBancárioHeranca;

class ContaPoupanca extends Conta{
    public double taxaJuros;
    public ContaPoupanca(String agencia, String numero, String titular, double taxaJuros){
        super(agencia, numero, titular);
        this.taxaJuros = taxaJuros;
    }public void renderJuros(){
        double juros = this.saldo * taxaJuros;
        this.saldo += juros;
        System.out.println("Rendeu: R$" + juros + " de juros na conta de: " + this.titular );
    }
    @Override
    public void cobrarTaxaMensal(){
        System.out.println("Conta poupanca isenta de taxa mensal. ");
    }
}