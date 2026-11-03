package Fila.Exercicios;

import Fila.filaCircularSimples.Fila;

public class Exercicio5 {




   public static void gerarFilaBinario(int n){


       for(int j = 1; j <= n;j++){

           Fila filaBinaria = new Fila(8);

           int resto = j;
           boolean comecou = false;


           for(int i = 7; i >= 0;i--){

               double bi = Math.pow(2, i);

               if(resto >= bi){
                   filaBinaria.insere(1);
                   resto -= bi;
                   comecou = true;
               }else {
                   if(comecou){
                       filaBinaria.insere(0);
                   }

               }

           }

           System.out.print("Número " + j + " em Binário: ");
           while (!filaBinaria.vazia()) {
               System.out.print(filaBinaria.remove());
           }
           System.out.println();

       }

   }

   public static void main(String[] args){

       int n = 16;

       gerarFilaBinario(n);
   }


}