package ModelandoContaBancaria;


import java.util.ArrayList;

public class Banco {
    public static void main(String[] args) {
        ArrayList<ContaBancaria> listaDeConta = new ArrayList<>();
        ContaBancaria contaAna = new ContaBancaria("Ana Rodriguez", "123-4");
        ContaBancaria contaJoao = new ContaBancaria("Joao Silva", "567-8");

        listaDeConta.add(contaAna);
        listaDeConta.add(contaJoao);

        contaAna.sacar(-100);
        contaAna.depositar(100);


        contaAna.transferir(contaJoao, 100);

        for(ContaBancaria a : listaDeConta){
            System.out.println("=".repeat(20));
            System.out.println(a);
        }
    }
}
