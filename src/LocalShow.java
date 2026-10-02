public class LocalShow {
    private static final double TETO_DESEMPENHO = 2.0;

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

    @Override
    public String toString() {
        return nome + " | Fama Exigida: " + famaNecessaria +
                " | Cachê Base: R$ " + recompensaBase +
                " | Dificuldade: " + dificuldade;
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

    public boolean isBandaElegivel(Banda banda) {
        if (banda == null) return false;
        return banda.getNivel() >= this.famaNecessaria;
    }

    public double calcularCache (int pontuacaoTotal){
        if (pontuacaoTotal <= 0){
            return 0;
        }
        double desempenho = (double) pontuacaoTotal / dificuldade;
        desempenho = Math.min(desempenho, TETO_DESEMPENHO);
        return recompensaBase * desempenho;
    }
}
