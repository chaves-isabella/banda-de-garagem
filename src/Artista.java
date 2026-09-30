public abstract class Artista {

    private String nome;
    private String biografia;
    private int habilidade;
    private int energia;
    private Instrumento instrumento;

    public Artista(String nome, String biografia, int habilidade) {
        this.nome = nome;
        this.biografia = biografia;
        this.habilidade = habilidade;
        this.energia = 100;
        this.instrumento = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public int getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(int habilidade) {
        this.habilidade = habilidade;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public void setInstrumentoEquipado(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    public void equiparInstrumento (Instrumento instrumento){
        this.instrumento = instrumento;
        IO.println(getNome() + "equipou o instrumento" + instrumento.getNome());
    }

    public int tocar () {
        if (energia < 10){
            IO.println(getNome() + "você está exausto e não consegue realizar o show, descanse!");
            return 0;
        }

        int bonus = 0;
        if (getInstrumento() != null){
            bonus = getInstrumento().getNivelQualidade();
        }
        energia = getEnergia() - 10;
        if (energia < 0) {
            energia = 0;
        }
        return habilidade + bonus;
    }

    public void descansar () {
        energia = 100;
        IO.println(getNome() + " você descansou, sua energia está " + getEnergia());
    }

    public abstract int habilidadeEspecial(int opcao);
}
