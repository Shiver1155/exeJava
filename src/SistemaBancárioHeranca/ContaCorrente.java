package SistemaBancárioHeranca;


import Investimento.Investivel;

class ContaCorrente extends Conta implements Investivel {
    private double limiteChequeEspecial;
    public ContaCorrente(String agencia, String numero, String titular, double limiteChequeEspecial){
        super(agencia,numero, titular);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        if(valor <= 0 ){
            System.out.println("Valor invalido para saque");
            return;
        }
        if ((this.saldo + limiteChequeEspecial) < valor){
            throw new SaldoInsuficienteException("Saldo insuficiente com cheque especial");
        }

        this.saldo -= valor;
        System.out.println("Saque da conta limite " + "Saldo "
                + saldo + " Cheque Especial " + this.limiteChequeEspecial);

    }
    @Override
    public void cobrarTaxaMensal(){
        double taxa = 15.00;
        if(this.saldo + this.limiteChequeEspecial >= taxa){
            this.saldo -= taxa;
            System.out.println("Taxa mensal de R$" + taxa + " cobrada da conta " + this.numero);
        }else {
            System.out.println("Saldo insuficiente para cobrar taxa mensal na conta " + this.numero);
        }
    }@Override
    public void investir(double valor) throws SaldoInsuficienteException {
        if (valor <= 0) {
            System.out.println("Valor invalido para investimento.");
            return;
        }
        if (this.saldo <= valor) {
            throw new SaldoInsuficienteException("Saldo insuficiente para investimento");
        }

        this.saldo -= valor;
        System.out.println("Investimento de R$" + valor +
                " realizado com sucesso a partir ds conta " + this.numero);

    }
}