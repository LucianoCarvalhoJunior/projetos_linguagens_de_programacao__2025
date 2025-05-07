package atividade9;
public class Time {
    String nome;
    int pontos;
    int jogos;
    int vitorias;
    int empates;
    int derrotas;
    int golsMarcados;
    int golsSofridos;

    public Time(String nome) {
        this.nome = nome;
        this.pontos = 0;
        this.jogos = 0;
        this.vitorias = 0;
        this.empates = 0;
        this.derrotas = 0;
        this.golsMarcados = 0;
        this.golsSofridos = 0;
    }

    public void atualizarEstatisticas(int golsMarcados, int golsSofridos) {
        this.jogos++;
        this.golsMarcados += golsMarcados;
        this.golsSofridos += golsSofridos;

        if (golsMarcados > golsSofridos) {
            this.vitorias++;
            this.pontos += 3;
        } else if (golsMarcados == golsSofridos) {
            this.empates++;
            this.pontos += 1;
        } else {
            this.derrotas++;
        }
    }

    public int getSaldoGols() {
        return golsMarcados - golsSofridos;
    }

    @Override
    public String toString() {
        return String.format("%s - Jogos: %d, Pontos: %d, Vitórias: %d, Empates: %d, Derrotas: %d, Gols Marcados: %d, Gols Sofridos: %d, Saldo de Gols: %d",
                nome, jogos, pontos, vitorias, empates, derrotas, golsMarcados, golsSofridos, getSaldoGols());
    }
}
