package ListaEncadeada;

public class ListaEncadeadaSimples {

    public class Elo {
        public int dado;
        public Elo prox;

        public Elo(int dado) {
            this.dado = dado;
            this.prox = null;
        }
    }

    protected Elo prim;

    public ListaEncadeadaSimples() {
        this.prim = null;
    }

    public void insereInicio(int valor) {
        Elo novo = new Elo(valor);
        novo.prox = prim;
        prim = novo;
    }

    public void insereFim(int valor) {
        Elo novo = new Elo(valor);

        if (prim == null) {
            prim = novo;
            return;
        }

        Elo p = prim;
        while (p.prox != null) {
            p = p.prox;
        }

        p.prox = novo;
    }

    public void imprimir() {
        Elo p = prim;
        while (p != null) {
            System.out.print(p.dado + " -> ");
            p = p.prox;
        }
        System.out.println("null");
    }
    public void remover(int valor) {

        // Cenário 1: A lista está totalmente vazia. Não há nada a fazer.
        if (prim == null) {
            return;
        }

        // Cenário 2: O valor que queremos remover é logo o primeiro elo da corrente!
        if (prim.dado == valor) {
            // A âncora 'prim' solta este elo e passa a segurar logo o segundo.
            prim = prim.prox;
            return;
        }

        // Cenário 3: O valor está no meio ou no fim da corrente
        Elo ant = null;
        Elo p = prim;

        // Os viajantes começam a caminhar.
        // O laço gira enquanto o 'p' não cair no abismo (null) E não encontrar o valor
        while (p != null && p.dado != valor) {
            ant = p;       // O 'ant' assume a posição atual do 'p'
            p = p.prox;    // O 'p' dá um passo em frente
        }

        // Se o laço terminou e o 'p' é null, percorremos a corrente toda e o valor não estava lá
        if (p == null) {
            return;
        }

        // A MAGIA DA REMOÇÃO: O elo anterior ignora o 'p' e engata diretamente no elo da frente
        ant.prox = p.prox;
    }

    public boolean busca(int valor) {
        Elo p = prim;

        while (p != null) {
            if (p.dado == valor) {
                return true;
            }
            p = p.prox;
        }

        return false;
    }
}
