public class Instrumento {

    private String nome;
    private double valor;
    private int nivelQualidade;

    public Instrumento(String nome, double valor, int nivelQualidade) {
        this.nome = nome;
        this.valor = valor;
        this.nivelQualidade = nivelQualidade;
    }

    @Override
    public String toString() {
        return "Instrumento{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", nivelQualidade=" + nivelQualidade +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getNivelQualidade() {
        return nivelQualidade;
    }

    public void setNivelQualidade(int nivelQualidade) {
        this.nivelQualidade = nivelQualidade;
    }
}
