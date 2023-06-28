package edu.digytal.aulas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class OrdenarUmaFrase {
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

        System.out.println();

        //String frase = "o código estava muito bem escrito";
        //String[] palavras = frase.split(" ");
        Arrays.sort(palavras, Comparator.comparingInt(String::length));
        String frase = String.join(" ", palavras);
        System.out.println(frase);
    }

}
