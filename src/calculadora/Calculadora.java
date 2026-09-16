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
    Color laranja = new Color(0, 149, 0);

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

    // A+B, A-B, A*B, A/B
    String A = "0";
    String operador = null;
    String B = null;

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
                        if (valorBotao == "=") {
                            if (A != null) {
                                B = label.getText();
                                double numA = Double.parseDouble(A);
                                double numB = Double.parseDouble(B);

                                if (operador == "+") {
                                    label.setText(removedecimalzero(numA+numB));
                                }
                                else if (operador == "-") {
                                    label.setText(removedecimalzero(numA-numB));
                                }
                                else if (operador == "×") {
                                    label.setText(removedecimalzero(numA*numB));
                                }
                                else if (operador == "÷") {
                                    label.setText(removedecimalzero(numA/numB));
                                }
                                clearAll();
                            }
                        }
                        else if ("+-×÷".contains(valorBotao)) {
                            if (operador == null) {
                                A = label.getText();
                                label.setText("0");
                                B = "0";
                            }
                            operador = valorBotao;
                        }
                    }
                    else if (Arrays.asList(simbolotopo).contains(valorBotao)) {
                        if (valorBotao == "AC") {
                            clearAll();
                            label.setText("0");
                        }
                        else if (valorBotao == "+/-") {
                            double numdisplay = Double.parseDouble(label.getText());
                            numdisplay *= -1;
                            label.setText(removedecimalzero(numdisplay));
                        }
                        else if (valorBotao == "%") {
                            double numdisplay = Double.parseDouble(label.getText());
                            numdisplay /= 100;
                            label.setText(removedecimalzero(numdisplay));
                        }
                    }
                    else {
                        if (valorBotao == ".") {
                            if (!label.getText().contains(valorBotao)) {
                                label.setText(label.getText() + valorBotao);
                            }
                        }
                        else if (valorBotao == "√") {
                            double numdisplay = Double.parseDouble(label.getText());
                            numdisplay = Math.pow(numdisplay, 0.5);
                            label.setText(removedecimalzero(numdisplay));
                        }
                        else if ("0123456789".contains(valorBotao)) {
                            if (label.getText() == "0") {
                                label.setText(valorBotao);
                            }
                            else {
                                label.setText(label.getText() + valorBotao);
                            }
                        }
                    }
                }
            });
        }
        frame.setVisible(true);
    }

    public void clearAll() {
        A = "0";
        operador = null;
        B = null;
    }

    String removedecimalzero(double numdisplay) {
        if (numdisplay % 1 == 0) {
            return Integer.toString((int) numdisplay);
        }
        return Double.toString(numdisplay);
    }
}