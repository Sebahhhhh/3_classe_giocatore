package Giocatore;

public class Giocatore {

    // Inizializzazione
    private String nome;
    private boolean capitano;
    private int goal;

    // Costruttore vuoto
    public Giocatore() {
    }

    // Atributi
    public Giocatore(String nome, boolean capitano, int goal) {
        setNome(nome);
        setCapitano(capitano);
        setGoal(goal);
    }

    // Giocatore
    public Giocatore(String nome) {
        setNome(nome);
        setCapitano(false);
        setGoal(0);
    }

    // Metodi get
    public String getNome() {
        return nome;
    }

    public boolean isCapitano() {
        return capitano;
    }

    public int getGoal() {
        return goal;
    }

    // Metodi set
    public void setNome(String nuovoNome) {
        if (nuovoNome != null && !nuovoNome.trim().isEmpty()) {
            nome = nuovoNome;
        }
    }

    public void setCapitano(boolean nuovoCapitano) {
        capitano = nuovoCapitano;
    }

    public void setGoal(int nuoviGoal) {
        if (nuoviGoal >= 0) {
            goal = nuoviGoal;
        }
    }
}