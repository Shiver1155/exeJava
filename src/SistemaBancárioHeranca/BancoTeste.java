package SistemaBancárioHeranca;


import java.util.ArrayList;

class BancoTeste{
    public static void main(String[] args) {
        ArrayList<Conta> listaBanco = new ArrayList<>();
        ContaCorrente cc = new ContaCorrente("123-4", "12345-6"
                , "Ana Rodriguez", 1000);
        ContaPoupanca cp = new ContaPoupanca("908-3", "23445-9",
                "Joao Silva",0.02);

        cc.depositar(1000);
        cp.depositar(1000);

        listaBanco.add(cc);
        listaBanco.add(cp);

        cc.sacar(1100);

        for(Conta a : listaBanco){
            System.out.println("=".repeat(20));
            if(a instanceof ContaPoupanca){
                System.out.println("Conta Poupanca");
                cp.renderJuros();
            }
            else if(a instanceof ContaCorrente) {
                System.out.println("Conta Corrente");
            }
            System.out.println("Agencia: " + a.agencia);
            System.out.println("Numero: " + a.numero);
            System.out.println("Titular: " + a.titular);
            System.out.println("Saldo: " + a.saldo);

        }

    }
}