package CatalogoDeFilme;

public class Streaming {
    public static void main(String[] args) {
        Diretor nolah = new Diretor("Christopher Nolah");

        Filme interestelar = new Filme("Interestelar", 2014, nolah);

        Catalogo meuFilme = new Catalogo();
        meuFilme.adicionarFilme(interestelar);

        meuFilme.listarFilme();

    }
}
