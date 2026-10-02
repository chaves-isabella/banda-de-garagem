public class Instrumento {

    private String nomeInstrumento;
    private double valor;
    private int nivelQualidade;

    public Instrumento(String nome, double valor, int nivelQualidade) {
        this.nomeInstrumento = nome;
        this.valor = valor;
        this.nivelQualidade = nivelQualidade;
    }

    @Override
    public String toString() {
        return nomeInstrumento + " (Bônus de Qualidade: +" + nivelQualidade + ") - R$ " + valor;
    }

    public String getNome() {
        return nomeInstrumento;
    }

    public void setNome(String nome) {
        this.nomeInstrumento = nome;
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
