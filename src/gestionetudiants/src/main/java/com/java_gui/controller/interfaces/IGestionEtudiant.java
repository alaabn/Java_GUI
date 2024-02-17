package com.java_gui.controller.interfaces;

import java.util.List;

import com.java_gui.dao.Etudiant;

public interface IGestionEtudiant {
    void ajouterEtudiant(Etudiant e);

    void supprimerEtudiant(int id);

    List<Etudiant> rechercherParMC(String mc);

    List<Etudiant> listeDesEtudiants();
}
