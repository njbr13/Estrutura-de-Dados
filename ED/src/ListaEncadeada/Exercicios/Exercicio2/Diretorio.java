package ListaEncadeada.Exercicios.Exercicio2;

public class Diretorio implements Elemento {

    private String nome;
    protected Elo prim;

    protected class Elo {
        protected Elemento dado;
        protected Elo prox;

        public Elo(Elemento dado) {
            this.dado = dado;
            this.prox = null;
        }
    }

    public Diretorio(String nome) {
        this.nome = nome;
        this.prim = null;
    }

    // O método recebe a Interface, permitindo inserir tanto Arquivo quanto Diretorio
    public void insere(Elemento novoItem) {
        Elo q = new Elo(novoItem);
        Elo p = prim;

        if (prim == null) {
            prim = q;
        } else {
            while (p.prox != null) {
                p = p.prox;
            }
            p.prox = q;
        }
    }

    @Override
    public String imprimirRecursivo(String espacos) {
        // 1. Prepara a linha do próprio diretório
        String resultado = espacos + this.nome + "\n";

        if (prim == null) {
            return resultado + espacos + "   (Pasta Vazia)\n";
        }

        // 2. Percorre a lista encadeada
        Elo p = prim;
        while (p != null) {
            // 3. Concatena o resultado dos filhos, passando o "bastão" com mais 3 espaços
            resultado += p.dado.imprimirRecursivo(espacos + "   ");
            p = p.prox;
        }

        return resultado;
    }

    // Sobrescreve o comportamento padrão do Java para o System.out.println
    @Override
    public String toString() {
        return imprimirRecursivo(""); // Dispara a recursão com 0 espaços no início
    }
}