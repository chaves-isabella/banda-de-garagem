public class Baixista extends Artista{

    public Baixista(String nome, String biografia, int habilidade) {
        super(nome, biografia, habilidade);
    }

    @Override
    public int habilidadeEspecial(int opcao) {
        return 0;
    }


}
