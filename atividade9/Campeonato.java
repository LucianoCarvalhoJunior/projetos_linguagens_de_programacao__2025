package atividade9;
import java.util.*;

public class Campeonato {
    private static final int MAX_TIMES = 10;
    private List<Time> times;
    private Set<String> jogosRealizados;
    private Random random;

    public Campeonato() {
        this.times = new ArrayList<>();
        this.jogosRealizados = new HashSet<>();
        this.random = new Random();
    }

    public void cadastrarTime(String nome) {
        if (times.size() >= MAX_TIMES) {
            System.out.println("Limite de times atingido!");
            return;
        }
        times.add(new Time(nome));
        System.out.println("Time cadastrado com sucesso!");
    }

    public void simularJogo(String nomeTime1, String nomeTime2) {
        Time time1 = encontrarTime(nomeTime1);
        Time time2 = encontrarTime(nomeTime2);

        if (time1 == null || time2 == null || time1 == time2) {
            System.out.println("Escolha inválida.");
            return;
        }

        String jogo = time1.nome + " vs " + time2.nome;
        if (jogosRealizados.contains(jogo)) {
            System.out.println("Este jogo já foi realizado! Escolha outra dupla de times.");
            return;
        }

        int gols1 = random.nextInt(5);
        int gols2 = random.nextInt(5);

        System.out.println("Resultado do jogo: " + time1.nome + " " + gols1 + " x " + gols2 + " " + time2.nome);

        time1.atualizarEstatisticas(gols1, gols2);
        time2.atualizarEstatisticas(gols2, gols1);
        jogosRealizados.add(jogo);

        imprimirTabela();
    }

    private Time encontrarTime(String nome) {
        return times.stream().filter(t -> t.nome.equalsIgnoreCase(nome)).findFirst().orElse(null);
    }

    public void imprimirTabela() {
        System.out.println("\nTabela de Pontuação:");
        times.sort(Comparator.comparingInt(t -> -t.pontos));
        for (Time time : times) {
            System.out.println(time);
        }

        if (jogosRealizados.size() == (times.size() * (times.size() - 1)) / 2) {
            System.out.println("\nCampeão(ões):");
            int maxPontos = times.get(0).pontos;
            times.stream().filter(t -> t.pontos == maxPontos).forEach(t -> System.out.println(t.nome));
        }
    }
}
