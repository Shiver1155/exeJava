package CatalogoDeFilme;

public class Filme {
    private String titulo;
    private int anoDeLancamento;
    private Diretor diretor;
    public Filme(String titulo, int anoDeLancamento, Diretor diretor){
        this.titulo = titulo;
        this.anoDeLancamento = anoDeLancamento;
        this.diretor = diretor;
    }
    public Diretor getDiretor() {
        return diretor;
    }
    public String getTitulo() {
        return titulo;
    }
    public void exibirFichaTecnica() {
        System.out.println("=".repeat(20));
        System.out.println("Filme: " + this.titulo);
        System.out.println("Ano: " + this.anoDeLancamento);
        System.out.println("Diretor: " + diretor.getNome());
    }
}
