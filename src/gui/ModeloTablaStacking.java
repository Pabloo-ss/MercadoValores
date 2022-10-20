package gui;

import aplicacion.Stacked;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaStacking extends AbstractTableModel {

    private java.util.List<Stacked> apilados;

    public ModeloTablaStacking() {
        this.apilados = new java.util.ArrayList<>();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return apilados.size();
    }

    @Override
    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "Fecha";
                break;
            case 1:
                nombre = "Empresa";
                break;
            case 2:
                nombre = "Cantidad";
                break;
            case 3:
                nombre = "Interés";
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
                clase = java.lang.Integer.class;
                break;
            case 3:
                clase = java.lang.Float.class;
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
                resultado = apilados.get(row).getMarcaTemporal();
                break;
            case 1:
                resultado = apilados.get(row).getEmpresa();
                break;
            case 2:
                resultado = apilados.get(row).getCantidad();
                break;
            case 3:
                resultado = apilados.get(row).getInteres();
                break;
        }
        return resultado;
    }

    public java.util.List<Stacked> getFilas() {
        return this.apilados;
    }

    public void setFilas(java.util.List<Stacked> usuarios) {
        this.apilados = usuarios;
        fireTableDataChanged();
    }

    public Stacked obtenerStacked(int i) {
        return this.apilados.get(i);
    }

    public java.util.List<Stacked> obtenerStackedTodos(){
        return this.apilados;
    }
}
