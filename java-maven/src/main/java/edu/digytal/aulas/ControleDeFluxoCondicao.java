package edu.digytal.aulas;

public class ControleDeFluxoCondicao {


    public static void main(String[] args) {
        int altura = 3;

        switch (altura) {
            case 5:{
                System.out.println("    #");
            }
            case 4:{
                System.out.println("   ###");
            }
            case 3:{
                System.out.println("  #####");
            }
            case 2:{
                System.out.println(" #######");
            }
            default:
                System.out.println("#########");
        }
    }
}
