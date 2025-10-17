package CatalogoDeFilme;

import java.util.ArrayList;

public class Catalogo {
    ArrayList<Filme> listaDeFilme = new ArrayList<>();

    public void adicionarFilme(Filme filme){
        listaDeFilme.add(filme);
    }

    public void listarFilme(){
        for(Filme a : listaDeFilme) {
            a.exibirFichaTecnica();
        }
    }
}
