/*
* # Questão 01
* Escreva um algoritmo que mostre na tela uma escada de tamanho n utilizando o caractere * e espaços.
* A base e altura da escada devem ser iguais ao valor de n. A
* última linha não deve conter nenhum espaço.

 Exemplo:
 Entrada: n = 6
 Saída:
     *
    **
   ***
  ****
 *****
******

*
* * */
public class Questao01 {

    public static void main (String [] args){
        //Para find didáticos, assumimos um valor fixo para a variável em questão. No entanto o teste pode ser realizado mudando o valor abaixo.
        int n = 5;

        String saida = "";
        int aux = 1;
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=(n-aux); j++){
                System.out.print(" ");
            }
                saida += "*";

            System.out.println(saida);
            aux++;
        }

    }


}
