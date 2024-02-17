package com.java_gui.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.java_gui.controller.GestionEtudiant;
import com.java_gui.controller.interfaces.IGestionEtudiant;
import com.java_gui.dao.Etudiant;

public class Tableau extends JFrame {

    /**
     * Upper Panel
     */
    // nom
    JLabel lnom = new JLabel("Nom:");
    JTextField tnom = new JTextField(15);
    JPanel pnom = new JPanel();
    // prenom
    JLabel lprenom = new JLabel("Prenom:");
    JTextField tprenom = new JTextField(15);
    JPanel pprenom = new JPanel();
    // filiere
    JLabel lfiliere = new JLabel("Filiere:");
    JComboBox<String> cfiliere = new JComboBox<>(new String[] { "Math", "Phy", "Info" });
    JPanel pfiliere = new JPanel();
    // sexe
    JLabel lsexe = new JLabel("Sexe:");
    JRadioButton bf = new JRadioButton("F");
    JRadioButton bm = new JRadioButton("M");
    ButtonGroup bg = new ButtonGroup();
    JPanel psexe = new JPanel();
    // ajout et annuler
    JButton ajout = new JButton("Ajouter");
    JButton annuler = new JButton("Annuler");
    JPanel p1 = new JPanel(new BorderLayout());
    JPanel c1 = new JPanel(new GridLayout(2, 2)); // inputs
    JPanel s1 = new JPanel(); // buttons

    /**
     * Lower Paner
     */
    // recherche
    JLabel lrechercher = new JLabel("Rechercher Par Mot Clé:");
    JTextField trechercher = new JTextField(15);
    JButton rechercher = new JButton("Rechercher");
    JPanel precherche = new JPanel();
    // tableau
    TableModel tm = new TableModel();
    JTable t = new JTable(tm);
    JScrollPane jsp = new JScrollPane(t);
    // layout
    JPanel p2 = new JPanel(new BorderLayout());
    JPanel n2 = new JPanel(); // recherche
    JPanel c2 = new JPanel(new GridLayout(1, 1)); // tableau

    public Tableau() {
        super("Gestion Etudiant");
        IGestionEtudiant geDB;
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        try {
            geDB = new GestionEtudiant();

            tm.chargerTableau(geDB.listeDesEtudiants());

            /**
             * Uper Panel
             */
            bg.add(bf);
            bg.add(bm);
            pnom.add(lnom);
            pnom.add(tnom);
            pprenom.add(lprenom);
            pprenom.add(tprenom);
            pfiliere.add(lfiliere);
            pfiliere.add(cfiliere);
            psexe.add(lsexe);
            psexe.add(bf);
            psexe.add(bm);

            // events
            ajout.addActionListener(e -> {
                Etudiant ee = new Etudiant();
                String sexe = "";
                if (bf.isSelected())
                    sexe = "F";
                if (bm.isSelected())
                    sexe = "M";

                if (tnom.getText().equals("") || tprenom.getText().equals("") || sexe.equals("")) {
                    JOptionPane.showMessageDialog(this, "Check Missing inputes", "Input Error",
                            JOptionPane.YES_NO_CANCEL_OPTION);
                } else {
                    // fill students
                    ee.setNom(tnom.getText());
                    ee.setPrenom(tprenom.getText());
                    ee.setFiliere(cfiliere.getSelectedItem().toString());
                    ee.setSexe(sexe);
                    // add student
                    geDB.ajouterEtudiant(ee);
                    // recharge table
                    tm.chargerTableau(geDB.listeDesEtudiants());
                    // empty inputs
                    tnom.setText("");
                    tprenom.setText("");
                    bg.clearSelection();
                }
            });
            annuler.addActionListener(e -> {
                tnom.setText("");
                tprenom.setText("");
                bg.clearSelection();
                trechercher.setText("");
            });
            rechercher.addActionListener(e -> {
                List<Etudiant> l;
                l = geDB.rechercherParMC(trechercher.getText());
                tm.chargerTableau(geDB.listeDesEtudiants());
            });

            c1.add(pnom);
            c1.add(pprenom);
            c1.add(pfiliere);
            c1.add(psexe);

            s1.add(ajout);
            s1.add(annuler);

            p1.add(c1, BorderLayout.CENTER);
            p1.add(s1, BorderLayout.SOUTH);

            /*
             * Lower Panel
             */
            precherche.add(lrechercher);
            precherche.add(trechercher);
            precherche.add(rechercher);
            n2.add(precherche);

            c2.add(jsp);

            p2.add(n2, BorderLayout.NORTH);
            p2.add(c2, BorderLayout.CENTER);

            this.add(p1, BorderLayout.NORTH);
            this.add(p2);

            pack();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), e.getSQLState(),
                    JOptionPane.CLOSED_OPTION);
        }

    }
}
