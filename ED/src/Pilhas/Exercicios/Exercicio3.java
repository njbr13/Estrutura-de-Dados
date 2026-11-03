package Pilhas.Exercicios;

import java.util.Vector;

public class Exercicio3<T> {

    private int n;
    private Vector<T> vector;
    private int topo1;
    private int topo2;

    public Exercicio3(int tamanho) {
        this.n = tamanho;
        this.vector = new Vector<>();
        this.vector.setSize(tamanho);
        this.topo1 = -1;
        this.topo2 = this.n;
    }

    public boolean push1(T elemento) {

        if (topo1 + 1 != topo2) {
            topo1++;
            vector.set(topo1, elemento);
            return true;
        } else {
            System.out.println("Pilha Cheia. O vetor estourou!");
            return false;
        }
    }

    public boolean push2(T elemento) {

        if (topo2 - 1 != topo1) {
            topo2--;
            vector.set(topo2, elemento);
            return true;
        } else {
            System.out.println("Pilha Cheia. O vetor estourou!");
            return false;
        }
    }

    public T pop1() {
        if (topo1 != -1) {
            T elemento = vector.get(topo1);
            topo1--;
            return elemento;
        } else {
            System.out.println("Pilha 1 Vazia");
            return null;
        }
    }

    public T pop2() {
        if (topo2 != n) {
            T elemento = vector.get(topo2);
            topo2++;
            return elemento;
        } else {
            System.out.println("Pilha 2 Vazia");
            return null;
        }
    }


    public static void main(String[] args) {
        Exercicio3<Integer> duasPilhas = new Exercicio3<>(5);

        System.out.println("Inserindo elemento: ");
        duasPilhas.push1(10);
        duasPilhas.push1(20);
        duasPilhas.push1(30);

        duasPilhas.push2(90);
        duasPilhas.push2(80);
        System.out.println("Elementos inseridos.");

        System.out.println("Tentando inserir em vetor já cheio:");
        duasPilhas.push1(40);
        duasPilhas.push2(70);
    }
}