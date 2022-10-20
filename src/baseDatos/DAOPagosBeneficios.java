package baseDatos;

import aplicacion.PagoBeneficios;
import java.sql.*;

public class DAOPagosBeneficios extends AbstractDAO {

    public DAOPagosBeneficios(Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public java.util.List<PagoBeneficios> buscarPagosBeneficios(String idEmpresa) {
        java.util.ArrayList<PagoBeneficios> pagos = new java.util.ArrayList<>();
        Connection con;
        PreparedStatement stmPagos = null;
        ResultSet rsPagos;

        con = this.getConexion();
        try {
            stmPagos = con.prepareStatement("select * "
                    + "from informacionbeneficios "
                    + "where empresa like ?");
            stmPagos.setString(1, "%" + idEmpresa + "%");
            rsPagos = stmPagos.executeQuery();

            while (rsPagos.next()) {
                pagos.add(new PagoBeneficios(rsPagos.getString("empresa"),
                        rsPagos.getTimestamp("fechapago"),
                        rsPagos.getFloat("importePorParticipacion"),
                        rsPagos.getInt("cantidadParticipaciones"),
                        rsPagos.getInt("participacionesPorUsuario"),
                        rsPagos.getInt("usuariosConParticipaciones")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                stmPagos.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return pagos;
    }

    public boolean pagarBeneficios(PagoBeneficios pb) {
        Connection con;
        PreparedStatement stmPago = null;
        ResultSet rsPago;
        int cantidadTotalPart = 0;
        float saldoDisponible = 0;
        int participacionesDisponibles = 0;
        int usuariosConParticipaciones = 0;

        float nuevoImportePorPart;
        int participacionesPendientes;

        boolean resultado = false;

        con = this.getConexion();
        try {
            con.setAutoCommit(false);

            // Si existe un anuncio de la empresa, se borra y se ejecuta el primer caso de la funcionalidad
            stmPago = con.prepareStatement("select * from informacionBeneficios where empresa = ?");
            stmPago.setString(1, pb.getIdEmpresa());
            rsPago = stmPago.executeQuery();
            if (rsPago.next()) {
                PagoBeneficios pbAnuncio = new PagoBeneficios(rsPago.getString("empresa"), rsPago.getTimestamp("fechapago"),
                        rsPago.getFloat("importeporparticipacion"), rsPago.getInt("cantidadparticipaciones"),
                        rsPago.getInt("participacionesporusuario"), rsPago.getInt("usuariosconparticipaciones"));

                stmPago = con.prepareStatement("delete from informacionBeneficios where empresa = ?");
                stmPago.setString(1, pbAnuncio.getIdEmpresa());
                stmPago.executeUpdate();

                // Se obtiene el número de participaciones que otros usuarios tienen de la empresa y cuántos usuarios tienen participaciones de la misma
                stmPago = con.prepareStatement("select sum(cantidad) as cantidadTotal "
                        + "from tenerParticipaciones "
                        + "where usuario != empresa and empresa = ?");
                stmPago.setString(1, pb.getIdEmpresa());
                rsPago = stmPago.executeQuery();
                if (rsPago.next()) {
                    cantidadTotalPart = rsPago.getInt("cantidadTotal");
                } else {
                    System.out.println("Nunca debería chegar aquí");
                }

                // Se divide la cantidad total entre el saldo bloqueado para obtener el importe por usuario real
                nuevoImportePorPart = ((pbAnuncio.getImporteParticipacion() * pbAnuncio.getCantidadParticipaciones()) / cantidadTotalPart);

                // Se reparte eso entre los usuarios con participaciones
                stmPago = con.prepareStatement("select * "
                        + "from tenerParticipaciones as tp, usuario as u "
                        + "where tp.usuario != tp.empresa and tp.usuario = u.id "
                        + "and tp.empresa = ?");
                stmPago.setString(1, pb.getIdEmpresa());
                rsPago = stmPago.executeQuery();
                while (rsPago.next()) {
                    stmPago = con.prepareStatement("update usuario set saldoDisponible = saldoDisponible + ? "
                            + "where id = ?");
                    stmPago.setFloat(1, nuevoImportePorPart * rsPago.getInt("cantidad"));
                    stmPago.setString(2, rsPago.getString("id"));
                    stmPago.executeUpdate();
                }

                // Para las participaciones, éstas se darán de mayor a menor número de participaciones de la empresa
                stmPago = con.prepareStatement("select * from tenerparticipaciones "
                        + "where usuario != empresa and empresa = ? "
                        + "order by cantidad desc");
                stmPago.setString(1, pbAnuncio.getIdEmpresa());
                rsPago = stmPago.executeQuery();
                participacionesPendientes = pbAnuncio.getParticipacionesPorUsuario() * pbAnuncio.getUsuariosConParticipaciones();
                while (rsPago.next() && (participacionesPendientes > 0)) {
                    stmPago = con.prepareStatement("update tenerparticipaciones set cantidad = cantidad + ? "
                            + "where usuario = ? and empresa = ?");
                    stmPago.setInt(1, pbAnuncio.getParticipacionesPorUsuario());
                    stmPago.setString(2, rsPago.getString("usuario"));
                    stmPago.setString(3, pbAnuncio.getIdEmpresa());
                    stmPago.executeUpdate();
                    participacionesPendientes -= pbAnuncio.getParticipacionesPorUsuario();
                }

                // Se actualiza el saldo bloqueado y las participaciones bloqueadas de la empresa
                stmPago = con.prepareStatement("update empresa set saldoBloqueado = saldoBloqueado - ?,"
                        + "partiBloqueadas = partiBloqueadas - ? "
                        + "where usuario = ?");
                stmPago.setFloat(1, pbAnuncio.getImporteParticipacion() * pbAnuncio.getCantidadParticipaciones());
                stmPago.setInt(2, pbAnuncio.getParticipacionesPorUsuario() * pbAnuncio.getUsuariosConParticipaciones());
                stmPago.setString(3, pb.getIdEmpresa());
                stmPago.executeUpdate();

                resultado = true;
                con.commit();
            } // Si no tiene anuncio previo, se ejecuta el segundo caso de la funcionalidad
            else {
                // Se obtiene el número de participaciones que otros usuarios tienen de la empresa y cuántos usuarios tienen participaciones de la misma
                stmPago = con.prepareStatement("select sum(cantidad) as cantidadTotal, count(*) as usuariosConParticipaciones "
                        + "from tenerParticipaciones "
                        + "where usuario != empresa and empresa = ?");
                stmPago.setString(1, pb.getIdEmpresa());
                rsPago = stmPago.executeQuery();
                if (rsPago.next()) {
                    cantidadTotalPart = rsPago.getInt("cantidadTotal");
                    usuariosConParticipaciones = rsPago.getInt("usuariosConParticipaciones");
                } else {
                    System.out.println("Nunca debería chegar aquí");
                }

                // Se obtiene el saldo disponible de la empresa
                stmPago = con.prepareStatement("select saldoDisponible from usuario where id = ?");
                stmPago.setString(1, pb.getIdEmpresa());
                rsPago = stmPago.executeQuery();
                if (rsPago.next()) {
                    saldoDisponible = rsPago.getFloat("saldoDisponible");
                } else {
                    System.out.println("Nunca debería chegar aquí");
                }

                // Se obtienen las participaciones propias de la empresa
                stmPago = con.prepareStatement("select cantidad from tenerParticipaciones where usuario = empresa and empresa = ?");
                stmPago.setString(1, pb.getIdEmpresa());
                rsPago = stmPago.executeQuery();
                if (rsPago.next()) {
                    participacionesDisponibles = rsPago.getInt("cantidad");
                } else {
                    System.out.println("Nunca debería chegar aquí");
                }

                // Si la empresa tiene saldo disponible suficiente y participaciones suficientes...
                if (((cantidadTotalPart * pb.getImporteParticipacion()) <= saldoDisponible)
                        && ((pb.getParticipacionesPorUsuario() * usuariosConParticipaciones) <= participacionesDisponibles)) {

                    // Repartición de importe
                    stmPago = con.prepareStatement("select * "
                            + "from tenerParticipaciones as tp, usuario as u "
                            + "where tp.usuario != tp.empresa and tp.usuario = u.id "
                            + "and tp.empresa = ?");
                    stmPago.setString(1, pb.getIdEmpresa());
                    rsPago = stmPago.executeQuery();
                    while (rsPago.next()) {
                        stmPago = con.prepareStatement("update usuario set saldoDisponible = saldoDisponible + ? "
                                + "where id = ?");
                        stmPago.setFloat(1, rsPago.getInt("cantidad") * pb.getImporteParticipacion());
                        stmPago.setString(2, rsPago.getString("id"));
                        stmPago.executeUpdate();
                    }

                    // Repartición de participaciones
                    stmPago = con.prepareStatement("update tenerParticipaciones set cantidad = cantidad + ? "
                            + "where usuario != empresa and empresa = ?");
                    stmPago.setInt(1, pb.getParticipacionesPorUsuario());
                    stmPago.setString(2, pb.getIdEmpresa());
                    stmPago.executeUpdate();

                    // Se actualiza el saldo de la empresa
                    stmPago = con.prepareStatement("update usuario set saldoDisponible = saldoDisponible - ? "
                            + "where id = ?");
                    stmPago.setFloat(1, pb.getImporteParticipacion() * cantidadTotalPart);
                    stmPago.setString(2, pb.getIdEmpresa());
                    stmPago.executeUpdate();

                    // Se actualizan las participaciones de la empresa
                    stmPago = con.prepareStatement("update tenerParticipaciones set cantidad = cantidad - ? "
                            + "where usuario = empresa and empresa = ?");
                    stmPago.setInt(1, pb.getParticipacionesPorUsuario() * usuariosConParticipaciones);
                    stmPago.setString(2, pb.getIdEmpresa());
                    stmPago.executeUpdate();

                    resultado = true;
                    con.commit();
                } else {
                    this.getFachadaAplicacion().muestraExcepcion("La empresa no tiene saldo disponible suficiente o participaciones suficientes\n"
                            + "para pagar los beneficios");
                    con.rollback();
                }
            }
        } catch (SQLException e) {
            try {
                con.rollback();
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(ex.getMessage());
            }
        } finally {
            try {
                con.setAutoCommit(true);
                stmPago.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }

    public boolean anunciarPago(PagoBeneficios pb) {
        Connection con;
        PreparedStatement stmAnuncio = null;
        ResultSet rsAnuncio;
        int cantidadTotalPart = 0;
        float saldoDisponible = 0;
        int participacionesDisponibles = 0;
        int usuariosConParticipaciones = 0;
        boolean resultado = false;

        con = this.getConexion();
        try {
            con.setAutoCommit(false);

            // Se obtiene el número de participaciones que otros usuarios tienen de la empresa y cuántos usuarios tienen participaciones de la misma
            stmAnuncio = con.prepareStatement("select sum(cantidad) as cantidadTotal, count(*) as usuariosConParticipaciones "
                    + "from tenerParticipaciones "
                    + "where usuario != empresa and empresa = ?");
            stmAnuncio.setString(1, pb.getIdEmpresa());
            rsAnuncio = stmAnuncio.executeQuery();
            if (rsAnuncio.next()) {
                cantidadTotalPart = rsAnuncio.getInt("cantidadTotal");
                usuariosConParticipaciones = rsAnuncio.getInt("usuariosConParticipaciones");
            } else {
                System.out.println("Nunca debería chegar aquí");
            }

            // Se inserta el anuncio
            stmAnuncio = con.prepareStatement("insert into informacionBeneficios values(?,?,?,?,?,?)");
            stmAnuncio.setString(1, pb.getIdEmpresa());
            stmAnuncio.setTimestamp(2, pb.getFecha());
            stmAnuncio.setFloat(3, pb.getImporteParticipacion());
            stmAnuncio.setInt(4, cantidadTotalPart);
            stmAnuncio.setInt(5, pb.getParticipacionesPorUsuario());
            stmAnuncio.setInt(6, usuariosConParticipaciones);
            stmAnuncio.executeUpdate();

            // Se obtiene el saldo disponible de la empresa
            stmAnuncio = con.prepareStatement("select saldoDisponible from usuario where id = ?");
            stmAnuncio.setString(1, pb.getIdEmpresa());
            rsAnuncio = stmAnuncio.executeQuery();
            if (rsAnuncio.next()) {
                saldoDisponible = rsAnuncio.getFloat("saldoDisponible");
            } else {
                System.out.println("Nunca debería chegar aquí");
            }

            // Se obtienen las participaciones propias de la empresa
            stmAnuncio = con.prepareStatement("select cantidad from tenerParticipaciones where usuario = empresa and empresa = ?");
            stmAnuncio.setString(1, pb.getIdEmpresa());
            rsAnuncio = stmAnuncio.executeQuery();
            if (rsAnuncio.next()) {
                participacionesDisponibles = rsAnuncio.getInt("cantidad");
            } else {
                System.out.println("Nunca debería chegar aquí");
            }

            // Si la empresa tiene saldo disponible suficiente y participaciones suficientes...
            if (((pb.getImporteParticipacion() * cantidadTotalPart) <= saldoDisponible)
                    && ((pb.getParticipacionesPorUsuario() * usuariosConParticipaciones) <= participacionesDisponibles)) {
                // Se actualizan el saldo bloqueado y las participaciones bloqueadas
                stmAnuncio = con.prepareStatement("update empresa set saldoBloqueado = saldoBloqueado + ?, "
                        + "partiBloqueadas = partiBloqueadas + ? "
                        + "where usuario = ?");
                stmAnuncio.setFloat(1, pb.getImporteParticipacion() * cantidadTotalPart);
                stmAnuncio.setInt(2, pb.getParticipacionesPorUsuario() * usuariosConParticipaciones);
                stmAnuncio.setString(3, pb.getIdEmpresa());
                stmAnuncio.executeUpdate();

                // Se actualizan las participaciones disponibles
                stmAnuncio = con.prepareStatement("update tenerparticipaciones set cantidad = cantidad - ? "
                        + "where usuario = empresa and empresa = ?");
                stmAnuncio.setInt(1, pb.getParticipacionesPorUsuario() * usuariosConParticipaciones);
                stmAnuncio.setString(2, pb.getIdEmpresa());

                // Se actualiza el saldo disponible
                stmAnuncio = con.prepareStatement("update usuario set saldoDisponible = saldoDisponible - ? "
                        + "where id = ?");
                stmAnuncio.setFloat(1, pb.getImporteParticipacion() * cantidadTotalPart);
                stmAnuncio.setString(2, pb.getIdEmpresa());
                stmAnuncio.executeUpdate();
                resultado = true;
                con.commit();
            } else {
                this.getFachadaAplicacion().muestraExcepcion("La empresa no tiene saldo disponible suficiente o participaciones suficientes\n"
                        + "para publicar el anuncio");
                con.rollback();
            }
        } catch (SQLException e) {
            try {
                con.rollback();
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(ex.getMessage());
            }
        } finally {
            try {
                con.setAutoCommit(true);
                stmAnuncio.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }

    public void borrarPagoBeneficios(PagoBeneficios pb) {
        Connection con;
        PreparedStatement stmBorrado = null;

        con = this.getConexion();
        try {
            con.setAutoCommit(false);

            // Se desbloquean el saldo y las participaciones
            stmBorrado = con.prepareStatement("update empresa set saldoBloqueado = saldoBloqueado - ?, "
                    + "partiBloqueadas = partiBloqueadas - ? "
                    + "where usuario = ?");
            stmBorrado.setFloat(1, pb.getImporteParticipacion() * pb.getCantidadParticipaciones());
            stmBorrado.setInt(2, pb.getParticipacionesPorUsuario() * pb.getUsuariosConParticipaciones());
            stmBorrado.setString(3, pb.getIdEmpresa());
            stmBorrado.executeUpdate();

            // Se aumenta el saldo disponible
            stmBorrado = con.prepareStatement("update usuario set saldoDisponible = saldoDisponible + ? "
                    + "where id = ?");
            stmBorrado.setFloat(1, pb.getImporteParticipacion() * pb.getCantidadParticipaciones());
            stmBorrado.setString(2, pb.getIdEmpresa());
            stmBorrado.executeUpdate();

            // Se borra el anuncio
            stmBorrado = con.prepareStatement("delete from informacionbeneficios "
                    + "where empresa = ? and fechapago = ?");
            stmBorrado.setString(1, pb.getIdEmpresa());
            stmBorrado.setTimestamp(2, pb.getFecha());
            stmBorrado.executeUpdate();

            con.commit();
        } catch (SQLException e) {
            try {
                con.rollback();
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                this.getFachadaAplicacion().muestraExcepcion(ex.getMessage());
            }
        } finally {
            try {
                con.setAutoCommit(true);
                stmBorrado.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
}
