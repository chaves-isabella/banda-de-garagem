public class Vocalista extends Artista{
    public Vocalista(String nome, String biografia, int habilidade) {
        super(nome, biografia, habilidade);
    }

    public int agitarPlateia (){
        if (getEnergia() >= 15){
            setEnergia(getEnergia() - 15);
            IO.println(getNome() + " gritou: 'VOCÊS ESTÃO PRONTO?!' e a plateia foi a loucura!");
            return getHabilidade() * 2;
        }
        else {
            IO.println(getNome() + " tentou agitar a plateia mas está sem fôlego!");
            return 0;
        }
    }

    public int puxarRefrao (){
        if (getEnergia() >= 25){
            setEnergia(getEnergia() - 25);
            IO.println(getNome() + " puxou o refrão e toda a plateia cantou junto!");
            return getHabilidade() * 4;
        }
        else {
            IO.println(getNome() + " tentou puxar o refrão e a voz falhou!");
            return 0;
        }
    }

    @Override
    public int habilidadeEspecial(int opcao) {
        if (opcao == 1){
            return agitarPlateia();
        }
        else if (opcao == 2){
            return puxarRefrao();
        }
        return 0;
    }
}
