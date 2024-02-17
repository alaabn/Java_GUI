package com.java_gui.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java_gui.controller.interfaces.IGestionEtudiant;
import com.java_gui.dao.DBconnection;
import com.java_gui.dao.Etudiant;

public class GestionEtudiant implements IGestionEtudiant {
    Connection cnx;

    public GestionEtudiant() throws SQLException {
        cnx = DBconnection.getConnection();
    }

    @Override
    public void ajouterEtudiant(Etudiant e) {
        try {
            PreparedStatement ps = cnx
                    .prepareStatement("insert into etudiant (nom, prenom, filiere, sexe) values (?,?,?,?)");
            ps.setString(1, e.getNom());
            ps.setString(2, e.getPrenom());
            ps.setString(3, e.getFiliere());
            ps.setString(4, e.getSexe());
            ps.executeUpdate();

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    @Override
    public List<Etudiant> rechercherParMC(String mc) {
        List<Etudiant> l = new ArrayList<>();
        try {
            PreparedStatement ps = cnx
                    .prepareStatement("select * from etudiant where nom=? or prenom=?");
            ps.setString(1, mc);
            ps.setString(2, mc);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Etudiant e = new Etudiant();
                e.setId(rs.getInt(1));
                e.setNom(rs.getString(2));
                e.setPrenom(rs.getString(3));
                e.setFiliere(rs.getString(4));
                e.setSexe(rs.getString(5));

                l.add(e);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return l;
    }

    @Override
    public List<Etudiant> listeDesEtudiants() {
        List<Etudiant> l = new ArrayList<>();
        try {
            PreparedStatement ps = cnx
                    .prepareStatement("select * from etudiant");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Etudiant e = new Etudiant();
                e.setId(rs.getInt(1));
                e.setNom(rs.getString(2));
                e.setPrenom(rs.getString(3));
                e.setFiliere(rs.getString(4));
                e.setSexe(rs.getString(5));

                l.add(e);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return l;
    }

    @Override
    public void supprimerEtudiant(int id) {
        try {
            PreparedStatement ps = cnx
                    .prepareStatement("delete * from etudiant where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

}
