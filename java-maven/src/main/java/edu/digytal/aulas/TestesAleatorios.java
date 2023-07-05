package edu.digytal.aulas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TestesAleatorios {

        public static void main(String[] args) {

            String valorDigitado = JOptionPane.showInputDialog(null, "Qual o valor a ser convertido?",
                    "Conversão de Valor Monetário", JOptionPane.QUESTION_MESSAGE);

            if (valorDigitado != null) {
                // O usuário digitou um valor e clicou em OK
                // Aqui você pode processar o valor conforme necessário
                try {
                    double valor = Double.parseDouble(valorDigitado);
                    System.out.println("Valor digitado: " + valor);
                } catch (NumberFormatException e) {
                    System.out.println("Valor inválido!");
                }
            } else {
                // O usuário clicou em Cancelar ou fechou a janela
                System.out.println("Nenhum valor digitado.");
            }

        }

}
    /*
    public static void main(String[] args) {
        String original = "O código estava muito bem escrito.";

        // Separar as palavras por espaços em branco
        String[] palavras = original.split(" ");

        // Criar uma lista para armazenar as palavras
        List<String> listaPalavras = new ArrayList<>();

        // Adicionar as palavras na lista
        Collections.addAll(listaPalavras, palavras);

        // Ordenar a lista em ordem crescente de tamanho das palavras
        listaPalavras.sort((s1, s2) -> s1.length() - s2.length());

        // Percorrer a lista e exibir as palavras
        for (String palavra : listaPalavras) {
            System.out.print(palavra + " ");
        }
        System.out.println();

        // OU, todo esse passo a passo em uma linha
        Arrays.stream("O código estava muito bem escrito.".split(" "))
                .sorted((s1, s2) -> s1.length() - s2.length())
                .forEach(palavra -> System.out.print(palavra + " "));
    }
}

/*

    public static void main(String[] args) {

        args = new String[]{"Ola", "a", "10", "3.14", "true", "false","0","0,0","0.0"};

        // identificando o tipo do argumento de entrada

        for (String arg : args) {
            try {
                int valor = Integer.parseInt(arg);
                System.out.println("Argumento é um inteiro -> " + valor);
            } catch (NumberFormatException e) {
                try {
                    double doubleValor = Double.parseDouble(arg);
                    System.out.println("Argumento é um double -> " + doubleValor);
                } catch (NumberFormatException e2) {

                    String valorString = String.valueOf(arg);
                    if (valorString.length() == 1) {
                        System.out.println("Argumento é um char -> " + arg);
                    } else if (arg.equalsIgnoreCase("true") || arg.equalsIgnoreCase("false")) {
                        System.out.println("Argumento é um boolean -> " + arg);
                    } else {
                        System.out.println("Argumento é uma string -> " + arg);
                    }

                }
            }
        }
    }



    // Jose Marcelo - T5 Oracle ONE
    String getArg(String arg) {
        return arg + ": e uma String";
    }

    String getArg(boolean arg) {
        return arg + ": e um Boolean";
    }

    String getArg(int arg) {
        return arg + ": e um Int";
    }

    String getArg(double arg) {
        return arg + ": e um Double";
    }

    String getArg(char arg) {
        return arg + ": e um Char";
    }

} */
