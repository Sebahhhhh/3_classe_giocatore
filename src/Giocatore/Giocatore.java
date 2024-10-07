package Giocatore;

public class Giocatore {

    private String nome;
    private Boolean capitano;
    private int goals;
    public Giocatore (String nome, Boolean capitano, int goals) {
        setNome(nome);
        setCapitano(capitano);
        setGoals(goals);
    }
    public Giocatore (String nome, Boolean capitano) {
        setNome(nome);
        setCapitano(capitano);
        setGoals(0);
    }
    public Giocatore (String nome) {
        setNome(nome);
        setCapitano(false);
        setGoals(0);
    }
    public String getNome() {
        return nome;
    }
    public String getCapitano() {
        if (capitano) {
            return "E' il Capitano";
        } else {
            return "Non capitano";
        }
    }
    public int getGoals() {
        return goals;
    }
    public void setNome(String nomee) {
        nome = nomee;
    }
    public void setCapitano(Boolean capitanoo) {
        capitano = capitanoo;
    }
    public void setGoals(int goalss) {
        goals = goalss;
    }
}