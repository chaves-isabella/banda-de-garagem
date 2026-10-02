import java.util.ArrayList;
import java.util.List;

public class Banda {

    private String nomeDaBanda;
    private int nivel;
    private double saldo;
    private List<Artista> listaArtistas;

    public Banda(String nomeDaBanda) {
        this.nomeDaBanda = nomeDaBanda;
        this.nivel = 1;
        this.saldo = 0.0;
        this.listaArtistas = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Banda{" +
                "nome='" + nomeDaBanda + '\'' +
                ", nivel=" + nivel +
                ", saldo=" + saldo +
                ", artistas=" + listaArtistas +
                '}';
    }

    public String getNomeDaBanda() {
        return nomeDaBanda;
    }

    public void setNomeDaBanda(String nomeDaBanda) {
        this.nomeDaBanda = nomeDaBanda;
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

    public List<Artista> getListaArtistas() {
        return listaArtistas;
    }

    public void setListaArtistas(List<Artista> listaArtistas) {
        this.listaArtistas = listaArtistas;
    }

    public boolean adicionarArtista(Artista novoArtista) {
        if (novoArtista == null) {
            return false;
        }

        if (this.listaArtistas.size() >= 4) {
            return false;
        }

        for (Artista artistaExistente : this.listaArtistas) {
            if (artistaExistente.getClass().equals(novoArtista.getClass())) {
                return false;
            }
        }
        return this.listaArtistas.add(novoArtista);
    }

    public int calcularPontuacaoDoShow () {
            if (listaArtistas.isEmpty()) {
                return 0;
            }

            int pontuacaoTotal = 0;

            for (Artista artista : listaArtistas) {
                pontuacaoTotal += artista.tocar();
            }
            return pontuacaoTotal;
        }


        public boolean recuperarEnergiaDosMembros() {
            if (listaArtistas.isEmpty()) {
                return false;
            }
            for (Artista artista : listaArtistas) {
                artista.descansar();
            }
            return true;
        }

        public void adicionarSaldo (double valor){
            if (valor < 0){
                saldo += valor;
            }
        }
    }

