package gui;

import javax.swing.table.*;
import aplicacion.Prerregistro;

public class ModeloTablaRegPrerregistros extends AbstractTableModel {

    private java.util.List<Prerregistro> prerregistros;

    public ModeloTablaRegPrerregistros() {
        this.prerregistros = new java.util.ArrayList<>();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return prerregistros.size();
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
                nombre = "Tipo";
                break;
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
                clase = aplicacion.TipoUsuario.class;
                break;
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
                resultado = prerregistros.get(row).getMarcaTemporal();
                break;
            case 1:
                resultado = prerregistros.get(row).getUsuario().getId();
                break;
            case 2:
                resultado = prerregistros.get(row).getTipo();
                break;
        }
        return resultado;
    }

    public java.util.List<Prerregistro> getFilas() {
        return this.prerregistros;
    }

    public void setFilas(java.util.List<Prerregistro> prerregistros) {
        this.prerregistros = prerregistros;
        fireTableDataChanged();
    }

    public Prerregistro obtenerPrerregistro(int i) {
        return this.prerregistros.get(i);
    }

}
