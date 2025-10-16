package ModelandoCarro;

class Garagem {
    public static void main(String[] args) {
        Carro meuCarro = new Carro("Fiat", "Palio", 2009, "prata");
        meuCarro.acelerar(30);
        meuCarro.frear(10);
        meuCarro.desligado();
    }
}
