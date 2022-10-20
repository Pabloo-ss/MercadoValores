package gui;

import javax.swing.table.*;
import aplicacion.Baja;

public class ModeloTablaRegBajas extends AbstractTableModel {

    private java.util.List<Baja> bajas;

    public ModeloTablaRegBajas() {
        this.bajas = new java.util.ArrayList<>();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return bajas.size();
    }

    @Override
    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "Marca temporal";
                break;
            case 1:
                nombre = "ID";
                break;
            case 2:
                nombre = "Saldo disponible";
                break;
            case 3:
                nombre = "Num. participaciones";
        }

        return nombre;
    }

    @Override
    public Class getColumnClass(int col) {
        Class clase = null;

        switch (col) {
            case 0:
                clase = java.sql.Timestamp.class;
                break;
            case 1:
                clase = java.lang.String.class;
                break;
            case 2:
                clase = java.lang.Float.class;
                break;
            case 3:
                clase = java.lang.Integer.class;
        }

        return clase;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Object resultado = null;

        switch (col) {
            case 0:
                resultado = bajas.get(row).getMarcaTemporal();
                break;
            case 1:
                resultado = bajas.get(row).getUsuario().getId();
                break;
            case 2:
                resultado = bajas.get(row).getUsuario().getSaldoDisponible();
                break;
            case 3:
                resultado = bajas.get(row).getNumPart();
                break;
        }
        return resultado;
    }

    public java.util.List<Baja> getFilas() {
        return this.bajas;
    }

    public void setFilas(java.util.List<Baja> bajas) {
        this.bajas = bajas;
        fireTableDataChanged();
    }

    public Baja obtenerBaja(int i) {
        return this.bajas.get(i);
    }

}
