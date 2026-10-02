public class Baterista extends Artista {
    public Baterista(String nome, String biografia, int habilidade) {
        super(nome, biografia, habilidade);
    }

    public int fazerVirada (){
        if (getEnergia() >= 20){
            setEnergia(getEnergia() - 20);
            IO.println(getNome() + " mandou uma virada marcante!");
            return getHabilidade() * 2;
        }
        else {
            IO.println(getNome() + " tentou fazer uma virada, mas deixou cair a baqueta por cansaço!");
            return 0;
        }
    }

    public int ritmoPesado (){
        if (getEnergia() >= 25){
            setEnergia(getEnergia() - 25);
            IO.println(getNome() + " acelerou o ritmo e fez tudo tremer!");
           return getHabilidade() * 4;
        }
        else {
            IO.println(getNome() + " tentou acelerar o ritmo mas não teve força nos braços!");
            return 0;
        }
    }
    @Override
    public int habilidadeEspecial(int opcao) {
        if (opcao == 1){
            return fazerVirada();
        } else if (opcao == 2) {
            return ritmoPesado();
        }
        return 0;
    }
}
