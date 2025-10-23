package Investimento;



public class Cliente implements Investivel{
    private String nome;
    private String cpf;
    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    @Override
    public void investir(double valor) {

        System.out.println("Investimento de R$" + valor +
                " realizado pela carteira pessoal do cliente " + this.nome);
    }
}
