package Pilhas;

public class Pilha2 {

    private int n;
    private int vetor[];
    private int topo;
    private int quantidadePares;

    public Pilha2(){
        n = 10;
        vetor = new int[n];
        topo = -1;
        quantidadePares = 0;
    }

    public Pilha2(int tamanho){
        n = tamanho;
        vetor = new int[tamanho];
        topo = -1;
        quantidadePares = 0;
    }

    public boolean vazia(){
        return topo == -1;
    }

    public boolean cheia(){
        return topo == n - 1;
    }

    public int pop(){

        int c = Integer.MIN_VALUE;

        if(!this.vazia()){
            c = vetor[topo];
            topo--;

            if(c % 2 == 0){
                quantidadePares--;
            }
        }
        else {
            System.out.println("Pilha vazia");
        }
        return c;
    }

    public boolean push(int elemento){

        if(!this.cheia()){
            vetor[++topo] = elemento;

            if(elemento % 2 == 0){
                quantidadePares++;
            }
            return true;

        }else {
            System.out.println("Pilha cheia");
            return false;
        }
    }

    public int peek(){

        int c = Integer.MIN_VALUE;
        if(!this.vazia()){
            c = vetor[topo];
        }
        else {
            System.out.println("Pilha vazia");
        }
        return c;
    }

    public int getQuantidadePares() {
        return quantidadePares;
    }
}