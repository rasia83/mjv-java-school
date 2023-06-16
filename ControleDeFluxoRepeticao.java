
public class ControleDeFluxoRepeticao {

    static int carneirinhos = retornarPrimeiroCarneirinho();
    public static void main(String[] args) {
        //int carneirinhos = retornarPrimeiroCarneirinho();
        for ( ; carneirinhos <= 20 ; ) {
            System.out.println(carneirinhos + " - Carneirinhos ");
            incrementar();
        }
    }

    public static int retornarPrimeiroCarneirinho(){
        return (int) ((Math.random() * (20 - 1)) + 1);
    }

    static void incrementar(){
        carneirinhos++;
    }
}
