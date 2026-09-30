public class Bateria  extends Artista{

    public Bateria(String nome, String biografia, int habilidade) {
        super(nome, biografia, habilidade);
    }

    @Override
    public int habilidadeEspecial(int opcao) {
        return 0;
    }


}
