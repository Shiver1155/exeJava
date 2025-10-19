package SistemaBancárioHeranca;



class ContaCorrente extends Conta{
    private double limiteChequeEspecial;
    public ContaCorrente(String agencia, String numero, String titular, double limiteChequeEspecial){
        super(agencia,numero, titular);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public boolean sacar(double valor) {
        if(valor <= 0 ){
            System.out.println("Valor invalido para saque");
            return false;
        }
        if (valor > 0 && (this.saldo + limiteChequeEspecial) >= valor){
            this.saldo -= valor;
            System.out.println("Saque da conta limite " + "Saldo "
                    + saldo + " Cheque Especial " + this.limiteChequeEspecial);
            return true;
        }else {
            System.out.println("Saldo insuficiente.");
            return false;}
    }
}