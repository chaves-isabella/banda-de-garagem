import java.util.List;

public class Banda {

    private String nome;
    private int nivel;
    private double saldo;
    private List<Artista> artistas;

    public Banda(String nome, int nivel, double saldo, List<Artista> artistas) {
        this.nome = nome;
        this.nivel = nivel;
        this.saldo = saldo;
        this.artistas = artistas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }
}
