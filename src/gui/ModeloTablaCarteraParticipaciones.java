package gui;

import aplicacion.Participaciones;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaCarteraParticipaciones extends AbstractTableModel {

    private java.util.List<Participaciones> participaciones;

    public ModeloTablaCarteraParticipaciones() {
        this.participaciones = new java.util.ArrayList<>();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return participaciones.size();
    }

    @Override
    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "Empresa";
                break;
            case 1:
                nombre = "Cantidad";
                break;
            case 2:
                nombre = "Precio/part.";
                break;
            case 3:
                nombre = "En el mercado";
                break;
        }

        return nombre;
    }

    @Override
    public Class getColumnClass(int col) {
        Class clase = null;

        switch (col) {
            case 0:
                clase = java.lang.String.class;
                break;
            case 1:
                clase = java.lang.Integer.class;
                break;
            case 2:
                clase = java.lang.Float.class;
                break;
            case 3:
                clase = java.lang.String.class;
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
                resultado = participaciones.get(row).getEmpresa();
                break;
            case 1:
                resultado = participaciones.get(row).getCantidad();
                break;
            case 2:
                resultado = participaciones.get(row).getPrecio();
                break;
            case 3:
                if (participaciones.get(row).getPrecio() > 0)
                    resultado = "Sí";
                else
                    resultado = "No";
        }
        return resultado;
    }

    public java.util.List<Participaciones> getFilas() {
        return this.participaciones;
    }

    public void setFilas(java.util.List<Participaciones> participaciones) {
        this.participaciones = participaciones;
        fireTableDataChanged();
    }

    public Participaciones obtenerParticipacion(int i) {
        return this.participaciones.get(i);
    }

}

