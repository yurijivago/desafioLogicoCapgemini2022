import java.util.Arrays;
import java.util.List;

/*
* # Questão 02
    Débora se inscreveu em uma rede social para se manter em contato com seus amigos.
    A página de cadastro exigia o preenchimento dos campos de nome e senha, porém a senha precisa ser forte.
    O site considera uma senha forte quando ela satisfaz os seguintes critérios:
        Possui no mínimo 6 caracteres.
        Contém no mínimo 1 digito.
        Contém no mínimo 1 letra em minúsculo.
        Contém no mínimo 1 letra em maiúsculo.
        Contém no mínimo 1 caractere especial. Os caracteres especiais são: !@#$%^&*()-+

  Débora digitou uma string aleatória no campo de senha, porém ela não tem certeza se é uma senha forte.
  Para ajudar Débora, construa um algoritmo que informe qual é o número mínimo de caracteres que devem ser
adicionados para uma string qualquer ser considerada segura.

Exemplo:
Entrada: Ya3
Saída: 3

Explicação:
 Ela pode tornar a senha segura adicionando 3 caracteres, por exemplo, &ab, transformando a senha em Ya3&ab.
 2 caracteres não são suficientes visto que a senha precisa ter um tamanho mínimo de 6 caracteres.
 *
* * */

public class Questao02 {

    public static void main (String [] args) {

        //Para find didáticos, assumimos um valor fixo para a variável em questão. No entanto o teste pode ser realizado mudando o valor abaixo.
        String senha = "Ya3";
        int caracteresAdicionais = 0;

        boolean possuiTamanhoMinimo = false;
        boolean possuiNumeros = false;
        boolean possuiMinusculas = false;
        boolean possuiMaiusculas = false;
        boolean possuiCarcteresEspeciais = false;
        List<Character> especiais = Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+');

        //Validando se a senha possui...
        // Contém no mínimo 1 digito.
        // Contém no mínimo 1 letra em minúsculo.
        // Contém no mínimo 1 letra em maiúsculo.
        // Contém no mínimo 1 caractere especial. Os caracteres especiais são: !@#$%^&*()-+
        for(int i = 0; i < senha.length(); i++){
            char caractere = senha.charAt(i);
            int caractereASCII = (int) caractere;

            if( caractereASCII >= 48 && caractereASCII <=57){
                //48 a 57: códigos ASCII dos numerais de 0 a 9
                possuiNumeros = true;
            } else if( caractereASCII >= 97 && caractereASCII <=122 ){
                //97 a 122: códigos ASCII das letras minúsculas
                possuiMinusculas = true;
            } else if( caractereASCII >= 65 && caractereASCII <=90 ){
                //65 a 90: códigos ASCII das letras maiúsculas
                possuiMaiusculas = true;
            } else {
                for(Character c: especiais){
                    if(c == caractere){
                        possuiCarcteresEspeciais = true;
                    }
                }

            }
        }

        //verificando total de caracteres a adicionar por não cumprirem os requisitos
        if(!possuiNumeros) caracteresAdicionais++;
        if(!possuiMinusculas) caracteresAdicionais++;
        if(!possuiMaiusculas) caracteresAdicionais++;
        if(!possuiCarcteresEspeciais) caracteresAdicionais++;

        //validando o tamanho da senha - mínimo de 6 caracteres
        // e imprimindo mensagem final
        if(senha.length() < 6){
            int auxiliarSenhaCarEsp = senha.length() + caracteresAdicionais;

            if(auxiliarSenhaCarEsp >=6){
                System.out.println("Você precisa adicionar "
                        + caracteresAdicionais
                        + " à sua senha.");
            } else {
                System.out.println("Você precisa adicionar "
                        + (caracteresAdicionais + (6 - auxiliarSenhaCarEsp))
                        + " à sua senha.");
            }
        } else{
            if(caracteresAdicionais != 0 ){
                System.out.println("Você precisa adicionar " + caracteresAdicionais + "caracteres à sua senha.");
            } else {
                System.out.println("Parabéns! Você possui uma senha forte.");
            }
        }
    }
}
