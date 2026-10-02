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
    @Override
    public String toString() {
        if (instrumento != null) {
            return getClass().getSimpleName() + ": " + nome + " (" + instrumento.getNome() + ")";
        } else {
            return getClass().getSimpleName() + ": " + nome + " (Sem instrumento)";
        }
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
        if (energia > 100) {
            this.energia = 100;
        } else if (energia < 0) {
            this.energia = 0;
        }
        else {
            this.energia = energia;
        }
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    public int getBonusInstrumento() {
        if (instrumento != null) {
            return instrumento.getNivelQualidade();
        }
        return 0;
    }

    public int tocar () {
        if (energia < 10){
            IO.println(getNome() + " você está exausto e não consegue realizar o show, descanse!");
            return 0;
        }
        int bonus = getBonusInstrumento();

        setEnergia(getEnergia() - 10);
        return getHabilidade() + bonus;
    }

    public void descansar () {
        this.energia = 100;
        IO.println(getNome() + " você descansou, sua energia está " + getEnergia());
    }

    public abstract int habilidadeEspecial(int opcao);
}
