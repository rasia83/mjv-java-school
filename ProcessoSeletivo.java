
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
        // ... DIGITE SUA SOLUCAÇÃO AQUI ...
    }
    static void case2() {
        double salarioBase = 2000.0;
        String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRICIO","MIRELA","DANIELA","JORGE"};
        int totalSelecionados = 0;
        int proximoCandidato = 0;

        // ... DIGITE SUA SOLUCAÇÃO AQUI ...

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

        //forma abrevida
        //interação total sem precisar da posição ou indice
        System.out.println("Imprimindo todos sem a necessidade de exibir o índice");

        // ... DIGITE SUA SOLUCAÇÃO AQUI ...

    }

    static void case4(String candidato) {

        int tentativasRealizadas = 1;
        boolean atendeu=false;

        // ... DIGITE SUA SOLUCAÇÃO AQUI ...

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
