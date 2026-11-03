package Pilhas.Exercicios;

import Pilhas.Pilha;

import java.util.Stack;

public class Exercicio5 {

    public static boolean verificarBalanceamento(String sequencia) {

        Pilha pilha = new Pilha(sequencia.length());

        char c = '\0';
        int i = 0;
        while (i < sequencia.length()) {

            c = sequencia.charAt(i);

            if (c == '{' || c == '[' || c == '(') {

                pilha.push(c);

            } else if (c == '}' || c == ']' || c == ')') {

                if (pilha.vazia()) {
                    return false;
                }

                char topo = (char) pilha.pop();

                if (c == '}' && topo != '{') {
                    return false;
                } else if (c == ']' && topo != '[') {
                    return false;
                } else if (c == ')' && topo != '(') {
                    return false;
                }
            }
            i++;
        }
        if (pilha.vazia()) {
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {


        String teste1 = "{ab}[cde]";
        System.out.println("Teste1: " + teste1);
        System.out.println("Resultado: " + (verificarBalanceamento(teste1) ? "Balanceado" : "Não balanceado"));
        System.out.println();

        String teste2 = "{ab[cd]efg}";
        System.out.println("Teste2: " + teste2);
        System.out.println("Resultado: " + (verificarBalanceamento(teste2) ? "Balanceado" : "Não balanceado"));
        System.out.println();


        String teste3 = "[abcde{efg]}";
        System.out.println("Teste3: " + teste3);
        System.out.println("Resultado: " + (verificarBalanceamento(teste3) ? "Balanceado" : "Não balanceado"));
        System.out.println();


        String teste4 = "apenasLetrasSemSimbolos";
        System.out.println("Teste4: " + teste4);
        System.out.println("Resultado: " + (verificarBalanceamento(teste4) ? "Balanceado" : "Não balanceado"));
        System.out.println();


        String teste5 = "{ab[cde]";
        System.out.println("Teste5: " + teste5);
        System.out.println("Resultado: " + (verificarBalanceamento(teste5) ? "Balanceado" : "Não balanceado"));
    }
}
