package atividade9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CampeonatoGUI extends JFrame {
    private Campeonato campeonato;
    private JTextArea outputArea;

    public CampeonatoGUI() {
        campeonato = new Campeonato();

        setTitle("Campeonato de Futebol");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JButton cadastrarButton = new JButton("Cadastrar Time");
        JButton simularButton = new JButton("Simular Jogo");
        JButton sairButton = new JButton("Sair");

        panel.add(cadastrarButton);
        panel.add(simularButton);
        panel.add(sairButton);

        add(panel, BorderLayout.SOUTH);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Digite o nome do time:");
                if (nome != null && !nome.trim().isEmpty()) {
                    campeonato.cadastrarTime(nome);
                    atualizarTabela();
                }
            }
        });

        simularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (campeonato.getTimes().size() < 2) {
                    JOptionPane.showMessageDialog(null, "É necessário pelo menos 2 times!");
                    return;
                }

                String time1 = JOptionPane.showInputDialog("Digite o nome do primeiro time:");
                String time2 = JOptionPane.showInputDialog("Digite o nome do segundo time:");

                if (time1 != null && time2 != null && !time1.equalsIgnoreCase(time2)) {
                    campeonato.simularJogo(time1, time2);
                    atualizarTabela();
                } else {
                    JOptionPane.showMessageDialog(null, "Nomes inválidos ou iguais!");
                }
            }
        });

        sairButton.addActionListener(e -> System.exit(0));
    }

    private void atualizarTabela() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tabela de Pontuação:\n");
        for (Time time : campeonato.getTimes()) {
            sb.append(time).append("\n");
        }
        outputArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CampeonatoGUI().setVisible(true));
    }

    
}
