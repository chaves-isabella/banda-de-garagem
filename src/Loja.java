import java.util.ArrayList;
import java.util.List;
public class Loja {

    private List<Instrumento> estoque;


    public Loja() {
        this.estoque = new ArrayList<>();
        inicializarEstoque();
    }

    public List<Instrumento> getEstoque() {
        return estoque;
    }

    public void setEstoque(List<Instrumento> estoque) {
        this.estoque = estoque;
    }

    private void inicializarEstoque(){
        estoque.add(new Instrumento("Microfone Shure", 150.0, 10));
        estoque.add(new Instrumento("Guitarra Fender", 400.0, 20));
        estoque.add(new Instrumento("Baixo Yamaha", 300.0, 15));
        estoque.add(new Instrumento("Bateria Pearl", 600.0, 25));
    }

    public boolean processarVenda (Banda banda, Artista artista, Instrumento instrumento){
        if (banda == null || artista == null || instrumento == null) {
            return false;
        }
        if (banda.getSaldo() >= instrumento.getValor()) {
            banda.setSaldo(banda.getSaldo() - instrumento.getValor());
            artista.setInstrumento(instrumento);
            return true;
        }
        return false;
    }
}
