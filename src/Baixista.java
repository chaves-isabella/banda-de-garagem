public class Baixista extends Artista{

    public Baixista(String nome, String biografia, int habilidade) {
        super(nome, biografia, habilidade);
    }

    public int darBase (){
        if (getEnergia() >= 10){
            setEnergia(getEnergia() - 10);
            IO.println(getNome() + " deu a base perfeita para a banda tocar!");
            return getHabilidade() * 2;
        }
        else {
            IO.println(getNome() + " tentou manter o ritmo, mas perdeu o tempo por cansaço!");
            return 0;
        }
    }

    public int destacarBaixo (){
        if (getEnergia() >= 25){
            setEnergia(getEnergia() - 25);
            IO.println(getNome() + " aumentou o volume e destacou o baixo na música!");
            return getHabilidade() * 3;
        }
        else {
            IO.println(getNome() + " tentou fazer um solo de baixo, mas os dedos travaram");
            return 0;
        }
    }
    @Override
    public int habilidadeEspecial(int opcao) {
        if (opcao == 1){
            return darBase();
        } else if (opcao == 2) {
            return destacarBaixo();
        }
        return 0;
    }


}
