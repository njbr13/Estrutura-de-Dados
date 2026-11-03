package Pilhas.Exercicios;

import Pilhas.Pilha;
import Pilhas.PilhaGenerica;

import java.util.HashSet;
import java.util.Set;

public class Exercicio8 {

    public static int contarParesUnicos(int[] sequencia) {

        PilhaGenerica<Integer> pilhaGenerica = new PilhaGenerica<>(sequencia.length);
        int valor = 0;
        Integer valorPop = 0;
        int contadorPares = 0;

        for(int i = 0; i < sequencia.length;i++) {
            valor = sequencia[i];

            while (!pilhaGenerica.vazia() && (valor > pilhaGenerica.retornaTopo())) {
                valorPop = pilhaGenerica.pop();
                System.out.println("Par Formado: " + '(' + valor + ',' + valorPop + ')');
                contadorPares++;
            }

            if (!pilhaGenerica.vazia()) {
                System.out.println("Par: (" + pilhaGenerica.retornaTopo() + ", " + valor + ")");
                contadorPares++;
            }

            pilhaGenerica.push(valor);

        }
        return contadorPares;

    }

    public static void main(String[] args) {


        int[] sequencia = {1, 2, 3, 4, 5};

        System.out.println("Sequência original: [1, 2, 3, 4, 5]");

        int totalPares = contarParesUnicos(sequencia);

        System.out.println("Total de pares únicos que queremos: " + totalPares);
        System.out.println("Esperado: 4");
    }
}
