import static java.lang.IO.*;
private static Banda banda;
private static final Loja loja = new Loja();
private static final List<LocalShow> locaisShows = new ArrayList<>();
void main() {
    criarLocais();
    criarBanda();
    menu();
    descansar();
    irALoja();
    println("Até a proxima");
}

private static void criarLocais(){
    locaisShows.add(new LocalShow("Bar do Zé", 1, 100.0, 10));
    locaisShows.add(new LocalShow("Rock Club", 2, 300.0, 30));
    locaisShows.add(new LocalShow("Teatro Municipal", 3, 600.0, 50));
    locaisShows.add(new LocalShow("Festival de Verão", 4, 1000.0, 70));
    locaisShows.add(new LocalShow("Grande Estádio", 5, 2000.0, 90));
}

private static void criarBanda (){
    banda = new Banda(readln("Digite o nome da banda: "));
    String [] funcoes = {"Vocalista", "Guitarrista", "Baixista", "Baterista"};
    for (int i =0; i < 4; i++) {
        println("\nRecrutando: " + funcoes[i]);
        String nome = readln("Nome: ");
        String bio = readln("Biografia: ");
        int habilidade = 5;
        switch (i) {
            case 0 -> {
                println("Vocalista adicionado");
                banda.adicionarArtista(new Vocalista(nome, bio, habilidade));
            }
            case 1 -> {
                println("Guitarrista adicionado");
                banda.adicionarArtista(new Guitarrista(nome, bio, habilidade));
            }
            case 2 -> {
                println("Baixista adicionado");
                banda.adicionarArtista(new Baixista(nome, bio, habilidade));
            }
            case 3 -> {
                println("Baterista adicionado");
                banda.adicionarArtista(new Baterista(nome, bio, habilidade));
            }
        }
    }
}
private static void verStatus() {
    println("Banda: " + banda.getNomeDaBanda() + " | Nível: " + banda.getNivel() + " | Saldo: R$ " + banda.getSaldo());
    for (Artista a : banda.getListaArtistas()) {
        println(a + " | Energia: " + a.getEnergia());
    }
}
private static void menu(){
    int opcao = 0;
    while (opcao != 5){
        println("\n=== MENU ===");
        println("1 - Ver status");
        println("2 - Ensaiar");
        println("3 - Fazer show");
        println("4 - Descansar");
        println("0 - Sair");
        opcao = Integer.parseInt(readln("Escolha: "));

        if (opcao == 1) {
            verStatus();
        } else if (opcao == 2) {
            irALoja();
        } else if (opcao == 3) {
            fazerShow();
        } else if (opcao == 4) {
            descansar();
        }
    }
}

private static void descansar() {
    banda.recuperarEnergiaDosMembros();
}

private static void fazerShow() {
    for (int i = 0; i < locaisShows.size(); i++) {
        println((i + 1) + ") " + locaisShows.get(i));
    }

    int escolha;
    try {
        escolha = Integer.parseInt(readln("Onde tocar? (0 para voltar): "));
    } catch (NumberFormatException e) {
        println("Digite apenas números.");
        return;
    }

    if (escolha == 0) {
        return;
    }

    if (escolha < 1 || escolha > locaisShows.size()) {
        println("Opção inválida.");
        return;
    }

    LocalShow local = locaisShows.get(escolha - 1);

    if (!local.isBandaElegivel(banda)) {
        println("Sua banda precisa ser nível " + local.getFamaNecessaria() + ".");
        return;
    }

    int pontos = banda.calcularPontuacaoDoShow();
    double cache = local.calcularCache(pontos);
    banda.adicionarSaldo(cache);
    println("Pontos: " + pontos + " | Cachê: R$ " + cache);

    if (pontos >= local.getDificuldade()) {
        banda.setNivel(banda.getNivel() + 1);
        println("Show de sucesso! A banda agora é nível " + banda.getNivel());
    } else {
        println("O show não empolgou.");
    }
}
private static void irALoja() {
    List<Instrumento> estoque = loja.getEstoque();
    List<Artista> artistas = banda.getListaArtistas();

    println("Saldo: R$ " + banda.getSaldo());
    for (int i = 0; i < estoque.size(); i++) {
        println((i + 1) + ") " + estoque.get(i));
    }
    int item = Integer.parseInt(readln("Qual instrumento? (0 para voltar): "));
    if (item == 0) {
        return;
    }

    for (int i = 0; i < artistas.size(); i++) {
        println((i + 1) + ") " + artistas.get(i));
    }
    int pessoa = Integer.parseInt(readln("Para quem? (0 para voltar): "));
    if (pessoa == 0) {
        return;
    }

    boolean vendeu = loja.processarVenda(banda, artistas.get(pessoa - 1), estoque.get(item - 1));
    if (vendeu) {
        println("Compra feita!");
    } else {
        println("Saldo insuficiente.");
    }
}
