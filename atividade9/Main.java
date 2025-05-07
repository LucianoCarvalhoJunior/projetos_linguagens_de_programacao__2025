package atividade9;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Campeonato campeonato = new Campeonato();

        while (true) {
            System.out.println("\n1 - Cadastrar Times\n2 - Simular Jogos\n3 - Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do time: ");
                    String nomeTime = scanner.nextLine();
                    campeonato.cadastrarTime(nomeTime);
                    break;
                case 2:
                    System.out.println("Digite o nome do primeiro time:");
                    String nomeTime1 = scanner.nextLine();
                    System.out.println("Digite o nome do segundo time:");
                    String nomeTime2 = scanner.nextLine();
                    campeonato.simularJogo(nomeTime1, nomeTime2);
                    break;
                case 3:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    
}
