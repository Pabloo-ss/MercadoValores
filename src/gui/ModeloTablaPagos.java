package gui;

import javax.swing.table.*;
import aplicacion.PagoBeneficios;

public class ModeloTablaPagos extends AbstractTableModel {

    private java.util.List<PagoBeneficios> pagos;

    public ModeloTablaPagos() {
        this.pagos = new java.util.ArrayList<>();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return pagos.size();
    }

    @Override
    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "Fecha de pago";
                break;
            case 1:
                nombre = "ID de la empresa";
                break;
            case 2:
                nombre = "Importe/part.";
                break;
            case 3:
                nombre = "Part./usuario";
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
                resultado = pagos.get(row).getFecha();
                break;
            case 1:
                resultado = pagos.get(row).getIdEmpresa();
                break;
            case 2:
                resultado = pagos.get(row).getImporteParticipacion();
                break;
            case 3:
                resultado = pagos.get(row).getParticipacionesPorUsuario();
                break;
        }
        return resultado;
    }

    public java.util.List<PagoBeneficios> getFilas() {
        return this.pagos;
    }

    public void setFilas(java.util.List<PagoBeneficios> pagos) {
        this.pagos = pagos;
        fireTableDataChanged();
    }

    public PagoBeneficios obtenerPagoBeneficios(int i) {
        return this.pagos.get(i);
    }

}
