package converter;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Converter extends JFrame implements ActionListener {
    JLabel res = new JLabel("Results: ");

    JRadioButton ed = new JRadioButton("euro -> dinars");
    JRadioButton de = new JRadioButton("dinars -> euro");
    ButtonGroup bg = new ButtonGroup();
    JButton b = new JButton("Convert");

    JLabel tl = new JLabel("Enter amount to convert: ");
    JTextField tf = new JTextField("");

    JPanel p1 = new JPanel(new GridLayout(2, 1));
    JPanel p2 = new JPanel(new GridLayout(2, 2));

    public Converter() {
        super("Converter");
        setVisible(true);
        b.setEnabled(false);

        p1.add(de);
        p1.add(ed);
        bg.add(de);
        bg.add(ed);

        p2.add(tl);
        p2.add(tf);
        p2.add(p1);
        p2.add(b);

        add(p2, BorderLayout.CENTER);
        add(res, BorderLayout.SOUTH);

        b.addActionListener(this);
        ed.addActionListener(this);
        de.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }

    public static void main(String[] args) {
        new Converter();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();

        if (o instanceof JButton) {
            try {
                double v = Double.parseDouble(tf.getText());
                double r;
                if (ed.isSelected()) {
                    r = v * 3.3;
                } else
                    r = v / 3.3;

                res.setText("Resultat: " + r);

            } catch (NumberFormatException e2) {
                JOptionPane.showMessageDialog(this, e2.getMessage());
            }
        } else
            b.setEnabled(true);
    }
}
