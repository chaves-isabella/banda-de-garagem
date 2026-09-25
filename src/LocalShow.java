public class LocalShow {

    private String nome;
    private int famaNecessaria;
    private double recompensaBase;
    private int dificuldade;

    public LocalShow(String nome, int famaNecessaria, double recompensaBase, int dificuldade) {
        this.nome = nome;
        this.famaNecessaria = famaNecessaria;
        this.recompensaBase = recompensaBase;
        this.dificuldade = dificuldade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getFamaNecessaria() {
        return famaNecessaria;
    }

    public void setFamaNecessaria(int famaNecessaria) {
        this.famaNecessaria = famaNecessaria;
    }

    public double getRecompensaBase() {
        return recompensaBase;
    }

    public void setRecompensaBase(double recompensaBase) {
        this.recompensaBase = recompensaBase;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }
}
