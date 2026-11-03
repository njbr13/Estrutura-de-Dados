package ListaEncadeada.Exercicios.Exercicio2;

public class Main {

    public static void main(String[] args) {

        // Montando a estrutura "Jogos"
        Diretorio jogos = new Diretorio("Jogos");
        jogos.insere(new Arquivo("Campo Minado"));
        jogos.insere(new Arquivo("Paciência"));
        jogos.insere(new Arquivo("World of Warcraft"));

        // Montando a estrutura "Faculdade" e seus subdiretórios
        Diretorio faculdade = new Diretorio("Faculdade");

        Diretorio edd1 = new Diretorio("EDD1");
        edd1.insere(new Arquivo("Lista4.pdf"));

        Diretorio edd2 = new Diretorio("EDD2");
        edd2.insere(new Arquivo("ProjetoFinal.zip"));

        faculdade.insere(edd1);
        faculdade.insere(edd2);
        faculdade.insere(new Diretorio("AA"));
        faculdade.insere(new Arquivo("TPD"));

        // Montando o diretório Raiz que engloba tudo
        Diretorio raiz = new Diretorio("Meu Computador");
        raiz.insere(jogos);
        raiz.insere(faculdade);

        // O comando único exigido pelo PDF que dispara toda a reação em cadeia
        System.out.println(raiz);
    }
}