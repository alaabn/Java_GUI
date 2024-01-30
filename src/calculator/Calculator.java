package calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame {
    JLabel l1 = new JLabel("Donne a: ");
    JTextField tf1 = new JTextField();

    JLabel l2 = new JLabel("Donne b: ");
    JTextField tf2 = new JTextField();

    JLabel l3 = new JLabel("Resultat: ");
    JTextField tf3 = new JTextField();

    JButton ba = new JButton("Addition");
    JButton bs = new JButton("Soustraction");
    JButton bd = new JButton("Division");
    JButton bm = new JButton("Multiplication");

    JPanel p = new JPanel(new GridLayout(5, 2, 10, 10));

    public Calculator() {
        super("Calculatrice");
        setVisible(true);

        tf3.setEnabled(false);

        p.add(l1);
        p.add(tf1);
        p.add(l2);
        p.add(tf2);
        p.add(l3);
        p.add(tf3);
        p.add(ba);
        p.add(bs);
        p.add(bd);
        p.add(bm);

        add(p, BorderLayout.CENTER);

        ba.addActionListener(e -> {
            try {
                tf3.setText(
                        String.valueOf(
                                Integer.parseInt(tf1.getText()) + Integer.parseInt(tf2.getText())));
            } catch (NumberFormatException ee) {
                JOptionPane.showMessageDialog(this, ee.getMessage());
            }
        });
        bs.addActionListener(e -> {
            try {
                tf3.setText(
                        String.valueOf(
                                Integer.parseInt(tf1.getText()) - Integer.parseInt(tf2.getText())));
            } catch (NumberFormatException ee) {
                JOptionPane.showMessageDialog(this, ee.getMessage());
            }
        });
        bd.addActionListener(e -> {
            try {
                tf3.setText(
                        String.valueOf(
                                Integer.parseInt(tf1.getText()) / Integer.parseInt(tf2.getText())));
            } catch (NumberFormatException ee) {
                JOptionPane.showMessageDialog(this, ee.getMessage());
            } catch (ArithmeticException ee) {
                JOptionPane.showMessageDialog(this, ee.getMessage());
            }
        });
        bm.addActionListener(e -> {
            try {
                tf3.setText(
                        String.valueOf(
                                Integer.parseInt(tf1.getText()) * Integer.parseInt(tf2.getText())));
            } catch (NumberFormatException ee) {
                JOptionPane.showMessageDialog(this, ee.getMessage());
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }

    public static void main(String[] args) {
        new Calculator();
    }
}