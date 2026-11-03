package Pilhas.Exercicios;

import Pilhas.Pilha;

public class Exercicio2 {

    public boolean validacao(String palavra){


        if(palavra == null || palavra.isEmpty()){
            return false;
        }

        boolean achouC = false;
        boolean achouD = false;
        Pilha pilha = new Pilha(palavra.length());
        int i = 0;
        char c;
        int contx = 0, conty = 0, cont = 0;

        while(i < palavra.length()){
            c = palavra.charAt(i);

            if(c != 'A' && c != 'B' && c != 'C' && c != 'D'){
                return false;
            }

            if(achouD){

                if(achouC && (contx == conty && contx == cont) && pilha.vazia()){
                    achouC = false;
                    contx = 0;
                    conty = 0;
                    cont = 0;
                    achouD = false;
                } else {
                    return false;
                }
            }

            if(!achouC){

                if(c == 'D') {
                    return false;
                }

                if(c != 'C'){
                    pilha.push(c);
                    contx++;
                } else {
                    achouC = true;
                }
            } else {

                if (c == 'C') {
                    return false;
                }

                if(c == 'D'){
                    achouD = true;
                } else {

                    if(!pilha.vazia()){
                        if(c == pilha.pop()){
                            conty++;
                        }
                        cont++;
                    } else {

                        cont++;
                    }
                }
            }
            i++;
        }


        if(!achouD && achouC && contx == conty && contx == cont && pilha.vazia()){
            return true;
        }

        return false;
    }
}