import java.util.Arrays;
import java.util.HashMap;

/*
* # Questão 03
  Duas palavras podem ser consideradas anagramas de si mesmas se as letras de uma palavra podem
ser realocadas para formar a outra palavra. Dada uma string qualquer, desenvolva um algoritmo que
encontre o número de pares de substrings que são anagramas.
Exemplo:

* Exemplo 1)
  Entrada: ovo
  Saída: 2
* Explicação:
  A lista de todos os anagramas pares são:
    [o, o], [ov, vo] que estão nas posições [[0], [2]], [[0, 1], [1, 2]] respectivamente.

* Exemplo 2)
  Entrada: ifailuhkqq
  Saída: 3
* Explicação:
  A lista de todos os anagramas pares são:
  [i, i], [q, q] e [ifa, fai] que estão nas posições [[0], [3]], [[8],  [9]] e [[0, 1, 2], [1, 2, 3]].

* * */
public class Questao03 {

    public static void main (String [] args){
        //Para find didáticos, assumimos um valor fixo para a variável em questão. No entanto o teste pode ser realizado mudando o valor abaixo.
        String palavra = "ifailuhkqq";

        //utilizaremos HashMap a fim de utilizarmos do método containdKey() para verificarmos se a substring pertente à palavra
        HashMap<String, Integer> map= new HashMap<>();

        /*
        * Para compararmos cada uma das substrings, precisamos ir analisando incialmente com 1 caractere,
        * e ir incrementando o tamanho dessa substring até que toda a palavra tenha sido comparada um caractere a menos.
        *
        * Se temos, por exemplo uma palavra de 4 caracteres, precisaremos comparar uma substring de 1 caractere com
        * os demais. Em seguida repetir o processo para 2 caracteres. e por fim para 3 caracteres (tamanho da palavra - 1) */
        for(int i = 0; i < palavra.length(); i++){
            for(int j = i; j < palavra.length(); j++){

                //separaremos a substring a ser comparada com o restante da palavra em um array de caracteres a fim de ordenarmos esses caracteres.
                char[] caracteresComparaveis = palavra.substring(i, j+1).toCharArray();

                //ordenamos esse array utilizando o método sort()
                Arrays.sort(caracteresComparaveis);

                //Criamos uma variável do tipo String que possuirá o resultado do array de caracteres ordenados que servirá para comparação
                String subPalavra = new String(caracteresComparaveis);

                //Por fim comparamos esse fragmento da palavra com a própria palavra, verificando se há esse padrão
                if (map.containsKey(subPalavra))
                    map.put(subPalavra, map.get(subPalavra)+1);
                else
                    map.put(subPalavra, 1);
            }
        }

        /*
        * Finalizamos por adicionar as ocorrências de anagramas na variável totalAnagramas,
        * com base nas inserções feitas durante a verificação da palavra informada e as
        * respectivas substrings da mesma */
        int totalAnagramas = 0;
        for(String key: map.keySet()){
            //Buscamos através das chaves inseridas durantes a comparação palavra/substrings
            int n = map.get(key);

            /*
            * Nesse ponto, a vaiável 'n' possuirá as ocorrências de cada frequência, possibilitando
            * encontrarmos o real valor de anagramas na palavra. Para isso, precisamos utilizar a fórmula
            * matemática abaixo
            * */
            totalAnagramas += (n * (n-1))/2;
        }
        System.out.println(totalAnagramas);

    }


}
