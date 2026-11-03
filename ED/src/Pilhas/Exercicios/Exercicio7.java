package Pilhas.Exercicios;

import Pilhas.Pilha;
import Pilhas.PilhaGenerica;
import Pilhas.Posfixada;



public class Exercicio7 {


    public static boolean converterInfixaParaPosfixada(String infixa) {

        Pilha pilhaOperador = new Pilha(infixa.length());
        PilhaGenerica<Integer> pilhaNumerica = new PilhaGenerica<>(infixa.length());
        Posfixada posfixada = new Posfixada(infixa.length());

        char c = '\0';
        char operador = '\0';
        for (int i = 0;i < infixa.length();i++){

            c = infixa.charAt(i);

            if (c >= '0' && c <= '9') {
                int numero = 0;

                while (i < infixa.length() && infixa.charAt(i) >= '0' && infixa.charAt(i) <= '9') {
                    numero = (numero * 10) + Character.getNumericValue(infixa.charAt(i));
                    i++;
                }

                pilhaNumerica.push(numero);
                i--;
            }
            else if(posfixada.seteOperador(c)){
                pilhaOperador.push(c);
            }

            else if(c == ')'){
                Integer operando1, operando2, temp = 0;

                operando1 = pilhaNumerica.pop();
                operando2 = pilhaNumerica.pop();

                operador = pilhaOperador.pop();
                switch (operador) {
                        case '*':
                            pilhaNumerica.push(operando2 * operando1);break;
                        case '+':
                            pilhaNumerica.push(operando2 + operando1); break;
                        case '/':
                            pilhaNumerica.push(operando2 / operando1);  break;
                        case '-':
                            pilhaNumerica.push(operando2 - operando1);  break;
                        default:
                            return false;
                }
            }
        }

        if(!pilhaNumerica.vazia()){
            Integer resposta = pilhaNumerica.pop();

            System.out.println("Resposta: "+resposta);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {


        String infixa = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";

        System.out.println("1. Expressão original Infixa : " + infixa);

       //String stringPosfixada = converterInfixaParaPosfixada(infixa);
       // System.out.println("2. Traduzida para Posfixada  : " + stringPosfixada);

        Posfixada calculadora = new Posfixada(50);

       // calculadora.setExpressao(stringPosfixada);

        System.out.println("3.Posfixada calculando...\n");


        if (calculadora.avaliaExpressao()) {
            calculadora.imprimeResposta();
        }
    }
}
