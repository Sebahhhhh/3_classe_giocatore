package Giocatore;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    
    static Boolean lib = true;
    static Scanner in = new Scanner(System.in);
    static Giocatore[] squad;
    static boolean cap= false;
    
    public static void main(String[] args) {
        System.out.println("Quanti giocatori sono presenti?: ");
        int n = in.nextInt();
        squad = new Giocatore[n];
        
        // Ciclo per inizializzare tutti gli oggetti Giocatore
        for (int i = 0; i < n; i++) {
            System.out.println("Nome del giocatore: ");
            String nome = in.next();
            System.out.println("E' capitano? (Si/No): ");
            
            String capitan = in.next();
            if(capitan.equalsIgnoreCase("si")) {
                cap = true;
            }
            cap = slotCapitano(cap);
            System.out.println("Goal Segnati: ");
            int goals = in.nextInt();
            squad[i] = new Giocatore(nome, cap, goals);
        }
        // Menu
        while (true) {
            System.out.println("");
            System.out.println("!-! MENU !-!");
            System.out.println("");
            System.out.println("1 | Aggiungi Calciatore");
            System.out.println("2 | Mostra Tutti calciatori della Squadra");
            System.out.println("3 | Modifica calciatore");
            System.out.println("4 | Rimuovi un calciatore");
            System.out.println("5 | Visualizza calciatori >5 Goal");
            System.out.println("6 | Chi è il capitano?");
            System.out.println("7 | Assegna capitano");
            System.out.println("10| Esci dal programma");
            System.out.println("");
            System.out.println("la tua scelta: ");
            System.out.println("");
            
            int scelt = in.nextInt();
            
            switch (scelt) {
                case 1:
                    inserisciGiocatore();
                    break;
                case 2:
                    mostraSquadra();
                    break;
                case 3:
                    System.out.println("Numero giocatore da cambiare: ");
                    int num = in.nextInt();
                    modificaGiocatore(num);
                    break;
                case 4:
                    System.out.println("Quanti giocatori vuoi togliere?: ");
                    int num2 = in.nextInt();
                    rimuoviGiocatore(num2);
                    break;
                case 5:
                    visualizzaCinqueGoals();
                    break;
                case 6:
                    visualizzaCapitano();
                    break;
                case 7:
                    assegnaCapitanoCasualmente();
                    break;
                case 10:
                    System.out.println("!!! - !!!");
                    System.out.println("Chiusura del programma...");
                    System.out.println("!!! - !!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("!!! - !!!");
                    System.out.println("Scelta non valida...");
                    System.out.println("!!! - !!!");
                    break;
            }
        }
    }
    public static Boolean slotCapitano(Boolean capitano) {
        if (lib) {
            if (capitano) {
                lib = false;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void inserisciGiocatore() {
        System.out.println("Nome: ");
        String nome = in.next();
        System.out.println("E' capitano? (Si/No): ");
        String capitan = in.next();
        if(capitan.equalsIgnoreCase("si")) {
            cap = true;
        }
        cap = slotCapitano(cap);
        System.out.println("Goal Segnati: ");
        int goals = in.nextInt();
        squad = Arrays.copyOf(squad, squad.length+1);
        squad[squad.length-1] = new Giocatore(nome, cap, goals);
    }

    public static void mostraSquadra() {
        for (Giocatore giocatore : squad) {
            System.out.println("");
            System.out.println("Nome: " + giocatore.getNome());
            System.out.println("Capitano: " + giocatore.getCapitano());
            System.out.println("Goal segnati: " + giocatore.getGoals());
        }
    }
    public static void modificaGiocatore( int n) {
        System.out.println("Nuovo nome del giocatore: ");
        String nome = in.next();
        System.out.println("E' capitano? (Si/No): ");
        String capitan = in.next();
        if(capitan.equalsIgnoreCase("si")) {
            cap = true;
        }
        System.out.println("Goal segnati: ");
        int goals = in.nextInt();
        squad[n].setNome(nome);
        squad[n].setCapitano(cap);
        squad[n].setGoals(goals);
    }
    public static void rimuoviGiocatore( int n) {
        if (squad[n].getCapitano().equals("Capitano")) {
            lib = true;
        }
        squad[n] = squad[squad.length-1];
        squad = Arrays.copyOf(squad, squad.length-1);

    }
    public static void visualizzaCinqueGoals() {
        for (Giocatore giocatore : squad) {
            if (giocatore.getGoals() >= 5) {
                System.out.println("Nome: " + giocatore.getNome());
                System.out.println("Capitano: " + giocatore.getCapitano());
                System.out.println("Goal segnati: " + giocatore.getGoals());
            }
        }
    }
    public static void visualizzaCapitano() {
        if (lib) {
            System.out.println("Capitano non Assegnato");
        } else {
            for (Giocatore giocatore : squad) {
                if (giocatore.getCapitano().equals("Capitano")) {
                    System.out.println("Nome: " + giocatore.getNome());
                    System.out.println("Capitano: " + giocatore.getCapitano());
                    System.out.println("Goal segnati: " + giocatore.getGoals());
                }
            }
        }
    }
    public static void  assegnaCapitanoCasualmente() {
        if (lib) {
            int random = (int) (Math.random() * squad.length-1);
            squad[random].setCapitano(slotCapitano(true));
            lib = false;
        }
    }

}