package Fila.Exercicios;


import java.util.Vector;

public class Fila3 {

    public static class Fila<T> {

        protected int ini;
        protected Vector<T> vetor;
        protected int n;
        protected int tamanho;

         public Fila(){
             this.ini = 0;
             this.n = 0;
             this.tamanho = 10;
             this.vetor = new Vector<T>(tamanho);
             this.vetor.setSize(tamanho);
         }

         public Fila(int tamanho){
             this.ini = 0;
             this.n = 0;
             this.tamanho = tamanho;
             this.vetor = new Vector<T>(tamanho);
             this.vetor.setSize(tamanho);
         }


         public boolean vazia()
         {
             return (n == 0);
         }

         public boolean cheia()
         {
             return (n == tamanho);
         }

         //Retiramos o elemento do in�cio da fila
         public T remove()
         {
             T elemento = null;

             if (!this.vazia())
             {
                 elemento = vetor.get(ini);
                 vetor.set(ini,null);
                 ini = (ini + 1) % tamanho;
                 n--;
             }

             return elemento;
         }

         //Inserimos o elemento no final da fila
         public boolean insere(T elemento) {
             int fim;

             if ( !cheia() ) {
                 fim = (ini + n) % tamanho;
                 vetor.set(fim, elemento);
                 n++;
                 return true;
             }
             else
                 return false;
         }
         
    }


}