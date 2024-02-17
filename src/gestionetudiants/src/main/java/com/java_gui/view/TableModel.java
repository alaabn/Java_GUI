package com.java_gui.view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.java_gui.dao.Etudiant;

public class TableModel extends AbstractTableModel {
    private List<Etudiant> l;
    private String titres[] = { "Id", "Nom", "Prenom", "Filiere", "Sexe" };

    @Override
    public int getColumnCount() {
        return titres.length;
    }

    @Override
    public int getRowCount() {
        return l.size();
    }

    @Override
    public Object getValueAt(int line, int col) {
        switch (col) {
            case 0:
                return l.get(line).getId();
            case 1:
                return l.get(line).getNom();
            case 2:
                return l.get(line).getPrenom();
            case 3:
                return l.get(line).getFiliere();
            case 4:
                return l.get(line).getSexe();
        }
        return null;
    }

    @Override
    public String getColumnName(int col) {
        return titres[col];
    }

    public void chargerTableau(List<Etudiant> l) {
        this.l = l;
        fireTableDataChanged();
    }
}
