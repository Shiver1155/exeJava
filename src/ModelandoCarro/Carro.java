package ModelandoCarro;

class Carro{
    public String marca;
    public String modelo;
    public int ano;
    public String cor;
    public int velocidadeAtual;
    public Carro(String marca, String modelo, int ano, String cor){
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.velocidadeAtual = 0;
    }
    public void ligar(int velocidade){
        System.out.println("O carro esta ligado");
    }
    public void desligado() {
        this.velocidadeAtual = 0;
        System.out.println("O ModelandoCarro.Carro esta deligado");
    }
    public void acelerar(int aumento) {
        this.velocidadeAtual += aumento;
        System.out.println("Acelerando...velocidade atual " + this.velocidadeAtual + "km/h");
    }
    public void frear(int reducao) {
        this.velocidadeAtual -= reducao;
        System.out.println("Freando...Velocidade " + this.velocidadeAtual + "km/h");
    }
        }
class Garagem{
    public static void main(String[] args) {
        Carro meuCarro = new Carro("Fiat", "Palio",2009, "prata");
        meuCarro.acelerar(30);
        meuCarro.frear(10);
        meuCarro.desligado();
    }
}