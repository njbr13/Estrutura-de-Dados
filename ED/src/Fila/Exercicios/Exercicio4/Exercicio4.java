package Fila.Exercicios.Exercicio4;

import Fila.filaCircularDupla.FilaDupla;
import Fila.filaCircularSimples.Fila;

public class Exercicio4 {

    protected int ini;
    protected int [] vetor;
    protected int tamanho;
    protected int n;

    public Exercicio4(){
        this.ini = 0;
        this.tamanho = 10;
        this.vetor = new int[tamanho];
        this.n = 0;
    }

    public Exercicio4(int tamanho){
        this.ini = 0;
        this.tamanho = tamanho;
        this.vetor = new int[tamanho];
        this.n = 0;
    }

    public boolean isCheia(){
        return n == tamanho ? true : false;
    }

    public boolean isVazia(){
        return n == 0 ? true : false;
    }

    public boolean inserirNormal(int elemento){

        int fim;

        if(!isCheia()){
            fim = (ini + n) % tamanho;
            vetor[fim] = elemento;
            n++;
            return true;
        }
        return false;
    }

    public int removerNormal(){

        int elemento = 0;
        if(!isVazia()){
            elemento = vetor[ini];
            ini = (ini + 1) % tamanho;
            n--;
        }
        return elemento;
    }

    public static FilaDupla converterFila(Fila4 originalSimples){

        FilaDupla filaDupla = new FilaDupla(originalSimples.tamanho);

        while(!originalSimples.vazia()) {
            filaDupla.insere(originalSimples.remove());
        }

        return filaDupla;
    }
}