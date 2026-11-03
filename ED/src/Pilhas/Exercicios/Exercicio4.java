package Pilhas.Exercicios;

import Pilhas.PilhaGenerica;

import java.util.Vector;

public class Exercicio4 {


    public static <T> void removerObjeto(PilhaGenerica<T> pilha, T alvo) {

        T elemento;

        PilhaGenerica<T> pilhaAuxiliar = new PilhaGenerica<>(100);

        int i = 0;
        while(!pilha.vazia()){

            elemento = pilha.pop();
            if(!alvo.equals(elemento)){
                pilhaAuxiliar.push(elemento);
            }
            i++;
        }

        while (!pilhaAuxiliar.vazia()){
            elemento = pilhaAuxiliar.pop();
            pilha.push(elemento);
        }


    }


    public static void main(String[] args) {
        PilhaGenerica<String> minhaPilha = new PilhaGenerica<>(10);

        minhaPilha.push("A"); // Base (Fundo da pilha)
        minhaPilha.push("B");
        minhaPilha.push("C"); // ESSE É O NOSSO ALVO!
        minhaPilha.push("D");
        minhaPilha.push("E"); // Topo da pilha

        System.out.println("--- ANTES DA REMOÇÃO ---");
        System.out.println("A pilha foi preenchida na ordem (Fundo -> Topo): A, B, C, D, E");
        System.out.println("O nosso alvo para remover é a letra 'C'.\n");

        removerObjeto(minhaPilha, "C");

        System.out.println("--- DEPOIS DA REMOÇÃO ---");
        System.out.println("Desempilhando o que sobrou (A ordem de saída tem que ser E, D, B, A):");

        while (!minhaPilha.vazia()){
            System.out.println(minhaPilha.pop());
        }



    }
}
