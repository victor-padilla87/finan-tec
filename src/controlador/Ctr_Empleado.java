package controlador;

import Conexion.Conexionmysql;
import modelo.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextField;

public class Ctr_Empleado {

    public boolean guardarEmpleado(Empleado empleado, String fechaIngreso) {
        boolean respuesta = false;
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();

        try {
            // Validar la cédula
            if (empleado.getCedula() == null || empleado.getCedula().trim().isEmpty()) {
                System.out.println("Error: La cédula está vacía.");
                return false;
            }

            String sql = "INSERT INTO empleados (cedula, nombre, apellido, direccion, telefono, cargo, salario, deducciones, fondo_Pensiones, eps, fechaIngreso) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement consulta = cn.prepareStatement(sql);

            consulta.setString(1, empleado.getCedula());
            consulta.setString(2, empleado.getNombre());
            consulta.setString(3, empleado.getApellido());
            consulta.setString(4, empleado.getDireccion());
            consulta.setString(5, empleado.getTelefono());
            consulta.setString(6, empleado.getCargo());
            consulta.setDouble(7, empleado.getSalario());
            consulta.setDouble(8, empleado.getDeducciones());
            consulta.setString(9, empleado.getFondo_pensiones());
            consulta.setString(10, empleado.getEps());

            // Convertir y asignar la fecha de ingreso correctamente
            java.sql.Date fechaIngresoSQL = java.sql.Date.valueOf(fechaIngreso);
            consulta.setDate(11, fechaIngresoSQL);

            // Ejecutar la consulta y verificar si se insertó al menos una fila
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar el empleado: " + e.getMessage());
        } finally {
            // Cerrar la conexión correctamente
            try {
                if (cn != null && !cn.isClosed()) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return respuesta;
    }
    
    // metodo para actualizar cliente
    public boolean Actualizar(Empleado objeto, int idempleado) {
        boolean respuesta = false;
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();

        try {
            // Preparar la consulta de actualización
            String sql = "UPDATE empleados SET nombre = ?, apellido = ?, cedula = ?, direccion = ?, telefono = ?, cargo = ?, salario = ?, deducciones = ?, eps = ?, fondo_pensiones = ?, fechaIngreso = ?  WHERE idempleado = ?";
            PreparedStatement consulta = cn.prepareStatement(sql);

            // Asignar valores a los parámetros
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setString(3, objeto.getCedula());
            consulta.setString(4, objeto.getDireccion());
            consulta.setString(5, objeto.getTelefono());
            consulta.setString(6, objeto.getCargo());
            consulta.setDouble(7, objeto.getSalario());
            consulta.setDouble(8, objeto.getDeducciones());
            consulta.setString(9, objeto.getEps());
            consulta.setString(10, objeto.getFondo_pensiones());
            consulta.setString(11, objeto.getFechaIngreso());
            consulta.setInt(12, idempleado);

            // Ejecutar la actualización y verificar si se afectó alguna fila
            if (consulta.executeUpdate() > 0) {
                respuesta = true;  // La actualización fue exitosa
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar el cliente: " + e.getMessage());
        } finally {
            // Cerrar la conexión
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return respuesta;
    }

    // Método para eliminar un empleado
    public boolean eliminarEmpleado(int idEmpleado) {
        boolean respuesta = false;
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();

        try {
            String sql = "DELETE FROM empleados WHERE idEmpleado = ?";
            PreparedStatement consulta = cn.prepareStatement(sql);
            consulta.setInt(1, idEmpleado);

            if (consulta.executeUpdate() > 0) {
                respuesta = true; // La eliminación fue exitosa
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el empleado: " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return respuesta;
    }

    // Método para generar un reporte de nómina (resumen)
    public String generarReporteNomina() {
        StringBuilder reporte = new StringBuilder();
        double totalSalarios = 0.0;
        int totalEmpleados = 0;

        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();

        String sql = "SELECT nombre, apellido, cargo, salario FROM empleados";

        try (PreparedStatement statement = cn.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            reporte.append("Reporte de Nómina\n");
            reporte.append("------------------------------\n");

            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String cargo = resultSet.getString("cargo");
                double salario = resultSet.getDouble("salario");

                reporte.append(nombre).append(" ").append(apellido)
                        .append(" - Cargo: ").append(cargo)
                        .append(" - Salario: $").append(salario).append("\n");
                totalSalarios += salario;
                totalEmpleados++;
            }

            reporte.append("------------------------------\n");
            reporte.append("Total Empleados: ").append(totalEmpleados).append("\n");
            reporte.append("Total Pagado: $").append(totalSalarios).append("\n");

        } catch (SQLException e) {
            System.out.println("Error al generar el reporte de nómina: " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return reporte.toString();
    }

    // Método para calcular el salario de un empleado específico
    public double calcularSalario(String nombreEmpleado) {
        double salarioCalculado = 0.0;

        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();

        String sql = "SELECT salario FROM empleados WHERE nombre = ?";

        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            statement.setString(1, nombreEmpleado);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                salarioCalculado = resultSet.getDouble("salario");
            } else {
                System.out.println("Empleado no encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Error al calcular el salario: " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return salarioCalculado;
    }

    // Método de ayuda para formatear una fecha de Date a String
    public String formatFecha(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(fecha);
    }
    
// obtener empleados
    public Empleado obtenerEmpleadoPorCedula(String cedula) {
        Empleado empleado = null;
        Conexionmysql conexion = new Conexionmysql();
        Connection cn = conexion.getConnection();

        String sql = "SELECT idempleado, cedula, nombre, apellido, direccion, telefono, cargo, salario, deducciones, fondo_Pensiones, eps, fechaIngreso FROM empleados WHERE cedula = ?";
        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            statement.setString(1, cedula);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Obtener los valores de la base de datos y crear un nuevo objeto Empleado
                    empleado = new Empleado(
                            resultSet.getInt("idempleado"),
                            resultSet.getString("cedula"),
                            resultSet.getString("nombre"),
                            resultSet.getString("apellido"),
                            resultSet.getString("direccion"),
                            resultSet.getString("telefono"),
                            resultSet.getString("cargo"),
                            resultSet.getDouble("salario"),
                            resultSet.getDouble("deducciones"),
                            resultSet.getString("fondo_Pensiones"),
                            resultSet.getString("eps"),
                            resultSet.getString("fechaIngreso")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener empleado por cédula: " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return empleado;
    }
}
