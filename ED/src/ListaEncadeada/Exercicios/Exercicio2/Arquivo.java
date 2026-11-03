package ListaEncadeada.Exercicios.Exercicio2;

public class Arquivo implements Elemento {

    private String nome;

    public Arquivo(String nome) {
        this.nome = nome;
    }

    @Override
    public String imprimirRecursivo(String espacos) {
        return espacos + this.nome + "\n";
    }
}