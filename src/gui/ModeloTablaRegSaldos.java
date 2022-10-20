package gui;

import javax.swing.table.*;
import aplicacion.Usuario;

public class ModeloTablaRegSaldos extends AbstractTableModel {

    private java.util.List<Usuario> usuarios;

    public ModeloTablaRegSaldos() {
        this.usuarios = new java.util.ArrayList<>();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public String getColumnName(int col) {
        String nombre = "";

        switch (col) {
            case 0:
                nombre = "ID";
                break;
            case 1:
                nombre = "Tipo";
                break;
            case 2:
                nombre = "Saldo";
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
                clase = java.lang.String.class;
                break;
            case 2:
                clase = java.lang.Float.class;
                break;
        }

        return clase;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col == 2;
    }
    
    @Override
    public void setValueAt(Object v, int row, int col) {
        switch (col) {
            case 2:
                usuarios.get(row).setSaldoDisponible((Float) v);
                break;
        }
    }

    @Override
    public Object getValueAt(int row, int col) {
        Object resultado = null;

        switch (col) {
            case 0:
                resultado = usuarios.get(row).getId();
                break;
            case 1:
                resultado = usuarios.get(row).getTipo().name();
                break;
            case 2:
                resultado = usuarios.get(row).getSaldoDisponible();
                break;
        }
        return resultado;
    }

    public java.util.List<Usuario> getFilas() {
        return this.usuarios;
    }

    public void setFilas(java.util.List<Usuario> usuarios) {
        this.usuarios = usuarios;
        fireTableDataChanged();
    }

    public Usuario obtenerUsuario(int i) {
        return this.usuarios.get(i);
    }

    public java.util.List<Usuario> obtenerUsuariosTodos(){
        return this.usuarios;
    }
}
