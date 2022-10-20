package gui;

import aplicacion.Pacto;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaPactos extends AbstractTableModel {

    private java.util.List<Pacto> pactos;

    public ModeloTablaPactos() {
        this.pactos = new java.util.ArrayList<>();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return pactos.size();
    }

    @Override
    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "Fecha de venta";
                break;
            case 1:
                nombre = "Empresa";
                break;
            case 2:
                nombre = "Cantidad";
                break;
            case 3:
                nombre = "Precio/part.";
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
                resultado = pactos.get(row).getFechaVenta();
                break;
            case 1:
                resultado = pactos.get(row).getNombreEmpresa();
                break;
            case 2:
                resultado = pactos.get(row).getCantidad();
                break;
            case 3:
                resultado = pactos.get(row).getPrecio();
                break;
        }
        return resultado;
    }

    public java.util.List<Pacto> getFilas() {
        return this.pactos;
    }

    public void setFilas(java.util.List<Pacto> pactos) {
        this.pactos = pactos;
        fireTableDataChanged();
    }

    public Pacto obtenerPacto(int i) {
        return this.pactos.get(i);
    }

}

