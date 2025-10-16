package ProdutoDeLoja;


public class Produto {
    private int codigo;
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;

    public Produto(int codigo, String nome, double preco){
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = 0;
    }

    public int getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    public double getPreco() {
        return preco;
    }
    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setPreco(double preco) {
        if(preco < 0){
           System.out.println("Erro: preco nao pode ser negativo");
        }else {
            this.preco = preco;
        }
    }
    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
    public void adicionarEstoque(int quantidade) {
        if (quantidade > 0) {
            this.quantidadeEmEstoque += quantidade;
            System.out.println("Adicionado " + quantidade + " no estoque");
        }else {
            System.out.println("Valor nao pode ser negativo");
        }
    }public void removerEstoque(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Erro: Quantidade deve ser positiva");
        } else if (quantidade > this.quantidadeEmEstoque) {
            System.out.println("Erro: Estoque insuficiente. Temos apenas " + this.quantidadeEmEstoque);
        }else {
            this.quantidadeEmEstoque -= quantidade;
            System.out.println(quantidade + " unidade de " + this.nome + " removida do estoque");
        }
    }
}
