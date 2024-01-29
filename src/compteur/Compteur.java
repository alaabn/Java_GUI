package compteur;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Compteur extends JFrame {

    JLabel tf = new JLabel("0", JLabel.CENTER);
    JButton bm = new JButton(" - ");
    JButton bp = new JButton(" + ");
    JButton br = new JButton("Reset");

    JPanel p = new JPanel(new GridLayout(1, 3));

    public Compteur() {
        super("Compteur");

        setVisible(true);

        p.add(bm);
        p.add(bp);
        p.add(br);
        add(tf, BorderLayout.CENTER);
        add(p, BorderLayout.SOUTH);

        bm.addActionListener(e -> {
            int res = Integer.parseInt(tf.getText());
            if (res > 0)
                tf.setText(String.valueOf(--res));
            else
                JOptionPane.showMessageDialog(this, "No Negative Value Allowed");
        });
        bp.addActionListener(e -> {
            int res = Integer.parseInt(tf.getText());
            tf.setText(String.valueOf(++res));
        });
        br.addActionListener(e -> tf.setText("0"));

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        pack();
    }

    public static void main(String[] args) {
        new Compteur();
    }
}