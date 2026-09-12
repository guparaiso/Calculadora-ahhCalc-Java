package calculadora;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Calculadora {
    int largura = 360;
    int altura = 540;

    Color cinzaclaro = new Color(212, 212, 210);
    Color cinzaescuro = new Color(80, 80, 80);
    Color preto = new Color(28, 28, 28);
    Color laranja = new Color(255, 149, 0);

    String[] valorBotoes = {
            "AC", "+/-", "%", "÷",
            "7", "8", "9", "×",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "√", "="
    };
    String[] simbolodireita = {"÷", "×", "-", "+", "="};
    String[] simbolotopo = {"AC", "+/-", "%"};

    JFrame frame = new JFrame("ahhCalc");
    JLabel label = new JLabel();
    JPanel panel = new JPanel();
    JPanel panelbotoes = new JPanel();

    public Calculadora() {
        frame.setSize(largura, altura);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        label.setBackground(preto);
        label.setForeground(Color.white);
        label.setFont(new Font("Arial", Font.PLAIN, 80));
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setText("0");
        label.setOpaque(true);

        panel.setLayout(new BorderLayout());
        panel.add(label);
        frame.add(panel, BorderLayout.NORTH);

        panelbotoes.setLayout(new GridLayout(5, 4));
        panelbotoes.setBackground(preto);
        frame.add(panelbotoes);

        for (int i = 0; i < valorBotoes.length; i++) {
            JButton botao = new JButton();
            String valorBotao = valorBotoes[i];
            botao.setFont(new Font("Arial", Font.PLAIN, 30));
            botao.setText(valorBotao);
            botao.setFocusable(false);
            botao.setBorder(new LineBorder(preto));
            if (Arrays.asList(simbolotopo).contains(valorBotao)) {
                botao.setBackground(cinzaclaro);
                botao.setForeground(preto);
            }
            else if (Arrays.asList(simbolodireita).contains(valorBotao)) {
                botao.setBackground(laranja);
                botao.setForeground(Color.white);
            }
            else {
                botao.setBackground(cinzaescuro);
                botao.setForeground(Color.white);
            }
            panelbotoes.add(botao);

            botao.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton botao = (JButton) e.getSource();
                    String valorBotao = botao.getText();
                    if (Arrays.asList(simbolodireita).contains(valorBotao)) {

                    }
                    else if (Arrays.asList(simbolotopo).contains(valorBotao)) {

                    }
                    else {

                    }
                }
            })
        }
        frame.setVisible(true);
    }

}