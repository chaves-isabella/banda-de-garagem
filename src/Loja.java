import java.util.List;

public class Loja {

    private List<Instrumento> estoque;

    public Loja(List<Instrumento> estoque) {
        this.estoque = estoque;
    }

    public List<Instrumento> getEstoque() {
        return estoque;
    }

    public void setEstoque(List<Instrumento> estoque) {
        this.estoque = estoque;
    }
}
