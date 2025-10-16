package ProdutoDeLoja;

import java.util.ArrayList;

public class Estoque {
    public static void main(String[] args) {
        ArrayList<Produto> listaDeEstoque = new ArrayList<>();
        Produto produto = new Produto(1,"Banana", 2.99);

        listaDeEstoque.add(produto);
        produto.adicionarEstoque(100);
        produto.removerEstoque(50);
        if(produto.getQuantidadeEmEstoque() > 0)
            for (Produto a : listaDeEstoque) {
                System.out.println("=".repeat(20));
                System.out.println("Codigo: " + a.getCodigo());
                System.out.println("Nome: " + a.getNome());
                System.out.println("Preco: " + a.getPreco());
                System.out.println("Quantidade em Estoque: " + a.getQuantidadeEmEstoque());
        }
        else {
            System.out.println("Estoque esta vazio");
        }
    }

}
