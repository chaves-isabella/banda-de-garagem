public class Guitarrista extends Artista{

    public Guitarrista(String nome, String biografia, int habilidade) {
        super(nome, biografia, habilidade);
    }

    public int fazerSolo (){
        if (getEnergia() >= 20){
            setEnergia(getEnergia() - 20);
            IO.println(getNome() + " fez um solo de guitarra extraordinário!");
            return getHabilidade() * 3;
        }
        else {
            IO.println(getNome() + " errou as notas do solo por conta do cansaço");
            return 0;
        }
    }

    public int quebrarGuitarra () {
        if (getEnergia() >= 35) {
            setEnergia(getEnergia() - 35);
            IO.println(getNome() + " QUEBROU A GUITARRA! A plateia foi à loucura!");
            setInstrumento(null);
            return getHabilidade() * 5;
        }
        else {
            IO.println(getNome() + " não teve forças o suficiente para quebrar a guitarra!");
            return 0;
        }

    }

    @Override
    public int habilidadeEspecial(int opcao) {
       if (opcao == 1){
           return fazerSolo();
       }
       else if (opcao == 2){
           return quebrarGuitarra();
       }
       return 0;
    }

}
