import static java.lang.IO.*;
private static Banda banda;
private static final Loja loja = new Loja();
private static final List<LocalShow> locaisShows = new ArrayList<>();
void main() {
    criarLocais();
    criarBanda();
    menu();
    println("Até a próxima!");
}
private static int lerInteiro(String mensagem) {
    try {
        return Integer.parseInt(readln(mensagem).trim());
    } catch (NumberFormatException e) {
        println("Digite apenas números.");
        return -1;
    }
}

private static void criarLocais(){

    locaisShows.add(new LocalShow("Garagem de casa", 0, 50.0, 1));
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
                Vocalista v = new Vocalista(nome, bio, habilidade);
                v.setInstrumento(new Instrumento("Microfone Genérico", 0.0, 5));
                banda.adicionarArtista(v);
                println("Vocalista adicionado com Microfone Genérico!");
            }
            case 1 -> {
                Guitarrista g = new Guitarrista(nome, bio, habilidade);
                g.setInstrumento(new Instrumento("Guitarra de Garagem", 0.0, 5));
                banda.adicionarArtista(g);
                println("Guitarrista adicionado com Guitarra de Garagem!");
            }
            case 2 -> {
                Baixista b = new Baixista(nome, bio, habilidade);
                b.setInstrumento(new Instrumento("Baixo Escolar", 0.0, 5));
                banda.adicionarArtista(b);
                println("Baixista adicionado com Baixo Escolar!");
            }
            case 3 -> {
                Baterista bat = new Baterista(nome, bio, habilidade);
                bat.setInstrumento(new Instrumento("Bateria Usada", 0.0, 5));
                banda.adicionarArtista(bat);
                println("Baterista adicionado com Bateria Usada!");
            }
        }
    }
}
private static void verStatus() {
    for (Artista a : banda.getListaArtistas()) {
        println(a + " | Energia: " + a.getEnergia() + " | Habilidade: " + a.getHabilidade());
        println("   Bio: " + a.getBiografia());
    }
}
private static void menu(){
    int opcao = 0;
    while (opcao != 5){
        println("\n=== MENU ===");
        println("1 - Ver status");
        println("2 - Loja");
        println("3 - Fazer show");
        println("4 - Descansar");
        println("5 - Sair");
        opcao = lerInteiro("Escolha: ");

        if (opcao == 1) {
            verStatus();
        } else if (opcao == 2) {
            irALoja();
        } else if (opcao == 3) {
            fazerShow();
        } else if (opcao == 4) {
            descansar();
        }else if (opcao != 5) {
            println("Opção inválida.");
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

    int escolha = lerInteiro("Onde tocar? (0 para voltar): ");

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


    int pontos = 0;
    for (Artista artista : banda.getListaArtistas()) {
        println("\n" + artista + " | Energia: " + artista.getEnergia());
        int op = lerInteiro("Habilidade (1 = básica, 2 = forte, 0 = tocar normal): ");

        if (op == 1 || op == 2) {
            int ganho = artista.habilidadeEspecial(op);
            if (ganho > 0) {
                ganho += artista.getBonusInstrumento();
            }
            pontos += ganho;
        } else {
            pontos += artista.tocar();
        }
    }

    double cache = local.calcularCache(pontos);
    banda.adicionarSaldo(cache);
    println("Pontos: " + pontos + " | Cachê: R$ " + cache);

    if (pontos >= local.getDificuldade()) {
        if (local.getFamaNecessaria() >= banda.getNivel()) {
            banda.setNivel(banda.getNivel() + 1);
            for (Artista a : banda.getListaArtistas()) {
                a.setHabilidade(a.getHabilidade() + 1);
            }
            println("Show de sucesso! A banda agora é nível " + banda.getNivel() + " e todos ficaram mais habilidosos!");
        } else {
            println("Show de sucesso, mas esse palco já ficou pequeno para vocês.");
        }
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
    if (item < 1 || item > estoque.size()) {
        println("Opção inválida.");
        return;
    }

    for (int i = 0; i < artistas.size(); i++) {
        println((i + 1) + ") " + artistas.get(i));
    }
    int pessoa = Integer.parseInt(readln("Para quem? (0 para voltar): "));
    if (pessoa == 0) {
        return;
    }
    if (pessoa < 1 || pessoa > artistas.size()) {
        println("Opção inválida.");
        return;
    }

    boolean vendeu = loja.processarVenda(banda, artistas.get(pessoa - 1), estoque.get(item - 1));
    if (vendeu) {
        println("Compra feita!");
    } else {
        println("Saldo insuficiente.");
    }
}