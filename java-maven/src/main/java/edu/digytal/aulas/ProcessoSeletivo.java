package edu.digytal.aulas;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

    public static void main(String[] args) {
        //salario base maior que salario pretendido
        case1(2000.0, 1900.0);

        //salario base igual que salario pretendido
        case1(2000.0, 2000.0);

        //salario base igual que salario pretendido
        case1(1900.0, 2000.0);

        case2();

        case3();

        //assumindo que estes foram os candidatos selecionados
        String [] candidatosSelecionados = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO"};
        //primeiro um for para selecionar os candidatos
        // ... DIGITE SUA SOLUCAÇÃO AQUI ...
        for (String candidato : candidatosSelecionados) {
            case4(candidato);
        }

    }
    static void case1(double salarioBase, double salarioPretendido) {
        // Se o valor salário base for maior que valor salário pretentido, imprima : LIGAR PARA O CANDIDATO;
        // Se não se o valor salário base for igual ao valor salário pretentido, imprima : LIGAR PARA O CANDIDATO, COM CONTRA PROPOSTA;
        // Se não imprima: AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS.
        if(salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO, COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
    static void case2() {
        double salarioBase = 2000.0;
        String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRICIO","MIRELA","DANIELA","JORGE"};
        int totalSelecionados = 0;
        int proximoCandidato = 0;

        // ... DIGITE SUA SOLUCAÇÃO AQUI ...
        for (; proximoCandidato < candidatos.length; proximoCandidato++) {
            // System.out.println(candidatos[i]);
            if ( valorPretendido() <= salarioBase) {
                totalSelecionados++;
            }
            if (totalSelecionados == 5) {
                break;
            }

        }
        System.out.println("Total de selecionados: " + totalSelecionados);
        System.out.println("Total de consultados: " + proximoCandidato);
    }
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void case3() {
        //assumindo que estes foram os candidatos selecionados
        String [] candidatosSelecionados = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO"};

        //forma indexada
        //quando preciso do indice para complementar a lógica
        System.out.println("Imprimindo com a ordem de seleção pelo índice");

        // ... DIGITE SUA SOLUCAÇÃO AQUI ...
        for (int i = 0; i < candidatosSelecionados.length; i++) {
            System.out.println(i + " - " + candidatosSelecionados[i]);
        }

        //forma abrevida
        //interação total sem precisar da posição ou indice
        System.out.println("Imprimindo todos sem a necessidade de exibir o índice");

        // ... DIGITE SUA SOLUCAÇÃO AQUI ...
        for (String candidato: candidatosSelecionados) {
            System.out.println(candidato);
        }
    }

    static void case4(String candidato) {

        int tentativasRealizadas = 1;
        boolean atendeu=false;

        // ... DIGITE SUA SOLUCAÇÃO AQUI ...
        Random random = new Random();
        while (tentativasRealizadas <= 3){
            atendeu = random.nextBoolean();
            if(atendeu || tentativasRealizadas == 3) {
                break;
            }
            tentativasRealizadas++;
        }

        if(atendeu)
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato +" NA " + tentativasRealizadas + " TENTATIVA");
        else
            System.out.println("NAO CONSEGUIMOS CONTATO COM " + candidato +", NUMERO MAXIMO TENTATIVAS " + tentativasRealizadas + " REALIZADA");
    }

    //método auxiliar
    static boolean atender() {
        return new Random().nextInt(3)==1;
    }

}
