package Giocatore;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        boolean capitanoo;
        Scanner in = new Scanner(System.in);
        Giocatore[] giocatori = new Giocatore[3];

        // Inserimento dati per 3 giocatori
        for (int i = 0; i < 3; i++) {
            System.out.println("\nInserisci i dati per il giocatore " + (i + 1) + ":");

            System.out.print("Nome: ");
            String nome = in.nextLine();

            System.out.print("È il capitano? (si/no): ");
            String cap = in.nextLine();

            if (cap.equalsIgnoreCase("si")==true){
                capitanoo = true;
            }else{
                capitanoo = false;
            }



            System.out.print("Numero di goal: ");
            int goal = Integer.parseInt(in.nextLine());

            giocatori[i] = new Giocatore(nome, capitanoo, goal);
        }

        // Trova il giocatore con più goal
        Giocatore giocatoreConPiuGoal = giocatori[0];
        for (int i = 1; i < giocatori.length; i++) {
            if (giocatori[i].getGoal() > giocatoreConPiuGoal.getGoal()) {
                giocatoreConPiuGoal = giocatori[i];
            }
        }

        // Stampa i dati del giocatore con più goal
        System.out.println("\nIl giocatore con più goal è:");
        System.out.println("Nome: " + giocatoreConPiuGoal.getNome());
        System.out.println("Capitano: " + (giocatoreConPiuGoal.isCapitano() ? "Sì" : "No"));
        System.out.println("Goal: " + giocatoreConPiuGoal.getGoal());

    }
}
