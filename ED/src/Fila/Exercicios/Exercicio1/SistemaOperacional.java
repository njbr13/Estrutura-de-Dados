package Fila.Exercicios.Exercicio1;

import java.util.Random;

public class SistemaOperacional extends FilaDeProcesso {

    public SistemaOperacional(int tam){
        super(tam);
    }

    public boolean inserirProcesso() {

        int qtdProcesso = 5;
        Random random = new Random();
        int cont = 0;

        for(int i = 0; i < qtdProcesso;i++){
            Processo processo = new Processo();
            processo.tempoEspera = random.nextInt(5);
            processo.id = cont;
            insere(processo);
            cont++;
        }
        return true;
    }


    public Processo removerProcesso() {

        int posicao = ini;
        int maiorTempo = vetor[posicao].tempoEspera;
        int indiceMaior = ini;

        for(int i = 0;i < n;i++){

            if(vetor[posicao].tempoEspera > maiorTempo){
                maiorTempo = vetor[posicao].tempoEspera;
                indiceMaior = posicao;

            }
            posicao = (posicao + 1) % tamanho;
        }

        Processo processoRemovido = vetor[indiceMaior];


        int buraco = indiceMaior;
        int posicaoRemovida = indiceMaior;
        int fim = (ini + n - 1) % tamanho;

        while(posicaoRemovida != fim){

            buraco = (posicaoRemovida + 1) % tamanho;
            vetor[posicaoRemovida] = vetor[buraco];

            posicaoRemovida = buraco;


        }

        vetor[posicaoRemovida] = null;
        n--;
        return processoRemovido;

    }

    public void imprimirLista(){

        int processo = ini;
        if(!vazia()){
            for(int i = 0; i < n;i++){
                System.out.println("Processo: "+vetor[processo].tempoEspera+ "NumeroID: "+vetor[processo].id);
                processo = (processo + 1) % tamanho;
            }
        }
    }
}