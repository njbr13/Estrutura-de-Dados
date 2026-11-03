package ListaEncadeada.Exercicios;

public class Exercicio1 {

    protected Elo prim;
    protected int qtdElementos;

    protected class Elo{
       protected int dado;
       protected Elo prox;

        public Elo(){
            this.prox = null;
        }

        public Elo(int dado){
            this.dado = dado;
            this.prox = null;
        }
    }


    public Exercicio1(){
        this.prim = null;
        this.qtdElementos = 0;
    }


    public void insere(int valor){

        Elo novo = new Elo(valor);
        novo.prox = prim;
        prim = novo;
        qtdElementos++;
    }

    public int tamanho(){
        return qtdElementos;
    }


}
